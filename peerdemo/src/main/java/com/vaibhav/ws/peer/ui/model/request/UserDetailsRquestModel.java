package com.vaibhav.ws.peer.ui.model.request;

public class UserDetailsRquestModel {
	
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String amount;
	private String currency;
	private String peerBankCode;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	public String getPeerBankCode() {
		return peerBankCode;
	}
	public void setPeerBankCode(String peerBankCode) {
		this.peerBankCode = peerBankCode;
	}
	
	

}
