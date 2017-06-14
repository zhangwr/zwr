package com.monitor.test.demo;

/**
 * 
 * Title:开具发票出参
 * 
 * @author zhangwr
 * @date 2017年5月5日下午2:49:54
 */
public class TicketIssueResponse extends CommonResponse {

	/**
	 * 领票二维码
	 */
	private String qrCode;
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

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
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

	@Override
	public String toString() {
		return "TicketIssueResponse [qrCode=" + qrCode + ", invoiceNo=" + invoiceNo + ", invoiceCode=" + invoiceCode
				+ ", checkCode=" + checkCode + ", cipherCode=" + cipherCode + ", issueDate=" + issueDate
				+ ", toString()=" + super.toString() + "]";
	}

}
