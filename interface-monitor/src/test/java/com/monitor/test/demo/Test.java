package com.monitor.test.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.monitor.test.demo.utils.Constant;
import com.monitor.test.demo.utils.SignUtil;
import com.monitor.test.https.HttpClientUtil;
import com.monitor.utils.DateUtils;
import com.mq.utils.JSONUtil;

public class Test {

	public static void main(String[] args) {
		// testTicketQrcode();
		testTicketIssue();
		// testTicketRecod();
	}

	/**
	 * 
	 * Description:开具发票
	 * 
	 * @author zhangwr
	 * @date 2017年5月5日下午2:55:00
	 */
	public static void testTicketIssue() {
		try {
			TicketIssueParam ticketIssueParam = new TicketIssueParam();
			ticketIssueParam.setInvoiceMaterial("ELECTRONIC");
			ticketIssueParam.setInvoiceType("PLAIN");
			ticketIssueParam.setMerchantId("898000000000001");
			ticketIssueParam.setTerminalId("00000001");
			ticketIssueParam.setMerOrderId("1234ddf");
			ticketIssueParam.setMerOrderDate(DateUtils.formatDate(new Date(), "yyyyMMdd"));
			ticketIssueParam.setBuyerName("张三");
			ticketIssueParam.setBuyerTaxCode("aa");
			ticketIssueParam.setBuyerAddress("xxxbb");
			ticketIssueParam.setBuyerTelephone("15828652471");
			ticketIssueParam.setBuyerBank("中国银行");
			ticketIssueParam.setBuyerAccount("123");
			ticketIssueParam.setAmount(5000L);
			ticketIssueParam.setRemark("XGG");
			ticketIssueParam.setNotifyMobileNo("110");
			ticketIssueParam.setNotifyEMail("453000207@qq.com");

			List<GoodDetailParam> list = new ArrayList<GoodDetailParam>();
			GoodDetailParam goodDetailParam = new GoodDetailParam();
			goodDetailParam.setName("小面11");
			goodDetailParam.setSn("1234");
			goodDetailParam.setPriceIncludingTax(10D);
			goodDetailParam.setTaxRate(2);
			goodDetailParam.setQuantity(8D);
			goodDetailParam.setUnit("个");

			GoodDetailParam goodDetailParam1 = new GoodDetailParam();
			goodDetailParam1.setName("炒菜11");
			goodDetailParam1.setSn("12345");
			goodDetailParam1.setPriceIncludingTax(20D);
			goodDetailParam1.setTaxRate(3);
			goodDetailParam1.setQuantity(10D);
			goodDetailParam1.setUnit("个");
			list.add(goodDetailParam1);
			list.add(goodDetailParam);
			ticketIssueParam.setGoodsDetail(list);
			String sign = SignUtil.signWithMd5(JSONUtil.beanToMap(ticketIssueParam), Constant.KEY, "utf-8");
			ticketIssueParam.setSign(sign);
			// json字符串提交
			String jsonStr = JSONUtil.beanToJson(ticketIssueParam);
			System.out.println("入参：" + jsonStr);
			String resultStr = HttpClientUtil.doPost(Constant.TICKET_URL, jsonStr, null, "https");
			System.out.println("出参：" + resultStr);
			// form提交
			// Map resultMap =
			// JSONUtil.beanToMap(JSONUtil.beanToMap(ticketIssueParam));
			// System.out.println("入参：" + resultMap);
			// String resultStr = HttpClientUtil.doPost(Constant.TICKET_URL,
			// null, resultMap);
			// System.out.println("出参：" + resultStr);
			// 解析响应结果
			// TicketIssueResponse bean = JSONUtil.jsonToBean(resultStr,
			// TicketIssueResponse.class);
			// System.out.println("响应结果的Bean：" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Description:生成待开具二维码
	 * 
	 * @author zhangwr
	 * @date 2017年5月5日下午2:21:34
	 */
	public static void testTicketQrcode() {
		try {
			TicketQrcodeParam ticketQrcodeParam = new TicketQrcodeParam();
			ticketQrcodeParam.setInvoiceMaterial("ELECTRONIC");
			ticketQrcodeParam.setInvoiceType("PLAIN");
			ticketQrcodeParam.setMerchantId("898000000000001");
			ticketQrcodeParam.setTerminalId("00000001");
			ticketQrcodeParam.setMerOrderId("1234ddf");
			ticketQrcodeParam.setMerOrderDate(DateUtils.formatDate(new Date(), "yyyyMMdd"));
			ticketQrcodeParam.setAmount(1000L);
			ticketQrcodeParam.setExpireTime(10);
			List<GoodDetailParam> list = new ArrayList<GoodDetailParam>();
			GoodDetailParam goodDetailParam = new GoodDetailParam();
			goodDetailParam.setName("小面");
			goodDetailParam.setSn("1234");
			goodDetailParam.setPriceIncludingTax(10D);
			goodDetailParam.setTaxRate(2);
			goodDetailParam.setQuantity(8D);
			goodDetailParam.setUnit("个");

			GoodDetailParam goodDetailParam1 = new GoodDetailParam();
			goodDetailParam1.setName("炒菜");
			goodDetailParam1.setSn("12345");
			goodDetailParam1.setPriceIncludingTax(20D);
			goodDetailParam1.setTaxRate(3);
			goodDetailParam1.setQuantity(10D);
			goodDetailParam1.setUnit("个");
			list.add(goodDetailParam1);
			list.add(goodDetailParam);
			ticketQrcodeParam.setGoodsDetail(list);
			String sign = SignUtil.signWithMd5(JSONUtil.beanToMap(ticketQrcodeParam), Constant.KEY, "utf-8");
			ticketQrcodeParam.setSign(sign);
			// json字符串提交
			String jsonStr = JSONUtil.beanToJson(ticketQrcodeParam);
			System.out.println("入参：" + jsonStr);
			String resultStr = HttpClientUtil.doPost(Constant.TICKET_URL, jsonStr, null, "https");
			System.out.println("出参：" + resultStr);
			// // form提交
			// Map resultMap =
			// JSONUtil.beanToMap(JSONUtil.beanToMap(ticketQrcodeParam));
			// System.out.println("入参：" + resultMap);
			// String resultStr = HttpClientUtil.doPost(Constant.TICKET_URL,
			// null, resultMap);
			// System.out.println("出参：" + resultStr);
			// 解析响应结果
			TicketQrcodeResponse bean = JSONUtil.jsonToBean(resultStr, TicketQrcodeResponse.class);
			System.out.println("响应结果的Bean：" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Description:查询发票记录
	 * 
	 * @author zhangwr
	 * @date 2017年5月5日上午10:41:16
	 */
	@SuppressWarnings("unchecked")
	public static void testTicketRecod() {
		TicketRecodParam tiParam;
		try {
			tiParam = new TicketRecodParam();
			tiParam.setMerchantId("898000000000001");
			tiParam.setTerminalId("00000001");
			tiParam.setMerOrderId("1234ddf");
			tiParam.setMerOrderDate(DateUtils.formatDate(new Date(), "yyyyMMdd"));
			String sign = SignUtil.signWithMd5(JSONUtil.beanToMap(tiParam), Constant.KEY, "utf-8");
			tiParam.setSign(sign);
			// json字符串提交
			String jsonStr = JSONUtil.beanToJson(tiParam);
			System.out.println("入参：" + jsonStr);
			String resultStr = HttpClientUtil.doPost(Constant.TICKET_URL, jsonStr, null, "https");
			System.out.println("出参：" + resultStr);
			// form提交
			// Map resultMap = JSONUtil.beanToMap(tiParam);
			// System.out.println("入参：" + resultMap);
			// String resultStr = HttpClientUtil.doPost(Constant.TICKET_URL,
			// null, resultMap);
			// System.out.println("出参：" + resultStr);
			// 解析响应结果
			TicketRecodResponse bean = JSONUtil.jsonToBean(resultStr, TicketRecodResponse.class);
			System.out.println("响应结果的Bean：" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
