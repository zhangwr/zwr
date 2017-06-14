package com.monitor.model;

import javax.validation.Valid;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.monitor.entity.Demo;

/**
 * 
 * Title:业务的参数封装实体
 * 
 * @author zhangwr
 * @date 2017年5月2日上午10:01:29
 */
public class DemoModel {

	@NotBlank(message = "名称不能为空")
	private String qNme;

	@NotNull
	@Valid
	private Demo demo;

	public String getqNme() {
		return qNme;
	}

	public void setqNme(String qNme) {
		this.qNme = qNme;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

}
