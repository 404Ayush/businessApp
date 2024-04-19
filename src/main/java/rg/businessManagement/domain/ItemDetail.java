package rg.businessManagement.domain;

public class ItemDetail {

	private String itemName;
	private int qty;
	private Double rate;
	private Double discountL1;
	private Double discountL2;
	private int gstRate;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getDiscountL1() {
		return discountL1;
	}
	public void setDiscountL1(Double discountL1) {
		this.discountL1 = discountL1;
	}
	public Double getDiscountL2() {
		return discountL2;
	}
	public void setDiscountL2(Double discountL2) {
		this.discountL2 = discountL2;
	}
	public int getGstRate() {
		return gstRate;
	}
	public void setGstRate(int gstRate) {
		this.gstRate = gstRate;
	}
	
	@Override
	public String toString() {
		return "ItemDetail [itemName=" + itemName + ", qty=" + qty + ", rate=" + rate + ", discountL1=" + discountL1
				+ ", discountL2=" + discountL2 + ", gstRate=" + gstRate + "]";
	}
	
}
