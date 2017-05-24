package com.mq.quene;

import java.io.IOException;

import com.mq.handler.MessageHandler;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;

/**
 * 
 * 消息回调器
 * 
 */
public class SubscribeMsgCallback implements Runnable {

	private Object msg;
	private MessageHandler handler;
	private Channel channel;
	private Envelope envelope;

	public SubscribeMsgCallback(Object msg, MessageHandler handler, Channel channel, Envelope envelope) {
		this.msg = msg;
		this.handler = handler;
		this.channel = channel;
		this.envelope = envelope;
	}

	@Override
	public void run() {
		try {
			boolean result = handler.handle(this.msg);
			if (result) {
				// 发送成功，消息回调
				basicAck(envelope, channel);
			} else {
				// 发送失败，重新入队列
				basicNack(envelope, channel);
			}
		} catch (Exception e) {
			try {
				// 发送失败，重新入队列
				basicNack(envelope, channel);
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 消息失败重新入队
	 * 
	 */
	private void basicNack(Envelope envelope, Channel channel) throws IOException {
		channel.basicNack(envelope.getDeliveryTag(), false, true);
	}

	/**
	 * 消息成功回调
	 * 
	 */
	private void basicAck(Envelope envelope, Channel channel) throws IOException {
		channel.basicAck(envelope.getDeliveryTag(), false);
	}
}