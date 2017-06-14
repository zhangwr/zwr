package com.mq.service;

import com.mq.handler.MessageHandler;

/**
 * 队列服务接口
 * 
 *
 */
public interface IMessageService {
	/**
	 * 发送信息
	 * 
	 * @param queueName
	 * @param message
	 */
	public void sendMessage(String queueName, Object message) throws Throwable;

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

	/**
	 * 订阅Topic
	 * <p>
	 * 时时消费，多个客户端都会消费
	 * <p>
	 * 当Topic中有消息时, 执行MessageHandler
	 * </p>
	 * 
	 * @param topicName
	 * @param handler
	 *            消息处理器, 如果handle抛出异常, 消息不会被消费掉。
	 */
	public void subscribeTopic(String topicName, MessageHandler handler) throws Throwable;

}
