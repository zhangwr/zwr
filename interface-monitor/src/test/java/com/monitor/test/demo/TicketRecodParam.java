package com.monitor.test.demo;

import java.util.Date;
import java.util.UUID;

import com.monitor.test.demo.utils.Constant;

/**
 * 
 * Title:查询发票记录入参
 * 
 * @author zhangwr
 * @date 2017年5月4日下午4:43:35
 */
public class TicketRecodParam extends CommonParam {

	public TicketRecodParam() {
		super.setMsgId(UUID.randomUUID().toString());
		super.setMsgSrc("abcd");
		super.setMsgType(Constant.QUERY_TICKET);
		super.setRequestTimestamp(new Date());
		super.setSrcReserve("test");
	}

	/**
	 * 银商商户号
	 */
	private String merchantId;
	/**
	 * 银商终端号
	 */
	private String terminalId;
	/**
	 * 商户订单号
	 */
	private String merOrderId;
	/**
	 * 商户订单日期 yyyyMMdd
	 */
	private String merOrderDate;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getMerOrderId() {
		return merOrderId;
	}

	public void setMerOrderId(String merOrderId) {
		this.merOrderId = merOrderId;
	}

	public String getMerOrderDate() {
		return merOrderDate;
	}

	public void setMerOrderDate(String merOrderDate) {
		this.merOrderDate = merOrderDate;
	}

}
