package com.monitor.test.demo;

/**
 * 
 * Title:商品明细类
 * 
 * @author zhangwr
 * @date 2017年5月5日上午11:36:13
 */
public class GoodDetailParam {
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品编码	
	 */
	private String sn;
	/**
	 * 含税总价格
	 */
	private Double priceIncludingTax;
	/**
	 * 税率
	 */
	private int taxRate;
	/**
	 * 数量
	 */
	private Double quantity;
	/**
	 * 单位
	 */
	private String unit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Double getPriceIncludingTax() {
		return priceIncludingTax;
	}

	public void setPriceIncludingTax(Double priceIncludingTax) {
		this.priceIncludingTax = priceIncludingTax;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
