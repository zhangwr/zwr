package com.mq.service.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.pool2.ObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.commons.Constant;
import com.mq.commons.Constant.Queues;
import com.mq.handler.MessageHandler;
import com.mq.quene.RabbitConnection;
import com.mq.quene.SubscribeMsgCallback;
import com.mq.service.IMessageService;
import com.mq.utils.JSONUtil;
import com.mq.utils.PropertiesFileUtil;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;

/**
 * 消息实现类
 * 
 */
public class MessageServiceImpl implements IMessageService {

	private static Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

	/**
	 * 转换器名称
	 */
	private final static String EXCHANGE_NAME = "my_exchange";

	/**
	 * 消息类型
	 */
	private final static String HEADER_TYPE = "__msg__type";

	/**
	 * 创建线程池
	 */
	private ExecutorService excutor = Executors.newFixedThreadPool(20);

	/**
	 * rabbitmq 连接池
	 */
	private Queue<ObjectPool<RabbitConnection>> objectPools;

	public MessageServiceImpl() {
	}

	public MessageServiceImpl(Queue<ObjectPool<RabbitConnection>> objectPoolPools, PropertiesFileUtil pf) {
		// this.objectPools = objectPoolPools;
		this.initService(objectPoolPools);
	}

	/**
	 * 初始化队列
	 * 
	 * @return
	 * 
	 */
	public MessageServiceImpl initService(Queue<ObjectPool<RabbitConnection>> objectPools) {
		this.objectPools = objectPools;
		RabbitConnection wrapConn = null;
		ObjectPool<RabbitConnection> connPool = this.nextPool();
		try {
			wrapConn = connPool.borrowObject();
			Channel channel = wrapConn.getChannel();
			// 初始化所有队列
			initQueues(channel);
		} catch (Exception e) {
			LOG.error("初始化队列信息失败 {}", e);
			throw new RuntimeException("初始化队列信息失败  ", e);
		} finally {
			returnObject(connPool, wrapConn);
		}
		return this;
	}

	/**
	 * 初始化队列
	 * 
	 */
	private void initQueues(Channel channel) throws IllegalArgumentException, IllegalAccessException, IOException {
		// 声明direct类型转发器
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		Class<?> clazz = Queues.class;
		Field[] fields = clazz.getFields();
		if (fields != null) {
			LOG.info("初始化队列信息....");
			for (Field field : fields) {
				Object queue = null;
				if ((queue = field.get(null)) == null) {
					LOG.info("初始化队列信息[{}]队列名称为空", field.getName());
					continue;
				}
				String tmp = queue.toString();
				Map<String, Object> args = new HashMap<String, Object>();
				args.put("x-ha-policy", "all");
				channel.queueDeclare(tmp, true, false, false, args);
				channel.queueBind(tmp, EXCHANGE_NAME, tmp);
				LOG.info("初始化Queue: {} 成功", tmp);
			}
		}
	}

	@Override
	public void sendMessage(Object message) throws Throwable {
		if (message == null) {
			throw new Throwable("发送的消息不能为空");
		}
		String queueName = Constant.Queues.MSG_SEND_QUEUE;
		ObjectPool<RabbitConnection> connPool = this.nextPool();
		RabbitConnection wrapConn = connPool.borrowObject();
		Channel channel = wrapConn.getChannel();
		try {
			LOG.debug(wrapConn.toString());
			// 消息持久化
			BasicProperties mp = setMsgTypeToProps(HEADER_TYPE, getMessageType(message));
			channel.basicPublish(EXCHANGE_NAME, queueName, mp, JSONUtil.object2Bytes(message));
			LOG.info("发送消息：" + message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable("发送消息出错");
		} finally {
			returnObject(connPool, wrapConn);
		}
	}

	/**
	 * 接收信息
	 */
	@Override
	public Object receiveMessage(String queueName) throws Throwable {
		RabbitConnection wrapConn = null;
		ObjectPool<RabbitConnection> connPool = this.nextPool();
		try {
			wrapConn = connPool.borrowObject();
			Channel channel = wrapConn.getChannel();
			GetResponse getResponse = channel.basicGet(queueName, true);
			if (getResponse != null) {
				String msgType = getMsgTypeFromProps(getResponse.getProps(), HEADER_TYPE);
				return JSONUtil.bytes2Object(getResponse.getBody(), msgType);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable("接收消息出错", e);
		} finally {
			returnObject(connPool, wrapConn);
		}
	}

	@Override
	public void subscribeQueue(String queueName, final MessageHandler handler) throws Throwable {
		RabbitConnection wrapConn = null;
		ObjectPool<RabbitConnection> connPool = this.nextPool();
		try {
			wrapConn = connPool.borrowObject();
			Channel channel = wrapConn.getConn().createChannel();
			this.subscribe(queueName, channel, handler);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable("接收消息出错", e);
		} finally {
			returnObject(connPool, wrapConn);
		}
	}

	private void subscribe(String queueName, Channel channel, final MessageHandler handler) throws IOException {
		channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
			// 消息处理
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,
					com.rabbitmq.client.AMQP.BasicProperties props, byte[] body) throws IOException {

				// 获取消息类型
				String msgType = getMsgTypeFromProps(props, HEADER_TYPE);
				Object msg = null;

				try {

					msg = JSONUtil.bytes2Object(body, msgType);
				} catch (Exception e) {

					LOG.error("消息反序列化出错, Message Type: {}", msgType, e);
					// 消息反序列化失败，将消息重新入队
					this.getChannel().basicNack(envelope.getDeliveryTag(), false, true);
				}

				// 处理消息，执行消息回调器
				if (msg != null) {
					excutor.execute(new SubscribeMsgCallback(msg, handler, this.getChannel(), envelope));
				}
			}
		});
	}

	/**
	 * 连接回收
	 * 
	 */
	private void returnObject(ObjectPool<RabbitConnection> pool, RabbitConnection wrapConn) {
		if (wrapConn != null) {
			try {
				pool.returnObject(wrapConn);
				this.objectPools.add(pool);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取信息头里面的指定信息
	 * 
	 * @param props
	 * @return
	 */
	private String getMsgTypeFromProps(BasicProperties props, String key) {
		if (props == null || props.getHeaders() == null) {
			return null;
		}
		Object typeObj = props.getHeaders().get(key);
		return typeObj == null ? null : typeObj.toString();
	}

	/**
	 * 设置消息持久化并设置消息头信息
	 * 
	 * @param props
	 * @param key
	 * @param value
	 */
	private BasicProperties setMsgTypeToProps(String key, Object value) {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(key, value);
		// 设置消息持久化
		BasicProperties props = new BasicProperties("text/plain", null, headers, 2, 0, null, null, null, null, null,
				null, null, null, null);
		return props;
	}

	/**
	 * 获取消息类型
	 * 
	 * @param message
	 * @return
	 */
	private Object getMessageType(Object message) {
		return message.getClass().getName();
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public ObjectPool<RabbitConnection> nextPool() {
		if (objectPools != null && objectPools.size() > 0) {
			ObjectPool<RabbitConnection> connPool = objectPools.poll();
			RabbitConnection wrapConn = null;
			try {
				wrapConn = connPool.borrowObject();
				return connPool != null && wrapConn.getConn().isOpen() ? connPool : nextPool();
			} catch (Exception e) {
				return nextPool();
			} finally {
				try {
					connPool.returnObject(wrapConn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
