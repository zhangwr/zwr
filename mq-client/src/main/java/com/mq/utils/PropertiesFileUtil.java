package com.mq.utils;

import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;

/**
 * properties 配置文件工具类
 * 
 * @author zhangweirong
 * @date 2016年9月9日下午4:06:38
 * @since jdk 1.8
 * 
 * @version 1.0
 */
public class PropertiesFileUtil {

	/**
	 * 资源文件对象
	 */
	private static PropertiesConfiguration configuration = null;

	static {
		if (configuration == null) {
			configuration = new PropertiesConfiguration();
		}
	}

	/**
	 * 构建properties解析类
	 * 
	 */
	public static PropertiesFileUtil builder(String filePath) throws ConfigurationException {
		if (StringUtils.isBlank(filePath)) {
			return null;
		}

		configuration.load(filePath);

		return new PropertiesFileUtil();
	}

	/**
	 * 获取properties文件的指定行的数据
	 * 
	 */
	public String getFileLine(int number) {
		int i = 1;
		String line = "";
		for (Iterator<String> keys = configuration.getKeys(); keys.hasNext();) {
			if (i == number) {
				line = keys.next();
			}
			i++;
		}
		return line;
	}

	/**
	 * 获取所有key
	 * 
	 */
	public Iterator<String> getKeys() {
		return configuration.getKeys();
	}

	/**
	 * 根据key 获取指定值
	 * 
	 */
	public String getString(String key) {
		return getString(key, "");
	}

	public String getString(String key, String defaultStr) {
		return configuration.getString(key, defaultStr);
	}

	public String[] getStringArray(String key) {
		return configuration.getStringArray(key);
	}

	public int getInt(String key) {
		return getInt(key, 0);
	}

	public int getInt(String key, int defaultValue) {
		return configuration.getInt(key, defaultValue);
	}

	public short getShort(String key) {
		return configuration.getShort(key, (short) 0);
	}

	public long getLong(String key) {
		return configuration.getLong(key, 0l);
	}

	public Boolean getBoolean(String key) {
		return configuration.getBoolean(key, false);
	}

}
