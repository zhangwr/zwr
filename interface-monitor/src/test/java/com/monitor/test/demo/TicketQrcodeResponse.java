package com.monitor.test.demo;

public class TicketQrcodeResponse extends CommonResponse {
	/**
	 * 待开具二维码
	 */
	private String qrCode;

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Override
	public String toString() {
		return "TicketQrcodeResponse [qrCode=" + qrCode + ", toString()=" + super.toString() + "]";
	}

}
