package rg.businessManagement.domain;

import java.util.Date;

public class BankStatementEntry {
	
	private Date txnDate;
	private String desc;
	private String refNo;
	private Double debitAmt;
	private Double creditAmt;
	private Double balance;
	
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public Double getDebitAmt() {
		return debitAmt;
	}
	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}
	public Double getCreditAmt() {
		return creditAmt;
	}
	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BankStatementEntry [txnDate=" + txnDate + ", desc=" + desc + ", refNo=" + refNo + ", debitAmt="
				+ debitAmt + ", creditAmt=" + creditAmt + ", balance=" + balance + "]";
	}

}
