package com.monitor.utils;

import java.util.HashMap;
import java.util.Map;

public enum MsgSource {

	IOS(1, "IOS"), ANDROID(2, "android"), H5(3, "微信"), WEB(4, "网页");

	MsgSource(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public static final Map<Integer, MsgSource> MAP = new HashMap<>();

	static {
		for (MsgSource msgType : MsgSource.values()) {
			MAP.put(msgType.getValue(), msgType);
		}
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
