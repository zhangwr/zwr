package com.monitor.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
@SuppressWarnings("serial")
@Table(name = "web_logger_info")
public class WebLoggerInfo extends BaseEntity {

	/**
	 * 创建时间
	 */
	@Id
	@Column(name = "createDate")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createdate;

	/**
	 * 消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 */
	@Column(name = "msgType")
	@JSONField(serialize=false)
	private Integer msgtype;

	/**
	 * 消息来源： 3：H5 4:Web
	 */
	@Column(name = "msgSource")
	private Integer msgsource;

	/**
	 * 身份标识(请求接口用户ID标识)
	 */
	@Column(name = "identityId")
	private String identityid;

	/**
	 * 用户名称(请求接口用户昵称)
	 */
	@Column(name = "userName")
	private String username;

	/**
	 * 来源IP
	 */
	private String ip;

	/**
	 * 接口名称
	 */
	@Column(name = "interfaceName")
	private String interfacename;

	/**
	 * 请求类型：1:get 2:post
	 */
	@Column(name = "requestType")
	private Integer requesttype;

	/**
	 * 执行总时间
	 */
	@Column(name = "executeTime")
	private BigDecimal executetime;

	/**
	 * 响应编码 200:成功，500失败
	 */
	private Integer code;

	/**
	 * 错误信息
	 */
	@Column(name = "errorMsg")
	private String errormsg;

	/**
	 * 获取创建时间
	 *
	 * @return createDate - 创建时间
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createdate
	 *            创建时间
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/**
	 * 获取消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 *
	 * @return msgType - 消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 */
	public Integer getMsgtype() {
		return msgtype;
	}

	/**
	 * 设置消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 *
	 * @param msgtype
	 *            消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 */
	public void setMsgtype(Integer msgtype) {
		this.msgtype = msgtype;
	}

	/**
	 * 获取消息来源： 3：H5 4:Web
	 *
	 * @return msgSource - 消息来源： 3：H5 4:Web
	 */
	public Integer getMsgsource() {
		return msgsource;
	}

	/**
	 * 设置消息来源： 3：H5 4:Web
	 *
	 * @param msgsource
	 *            消息来源： 3：H5 4:Web
	 */
	public void setMsgsource(Integer msgsource) {
		this.msgsource = msgsource;
	}

	/**
	 * 获取身份标识(请求接口用户ID标识)
	 *
	 * @return identityId - 身份标识(请求接口用户ID标识)
	 */
	public String getIdentityid() {
		return identityid;
	}

	/**
	 * 设置身份标识(请求接口用户ID标识)
	 *
	 * @param identityid
	 *            身份标识(请求接口用户ID标识)
	 */
	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	/**
	 * 获取用户名称(请求接口用户昵称)
	 *
	 * @return userName - 用户名称(请求接口用户昵称)
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名称(请求接口用户昵称)
	 *
	 * @param username
	 *            用户名称(请求接口用户昵称)
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取来源IP
	 *
	 * @return ip - 来源IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 设置来源IP
	 *
	 * @param ip
	 *            来源IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取接口名称
	 *
	 * @return interfaceName - 接口名称
	 */
	public String getInterfacename() {
		return interfacename;
	}

	/**
	 * 设置接口名称
	 *
	 * @param interfacename
	 *            接口名称
	 */
	public void setInterfacename(String interfacename) {
		this.interfacename = interfacename;
	}

	/**
	 * 获取请求类型：1:get 2:post
	 *
	 * @return requestType - 请求类型：1:get 2:post
	 */
	public Integer getRequesttype() {
		return requesttype;
	}

	/**
	 * 设置请求类型：1:get 2:post
	 *
	 * @param requesttype
	 *            请求类型：1:get 2:post
	 */
	public void setRequesttype(Integer requesttype) {
		this.requesttype = requesttype;
	}

	/**
	 * 获取执行总时间
	 *
	 * @return executeTime - 执行总时间
	 */
	public BigDecimal getExecutetime() {
		return executetime;
	}

	/**
	 * 设置执行总时间
	 *
	 * @param executetime
	 *            执行总时间
	 */
	public void setExecutetime(BigDecimal executetime) {
		this.executetime = executetime;
	}

	/**
	 * 获取响应编码 200:成功，500失败
	 *
	 * @return code - 响应编码 200:成功，500失败
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * 设置响应编码 200:成功，500失败
	 *
	 * @param code
	 *            响应编码 200:成功，500失败
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * 获取错误信息
	 *
	 * @return errorMsg - 错误信息
	 */
	public String getErrormsg() {
		return errormsg;
	}

	/**
	 * 设置错误信息
	 *
	 * @param errormsg
	 *            错误信息
	 */
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
}