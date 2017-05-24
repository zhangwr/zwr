package com.mq.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * 字符串工具类
 */
public final class StringUtil {

	private StringUtil() {
	}

	/**
	 * gzip 数据压缩
	 * 
	 */
	public static byte[] gzip(String msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				gzip.close();
			}
			IOUtils.closeQuietly(out);
		}
		return out.toByteArray();
	}

	/**
	 * gzip 数据压缩
	 * 
	 */
	public static byte[] gzip(byte[] msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				gzip.close();
			}
			IOUtils.closeQuietly(out);
		}
		return out.toByteArray();
	}

	/**
	 * gzip 数据解压缩
	 * 
	 */
	public static byte[] unZip(String msg) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(msg.getBytes());
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[4096];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		gunzip.close();

		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);

		return out.toByteArray();
	}

	/**
	 * gzip 解压
	 * 
	 */
	public static String unZip(byte[] msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(msg);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[4096];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		gunzip.close();

		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		return new String(out.toByteArray(), "utf-8");
	}

	/**
	 * 解压数据，返回解压过后的字节数组
	 * 
	 */
	public static byte[] unZip2(byte[] msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(msg);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[4096];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		gunzip.close();
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		return out.toByteArray();
	}

}
