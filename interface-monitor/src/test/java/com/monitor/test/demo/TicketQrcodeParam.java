package com.monitor.test.demo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.monitor.test.demo.utils.Constant;

/**
 * 
 * Title:生成待开具二维码入参
 * 
 * @author zhangwr
 * @date 2017年5月5日上午11:37:50
 */
public class TicketQrcodeParam extends CommonParam {

	public TicketQrcodeParam() {
		super.setMsgId(UUID.randomUUID().toString());
		super.setMsgSrc("abcd");
		super.setMsgType(Constant.GET_TICKET);
		super.setRequestTimestamp(new Date());
		super.setSrcReserve("test");
	}

	/**
	 * 发票材质 纸质发票： PAPER 电子发票： ELECTRONIC
	 */
	private String invoiceMaterial;
	/**
	 * 发票类型 普通发票： PLAIN 增值税专用发票： VAT
	 */
	private String invoiceType;
	/**
	 * 银商商户号
	 */
	private String merchantId;
	/**
	 * 银商终端号
	 */
	private String terminalId;
	/**
	 * 开票交易时间
	 */
	private String merOrderDate;
	/**
	 * 开票交易订单号
	 */
	private String merOrderId;
	/**
	 * 开票金额
	 */
	private Long amount;
	/**
	 * 过期时间
	 */
	private Integer expireTime;
	/**
	 * 开票商品
	 */
	private List<GoodDetailParam> goodsDetail;

	public String getInvoiceMaterial() {
		return invoiceMaterial;
	}

	public void setInvoiceMaterial(String invoiceMaterial) {
		this.invoiceMaterial = invoiceMaterial;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

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

	public String getMerOrderDate() {
		return merOrderDate;
	}

	public void setMerOrderDate(String merOrderDate) {
		this.merOrderDate = merOrderDate;
	}

	public String getMerOrderId() {
		return merOrderId;
	}

	public void setMerOrderId(String merOrderId) {
		this.merOrderId = merOrderId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Integer getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

	public List<GoodDetailParam> getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(List<GoodDetailParam> goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

}
