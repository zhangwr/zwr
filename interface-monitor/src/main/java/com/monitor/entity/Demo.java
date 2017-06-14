package com.monitor.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@SuppressWarnings("serial")
public class Demo extends BaseEntity {

	@NotEmpty(message = "姓名不能为空")
	private String name;

	@NotEmpty(message = "状态不能为空")
	@Length(min = 6, message = "状态长度不能小于6位")
	private String state;

	public Demo() {
	}

	public Demo(String name, String state) {
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}