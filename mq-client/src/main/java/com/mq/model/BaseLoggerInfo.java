package com.mq.model;

import java.math.BigDecimal;

/**
 * web请求参数
 * 
 * @author lenovo
 *
 */
public class BaseLoggerInfo {
	/**
	 * 消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 */
	private Integer msgtype;

	/**
	 * 消息来源：1:IOS, 2:android, 3：H5 4:Web
	 */
	private Integer msgsource;

	/**
	 * 身份标识(请求接口用户ID标识)
	 */
	private String identityid;

	/**
	 * 用户名称(请求接口用户昵称)
	 */
	private String username;

	/**
	 * 来源IP
	 */
	private String ip;

	/**
	 * 接口名称
	 */
	private String interfacename;

	/**
	 * 请求类型：1:get 2:post
	 */
	private Integer requesttype;

	/**
	 * 执行总时间
	 */
	private BigDecimal executetime;

	/**
	 * 响应编码 200:成功，500失败
	 */
	private Integer code;

	/**
	 * 错误信息
	 */
	private String errormsg;

	public Integer getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(Integer msgtype) {
		this.msgtype = msgtype;
	}

	public Integer getMsgsource() {
		return msgsource;
	}

	public void setMsgsource(Integer msgsource) {
		this.msgsource = msgsource;
	}

	public String getIdentityid() {
		return identityid;
	}

	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInterfacename() {
		return interfacename;
	}

	public void setInterfacename(String interfacename) {
		this.interfacename = interfacename;
	}

	public Integer getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(Integer requesttype) {
		this.requesttype = requesttype;
	}

	public BigDecimal getExecutetime() {
		return executetime;
	}

	public void setExecutetime(BigDecimal executetime) {
		this.executetime = executetime;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		return "BaseLoggerInfo [msgtype=" + msgtype + ", msgsource=" + msgsource + ", identityid=" + identityid
				+ ", username=" + username + ", ip=" + ip + ", interfacename=" + interfacename + ", requesttype="
				+ requesttype + ", executetime=" + executetime + ", code=" + code + ", errormsg=" + errormsg + "]";
	}

}