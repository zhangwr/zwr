package com.mq.handler;

/**
 * 消息处理器
 */
public interface MessageHandler {

	/**
	 * 消息处理回调器
	 * 
	 * @param message
	 * @return 返回处理的结果 true:消息处理成功 ，false:消息处理失败
	 * @throws Exception
	 */
	boolean handle(Object message) throws Exception;

}
