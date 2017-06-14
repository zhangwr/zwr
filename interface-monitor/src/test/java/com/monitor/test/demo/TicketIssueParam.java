package com.monitor.test.demo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.monitor.test.demo.utils.Constant;

/**
 * 
 * Title:开具发票入参
 * 
 * @author zhangwr
 * @date 2017年5月5日下午2:50:13
 */
public class TicketIssueParam extends CommonParam {

	public TicketIssueParam() {
		super.setMsgId(UUID.randomUUID().toString());
		super.setMsgSrc("abcd");
		super.setMsgType(Constant.ISSUE_TICKET);
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
	 * 商户订单日期
	 */
	private String merOrderDate;
	/**
	 * 商户订单号
	 */
	private String merOrderId;
	/**
	 * 买方名称
	 */
	private String buyerName;
	/**
	 * 买方纳税人识别号
	 */
	private String buyerTaxCode;
	/**
	 * 买方地址
	 */
	private String buyerAddress;
	/**
	 * 买方电话
	 */
	private String buyerTelephone;
	/**
	 * 买方开户行
	 */
	private String buyerBank;
	/**
	 * 买方银行账号
	 */
	private String buyerAccount;
	/**
	 * 含税总金额
	 */
	private Long amount;
	/**
	 * 商品明细
	 */
	private List<GoodDetailParam> goodsDetail;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 推送短信手机号
	 */
	private String notifyMobileNo;
	/**
	 * 推送 PDF 文件的邮箱
	 */
	private String notifyEMail;

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

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTaxCode() {
		return buyerTaxCode;
	}

	public void setBuyerTaxCode(String buyerTaxCode) {
		this.buyerTaxCode = buyerTaxCode;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerTelephone() {
		return buyerTelephone;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getBuyerBank() {
		return buyerBank;
	}

	public void setBuyerBank(String buyerBank) {
		this.buyerBank = buyerBank;
	}

	public String getBuyerAccount() {
		return buyerAccount;
	}

	public void setBuyerAccount(String buyerAccount) {
		this.buyerAccount = buyerAccount;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public List<GoodDetailParam> getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(List<GoodDetailParam> goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNotifyMobileNo() {
		return notifyMobileNo;
	}

	public void setNotifyMobileNo(String notifyMobileNo) {
		this.notifyMobileNo = notifyMobileNo;
	}

	public String getNotifyEMail() {
		return notifyEMail;
	}

	public void setNotifyEMail(String notifyEMail) {
		this.notifyEMail = notifyEMail;
	}

}
