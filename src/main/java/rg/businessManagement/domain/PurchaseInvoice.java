package rg.businessManagement.domain;

import java.util.List;

public class PurchaseInvoice {
	
	private String entityName;
	private String gstNo;
	private String invoiceNo;
	private String invoiceDate;
	private List<ItemDetail> itemList;
	private Double totalAmt;
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public List<ItemDetail> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemDetail> itemList) {
		this.itemList = itemList;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	@Override
	public String toString() {
		return "PurchaseInvoice [entityName=" + entityName + ", gstNo=" + gstNo + ", invoiceNo=" + invoiceNo
				+ ", invoiceDate=" + invoiceDate + ", itemList=" + itemList + ", totalAmt=" + totalAmt + "]";
	}
	
}
