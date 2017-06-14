package com.monitor.test.demo.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * Title:签名工具类
 * 
 * @author zhangwr
 * @date 2017年5月5日上午10:03:43
 */
public class SignUtil {

	public static String signWithMd5(Map<String, Object> params, String md5Key, String charset) {
		String prestr = buildSignString(params); // 把数组所有元素，按照“参数=
		return signWithMd5(prestr, md5Key, charset);
	}

	public static String buildSignString(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>(params.size());
		for (String key : params.keySet()) {
			if ("sign".equals(key) || "sign_type".equals(key))
				continue;
			if (params.get(key) == null || params.get(key) == "")
				continue;
			keys.add(key);
		}
		Collections.sort(keys);
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			Object value = params.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				buf.append(key + "=" + value);
			} else {
				buf.append(key + "=" + value + "&");
			}
		}
		String str = buf.toString();
		System.out.println("排序后的字符串：" + str);
		return str;
	}

	public static String signWithMd5(String originStr, String md5Key, String charset) {
		String text = originStr + md5Key;
		return DigestUtils.md5Hex(getContentBytes(text, charset)).toUpperCase();
	}

	private static byte[] getContentBytes(String content, String charset) {
		if (StringUtils.isEmpty(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5 签名过程中出现错误, 指定的编码集不对, 您目前指定的编码集是:" + charset);
		}
	}

	public static void main(String[] args) {
		Map<String, Object> params = new HashMap<String, Object>();
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		params.put("msgId", uuid);
		params.put("msgSrc", "abcd");
		params.put("msgType", "query");
		params.put("requestTimestamp", "2017-05-03 15:43:41");
		params.put("srcReserve", "test");

		params.put("merchantId", "898000000000001");
		params.put("terminalId", "00000001");
		params.put("merOrderId", "1234ddf");
		params.put("merOrderDate", "20170503");
		String sign = signWithMd5(params, "a74e450863c54e3ca49092b52759c898", "utf-8");
		System.out.println(sign);
	}
}