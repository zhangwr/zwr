package com.monitor.test.demo;

/**
 * 
 * Title:查询发票记录
 * 
 * @author zhangwr
 * @date 2017年5月5日上午11:16:39
 */
public class TicketRecodResponse extends CommonResponse {
	/**
	 * 发票状态 PENDING: 待开具 ISSUING: 开具中 ISSUED: 已开具 REVERSING: 红冲中 REVERSED：已红冲
	 * INVALIDING： 作废中 INVALIDED：已作废 CLOSED: 已关闭
	 */
	private String status;
	/**
	 * 发票号码
	 */
	private String invoiceNo;
	/**
	 * 发票代码
	 */
	private String invoiceCode;
	/**
	 * 校验码
	 */
	private String checkCode;
	/**
	 * 密码区
	 */
	private String cipherCode;
	/**
	 * 开票日期
	 */
	private String issueDate;
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
	 * 商户订单日期
	 */
	private String merOrderDate;
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
	 * 卖方名称
	 */
	private String sellerName;
	/**
	 * 卖方纳税人识别号
	 */
	private String sellerTaxCode;
	/**
	 * 卖方地址
	 */
	private String sellerAddress;
	/**
	 * 卖方电话
	 */
	private String sellerTelphone;
	/**
	 * 卖方开户行
	 */
	private String sellerBank;
	/**
	 * 卖方账号
	 */
	private String sellerAccount;
	/**
	 * 含税总金额
	 */
	private Double totalPriceIncludingTax;
	/**
	 * 税额
	 */
	private Double totalTax;
	/**
	 * 不含税总金额
	 */
	private Double totalPrice;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getCipherCode() {
		return cipherCode;
	}

	public void setCipherCode(String cipherCode) {
		this.cipherCode = cipherCode;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
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

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerTaxCode() {
		return sellerTaxCode;
	}

	public void setSellerTaxCode(String sellerTaxCode) {
		this.sellerTaxCode = sellerTaxCode;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerTelphone() {
		return sellerTelphone;
	}

	public void setSellerTelphone(String sellerTelphone) {
		this.sellerTelphone = sellerTelphone;
	}

	public String getSellerBank() {
		return sellerBank;
	}

	public void setSellerBank(String sellerBank) {
		this.sellerBank = sellerBank;
	}

	public String getSellerAccount() {
		return sellerAccount;
	}

	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}

	public Double getTotalPriceIncludingTax() {
		return totalPriceIncludingTax;
	}

	public void setTotalPriceIncludingTax(Double totalPriceIncludingTax) {
		this.totalPriceIncludingTax = totalPriceIncludingTax;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "TicketRecodResponse [status=" + status + ", invoiceNo=" + invoiceNo + ", invoiceCode=" + invoiceCode
				+ ", checkCode=" + checkCode + ", cipherCode=" + cipherCode + ", issueDate=" + issueDate
				+ ", merchantId=" + merchantId + ", terminalId=" + terminalId + ", merOrderId=" + merOrderId
				+ ", merOrderDate=" + merOrderDate + ", buyerName=" + buyerName + ", buyerTaxCode=" + buyerTaxCode
				+ ", buyerAddress=" + buyerAddress + ", buyerTelephone=" + buyerTelephone + ", buyerBank=" + buyerBank
				+ ", buyerAccount=" + buyerAccount + ", sellerName=" + sellerName + ", sellerTaxCode=" + sellerTaxCode
				+ ", sellerAddress=" + sellerAddress + ", sellerTelphone=" + sellerTelphone + ", sellerBank="
				+ sellerBank + ", sellerAccount=" + sellerAccount + ", totalPriceIncludingTax=" + totalPriceIncludingTax
				+ ", totalTax=" + totalTax + ", totalPrice=" + totalPrice + ", toString()=" + super.toString() + "]";
	}
	

}
