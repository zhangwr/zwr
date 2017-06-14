package com.monitor.test.demo;

import java.util.Date;

/**
 * 
 * Title:公共请求入参
 * 
 * @author zhangwr
 * @date 2017年5月4日下午4:42:08
 */
public class CommonParam {
	/**
	 * 消息的唯一标识
	 */
	private String msgId;
	/**
	 * 消息来源
	 */
	private String msgSrc;
	/**
	 * 消息类型
	 */
	private String msgType;
	/**
	 * 请求时间
	 */
	private Date requestTimestamp;
	/**
	 * 预留信息
	 */
	private String srcReserve;

	/**
	 * 签名
	 */
	private String sign;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgSrc() {
		return msgSrc;
	}

	public void setMsgSrc(String msgSrc) {
		this.msgSrc = msgSrc;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Date getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public String getSrcReserve() {
		return srcReserve;
	}

	public void setSrcReserve(String srcReserve) {
		this.srcReserve = srcReserve;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
