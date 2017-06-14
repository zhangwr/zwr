package com.monitor.test.demo.utils;

/**
 * 
 * Title:常量
 * 
 * @author zhangwr
 * @date 2017年5月5日上午10:21:42
 */
public class Constant {
	/**
	 * 报文签名密钥
	 */
	public static final String KEY = "a74e450863c54e3ca49092b52759c898";

	/**
	 * 响应成功
	 */
	public static final String SUCCESS = "SUCCESS";

	/**
	 * 发票URL
	 */
	public static final String TICKET_URL = "https://fapiao.chinaums.com/fapiao-api-test/";

	/**
	 * 查询发票消息类型
	 */
	public static final String QUERY_TICKET = "query";

	/**
	 * 开具发票消息类型
	 */
	public static final String ISSUE_TICKET = "issue";

	/**
	 * 生成待开具二维码消息类型
	 */
	public static final String GET_TICKET = "get.qrcode";

}
