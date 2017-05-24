package com.mq.service;

import java.util.Queue;

import org.apache.commons.pool2.ObjectPool;

import com.mq.handler.MessageHandler;
import com.mq.quene.RabbitConnection;
import com.mq.service.impl.MessageServiceImpl;

/**
 * 队列服务接口
 * 
 *
 */
public interface IMessageService {
	
	/**
	 * 初始化连接
	 * Description:
	 *  @return
	 *  MessageServiceImpl
	 * @author zhangwr
	 * @date 2017年5月2日下午2:10:22
	 */
	public MessageServiceImpl initService(Queue<ObjectPool<RabbitConnection>> objectPools);

	/**
	 * 发送信息
	 * 
	 * @param queueName
	 * @param message
	 */
	public void sendMessage(Object message) throws Throwable;

	/**
	 * 接收消息
	 * <p>
	 * 非时时推送,主动拉去信息
	 * 
	 * @param queueName
	 * @return 如果消息队列中无消息,返回null
	 * @throws GridyException
	 */
	public Object receiveMessage(String queueName) throws Throwable;

	/**
	 * 
	 * 订阅队列消息
	 * <p>
	 * 时时监听队列,但只会有一个客户端消费
	 * <p>
	 * 当队列中有消息时, 执行MessageHandler
	 * </p>
	 * 
	 * @param queueName
	 * @param handler
	 *             
	 * @throws GridyException
	 */
	public void subscribeQueue(String queueName, MessageHandler handler) throws Throwable;

}
