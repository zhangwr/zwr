package com.monitor.test.demo;

/**
 * 
 * Title:公共相应类
 * 
 * @author zhangwr
 * @date 2017年5月5日上午11:08:21
 */
public class CommonResponse {

	/**
	 * 消息 ID
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
	 * 错误码
	 */
	private String resultCode;
	/**
	 * 错误信息
	 */
	private String resultMsg;
	/**
	 * 应答时间
	 */
	private String responseTimestamp;
	/**
	 * 预留信息
	 */
	private String srcReserve;

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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResponseTimestamp() {
		return responseTimestamp;
	}

	public void setResponseTimestamp(String responseTimestamp) {
		this.responseTimestamp = responseTimestamp;
	}

	public String getSrcReserve() {
		return srcReserve;
	}

	public void setSrcReserve(String srcReserve) {
		this.srcReserve = srcReserve;
	}

	@Override
	public String toString() {
		return "CommonResponse [msgId=" + msgId + ", msgSrc=" + msgSrc + ", msgType=" + msgType + ", resultCode="
				+ resultCode + ", resultMsg=" + resultMsg + ", responseTimestamp=" + responseTimestamp + ", srcReserve="
				+ srcReserve + "]";
	}

}
