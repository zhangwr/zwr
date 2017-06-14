
package com.monitor.utils;

/**
 * JSON结果编码
 * 
 * @author lenovo
 *
 */
public enum JsonResultCode {

	SUCCESS(200, "成功"), ERROR(500, "逻辑错误"), MODELERROR(400, "参数错误"), NOEXSIT(404, "数据不存在"), 
	NOLOGIN(300,"未登录"), NOAUTHOR(302, "未授权");

	JsonResultCode(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;

	private String name;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
