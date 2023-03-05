package com.vaibhav.ws.peer.ui.model.response;

public class UserRest {
	
	private String firstname;
	private String lastname;
	private String phone;
	private String UVR;
	private String peerBankName;
	private String peerBankCode;
	private String peerBankBranch;
	private String currency;
	private String amount;
	private String pid;
	private String status;
	private String email;
	private String transactionid;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUVR() {
		return UVR;
	}
	public void setUVR(String uVR) {
		UVR = uVR;
	}
	public String getPeerBankName() {
		return peerBankName;
	}
	public void setPeerBankName(String peerBankName) {
		this.peerBankName = peerBankName;
	}
	public String getPeerBankCode() {
		return peerBankCode;
	}
	public void setPeerBankCode(String peerBankCode) {
		this.peerBankCode = peerBankCode;
	}
	public String getPeerBankBranch() {
		return peerBankBranch;
	}
	public void setPeerBankBranch(String peerBankBranch) {
		this.peerBankBranch = peerBankBranch;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
