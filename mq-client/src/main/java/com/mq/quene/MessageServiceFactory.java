package com.mq.quene;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.service.IMessageService;
import com.mq.service.impl.MessageServiceImpl;
import com.mq.utils.PropertiesFileUtil;
import com.rabbitmq.client.ConnectionFactory;

/**
 * MQ工厂类
 * 
 * @author lenovo
 *
 */
public class MessageServiceFactory {

	private static Logger LOG = LoggerFactory.getLogger(MessageServiceFactory.class);

	/**
	 * MQservice 的实例 spring 注入
	 */
	private static IMessageService mqService;

	private static ConcurrentLinkedQueue<ObjectPool<RabbitConnection>> objectPools = new ConcurrentLinkedQueue<ObjectPool<RabbitConnection>>();

	/**
	 * 初始化MQ实例
	 * 
	 */
	public static IMessageService getService() {
		if (mqService == null) {
			try {
				mqService = initMessageService();
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("初始化消息服务失败", e);
			}
		}
		return mqService;
	}

	/**
	 * 初始化队列信息
	 * 
	 */
	private static IMessageService initMessageService() throws ConfigurationException {
		PropertiesFileUtil pf = PropertiesFileUtil.builder("queue.properties");
		String[] hosts = pf.getStringArray("mq.host");
		if (hosts != null && hosts.length > 0) {
			for (String host : hosts) {
				LOG.info("创建 {} 连接池", host);
				ConnectionFactory connectionFactory = new ConnectionFactory();
				connectionFactory.setAutomaticRecoveryEnabled(true);
				connectionFactory.setPort(pf.getInt("mq.port"));
				connectionFactory.setUsername(pf.getString("mq.username"));
				connectionFactory.setPassword(pf.getString("mq.password"));
				connectionFactory.setHost(host);
				RabbitConnPooledObjectFactory factory = new RabbitConnPooledObjectFactory(connectionFactory);
				ObjectPool<RabbitConnection> objectPoolPool = new GenericObjectPool<RabbitConnection>(factory);
				objectPoolPool = PoolUtils.synchronizedPool(objectPoolPool);
				objectPools.add(objectPoolPool);
			}
		}
		return new MessageServiceImpl(objectPools, pf);
	}

}
