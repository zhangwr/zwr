

/**
 * 
 * Title:֧�����
 * 
 * @author zhangwr
 * @date 2017��5��15������3:55:35
 */
public class PayMessageVo {
	/**
	 * �̻�ID
	 */
	private String entId;
	/**
	 * ֧������λΪ�֡� ���� 0
	 */
	private String amount;
	/**
	 * �ǣ� true���� false��չʾ�� ��ȷ��ҳ��
	 */
	private Boolean isShowOrderInfo;
	/**
	 * ֧���������֣� 1. ���п��� BANKCARD �򲻴��� ����ֵ 2. Ԥ������ PREPAIDCARD 3.POS ͨ�� POSMPAY
	 */
	private String payType;
	/**
	 * ��ע
	 */
	private String memo;
	/**
	 * �ǣ� true���� false��չʾ�� ��ǩ����ҳ��
	 */
	private Boolean isShowEVoucherPage;
	/**
	 * ǩ��������ʽ�� 1. ֽ��ǩ������ paperType 2. ����ǩ������ electricType 3. Ĭ�ϣ�
	 * defaultType�������� ������ ȫչʾ
	 */
	private String saleSlipFavorite;
	/**
	 * �Ż����ͣ��Ż�ʱ�ش��� 1. ���п��Żݣ� 1 2. �Żݾ��Żݣ� 2 3. ���Żݣ� 0 ������ֵ
	 */
	private String couponType;
	/**
	 * �Żݾ���� �� couponType="2"ʱ�ش���
	 */
	private String couponNo;
	/**
	 * ��֯�������� ��Ԥ��������ʱ�ش���
	 */
	private String orgCode;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Boolean getIsShowOrderInfo() {
		return isShowOrderInfo;
	}

	public void setIsShowOrderInfo(Boolean isShowOrderInfo) {
		this.isShowOrderInfo = isShowOrderInfo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Boolean getIsShowEVoucherPage() {
		return isShowEVoucherPage;
	}

	public void setIsShowEVoucherPage(Boolean isShowEVoucherPage) {
		this.isShowEVoucherPage = isShowEVoucherPage;
	}

	public String getSaleSlipFavorite() {
		return saleSlipFavorite;
	}

	public void setSaleSlipFavorite(String saleSlipFavorite) {
		this.saleSlipFavorite = saleSlipFavorite;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getEntId() {
		return entId;
	}

	public void setEntId(String entId) {
		this.entId = entId;
	}

}
