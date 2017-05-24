package com.mq.model;

/**
 * APP请求参数
 * 
 * @author lenovo
 *
 */
public class Message extends BaseLoggerInfo {
	/**
	 * ROM 版本
	 */
	private String romversion;

	/**
	 * 网络状态: 4G，wifi
	 */
	private String netstatus;

	/**
	 * CPU型号
	 */
	private String cpuinfo;

	/**
	 * 内存大小（当前使用的内存)
	 */
	private String memorysize;

	/**
	 * 硬盘大小
	 */
	private String disksize;

	/**
	 * 位置
	 */
	private String loaction;

	/**
	 * 机器型号
	 */
	private String machinemodel;

	/**
	 * APP版本号
	 */
	private String appversion;

	/**
	 * 屏幕密度
	 */
	private String screendensity;

	/**
	 * 分辨率
	 */
	private String resolvingrate;

	public String getRomversion() {
		return romversion;
	}

	public void setRomversion(String romversion) {
		this.romversion = romversion;
	}

	public String getNetstatus() {
		return netstatus;
	}

	public void setNetstatus(String netstatus) {
		this.netstatus = netstatus;
	}

	public String getCpuinfo() {
		return cpuinfo;
	}

	public void setCpuinfo(String cpuinfo) {
		this.cpuinfo = cpuinfo;
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

	public String getLoaction() {
		return loaction;
	}

	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}

	public String getMachinemodel() {
		return machinemodel;
	}

	public void setMachinemodel(String machinemodel) {
		this.machinemodel = machinemodel;
	}

	public String getAppversion() {
		return appversion;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	public String getScreendensity() {
		return screendensity;
	}

	public void setScreendensity(String screendensity) {
		this.screendensity = screendensity;
	}

	public String getResolvingrate() {
		return resolvingrate;
	}

	public void setResolvingrate(String resolvingrate) {
		this.resolvingrate = resolvingrate;
	}

	@Override
	public String toString() {
		return "Message [romversion=" + romversion + ", netstatus=" + netstatus + ", cpuinfo=" + cpuinfo
				+ ", memorysize=" + memorysize + ", disksize=" + disksize + ", loaction=" + loaction + ", machinemodel="
				+ machinemodel + ", appversion=" + appversion + ", screendensity=" + screendensity + ", resolvingrate="
				+ resolvingrate + ", toString()=" + super.toString() + "]";
	}

}