package com.monitor.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Table(name = "app_logger_info")
public class AppLoggerInfo extends BaseEntity {
	/**
	 * 创建时间
	 */
	@Id
	@Column(name = "createDate")
	//改注解的作用是将前台的日期格式的字符串转成日期型
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdate;

	/**
	 * 消息类型：1：请求日志，2:系统消息，3：短信，4:邮件
	 */
	@Column(name = "msgType")
	private Integer msgtype;

	/**
	 * 消息来源：1:IOS, 2:android
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
	 * ROM 版本
	 */
	@Column(name = "romVersion")
	private String romversion;

	/**
	 * 网络状态: 4G，wifi
	 */
	@Column(name = "netStatus")
	private String netstatus;

	/**
	 * CPU型号
	 */
	@Column(name = "cpuInfo")
	private String cpuinfo;

	/**
	 * 内存大小（当前使用的内存)
	 */
	@Column(name = "memorySize")
	private String memorysize;

	/**
	 * 硬盘大小
	 */
	@Column(name = "diskSize")
	private String disksize;

	/**
	 * 位置
	 */
	private String loaction;

	/**
	 * 机器型号
	 */
	@Column(name = "machineModel")
	private String machinemodel;

	/**
	 * APP版本号
	 */
	@Column(name = "appVersion")
	private String appversion;

	/**
	 * 屏幕密度
	 */
	@Column(name = "screenDensity")
	private String screendensity;

	/**
	 * 分辨率
	 */
	@Column(name = "resolvingRate")
	private String resolvingrate;

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
	 * 获取消息来源：1:IOS, 2:android
	 *
	 * @return msgSource - 消息来源：1:IOS, 2:android
	 */
	public Integer getMsgsource() {
		return msgsource;
	}

	/**
	 * 设置消息来源：1:IOS, 2:android
	 *
	 * @param msgsource
	 *            消息来源：1:IOS, 2:android
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
	 * 获取ROM 版本
	 *
	 * @return romVersion - ROM 版本
	 */
	public String getRomversion() {
		return romversion;
	}

	/**
	 * 设置ROM 版本
	 *
	 * @param romversion
	 *            ROM 版本
	 */
	public void setRomversion(String romversion) {
		this.romversion = romversion;
	}

	/**
	 * 获取网络状态: 4G，wifi
	 *
	 * @return netStatus - 网络状态: 4G，wifi
	 */
	public String getNetstatus() {
		return netstatus;
	}

	/**
	 * 设置网络状态: 4G，wifi
	 *
	 * @param netstatus
	 *            网络状态: 4G，wifi
	 */
	public void setNetstatus(String netstatus) {
		this.netstatus = netstatus;
	}

	/**
	 * 获取CPU型号
	 *
	 * @return cpuInfo - CPU型号
	 */
	public String getCpuinfo() {
		return cpuinfo;
	}

	/**
	 * 设置CPU型号
	 *
	 * @param cpuinfo
	 *            CPU型号
	 */
	public void setCpuinfo(String cpuinfo) {
		this.cpuinfo = cpuinfo;
	}

	/**
	 * 获取位置
	 *
	 * @return loaction - 位置
	 */
	public String getLoaction() {
		return loaction;
	}

	/**
	 * 设置位置
	 *
	 * @param loaction
	 *            位置
	 */
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}

	/**
	 * 获取机器型号
	 *
	 * @return machineModel - 机器型号
	 */
	public String getMachinemodel() {
		return machinemodel;
	}

	/**
	 * 设置机器型号
	 *
	 * @param machinemodel
	 *            机器型号
	 */
	public void setMachinemodel(String machinemodel) {
		this.machinemodel = machinemodel;
	}

	/**
	 * 获取APP版本号
	 *
	 * @return appVersion - APP版本号
	 */
	public String getAppversion() {
		return appversion;
	}

	/**
	 * 设置APP版本号
	 *
	 * @param appversion
	 *            APP版本号
	 */
	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	/**
	 * 获取屏幕密度
	 *
	 * @return screenDensity - 屏幕密度
	 */
	public String getScreendensity() {
		return screendensity;
	}

	/**
	 * 设置屏幕密度
	 *
	 * @param screendensity
	 *            屏幕密度
	 */
	public void setScreendensity(String screendensity) {
		this.screendensity = screendensity;
	}

	/**
	 * 获取分辨率
	 *
	 * @return resolvingRate - 分辨率
	 */
	public String getResolvingrate() {
		return resolvingrate;
	}

	/**
	 * 设置分辨率
	 *
	 * @param resolvingrate
	 *            分辨率
	 */
	public void setResolvingrate(String resolvingrate) {
		this.resolvingrate = resolvingrate;
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

	public String getMemorysize() {
		return memorysize;
	}

	public void setMemorysize(String memorysize) {
		this.memorysize = memorysize;
	}

	public String getDisksize() {
		return disksize;
	}

	public void setDisksize(String disksize) {
		this.disksize = disksize;
	}

	public BigDecimal getExecutetime() {
		return executetime;
	}

	public void setExecutetime(BigDecimal executetime) {
		this.executetime = executetime;
	}

	@Override
	public String toString() {
		return "AppLoggerInfo [createdate=" + createdate + ", msgtype=" + msgtype + ", msgsource=" + msgsource
				+ ", identityid=" + identityid + ", username=" + username + ", ip=" + ip + ", interfacename="
				+ interfacename + ", romversion=" + romversion + ", netstatus=" + netstatus + ", cpuinfo=" + cpuinfo
				+ ", memorysize=" + memorysize + ", disksize=" + disksize + ", loaction=" + loaction + ", machinemodel="
				+ machinemodel + ", appversion=" + appversion + ", screendensity=" + screendensity + ", resolvingrate="
				+ resolvingrate + ", requesttype=" + requesttype + ", executetime=" + executetime + ", code=" + code
				+ ", errormsg=" + errormsg + "]";
	}

}