package com.monitor.test.demo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class HttpConn {
	private static Logger logger = Logger.getLogger(HttpConn.class);

	public static final String SUCCESS = "00"; // 调用成功；
	public static final String EXCEPTION = "-1";// 操作失败，业务接口发生异常。

	private String connectionUrl;

	public HttpConn() {
	}

	public HttpConn(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	private String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String sendRequest(String param, String method, String charactorEncoding) {
		if (StringUtils.isBlank(connectionUrl)) {
			logger.error("调用失败：连接地址尚未初始化！");
			return EXCEPTION;
		}
		if (StringUtils.isBlank(method)) {
			method = "POST";
		}
		if (StringUtils.isBlank(charactorEncoding)) {
			charactorEncoding = "UTF-8";
		}
		HttpURLConnection connection = null;
		try {
			URL url = new URL(connectionUrl);
			// 以post方式请求
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(method);
			if (StringUtils.isNotBlank(param)) {
				connection.getOutputStream().write(param.getBytes(charactorEncoding));
			}
			connection.getOutputStream().flush();
			connection.getOutputStream().close();
			// 获取响应代码
			int code = connection.getResponseCode();
			if (code != 200) {
				throw new RuntimeException("调用异常，状态码是：" + code);
			}
			java.io.InputStream in = connection.getInputStream();
			java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in, charactorEncoding));
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = breader.readLine()) != null) {
				sb.append(str);
			}
			return sb.toString();
		} catch (IOException e) {
			String errInfo = "接口调用失败！请确认接口服务是否正常。";
			logger.error(errInfo + "[" + getConnectionUrl() + "]:" + e.getMessage(), e);
			return EXCEPTION;
		} catch (Exception e) {
			String errInfo = "接口调用失败！";
			logger.error(errInfo + "[" + getConnectionUrl() + "]:" + e.getMessage(), e);
			return EXCEPTION;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
