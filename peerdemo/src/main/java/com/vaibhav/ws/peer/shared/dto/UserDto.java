package com.vaibhav.ws.peer.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 161585416513213L;
	
	private long id;
	private String encrypted_str;
	private String aes_128bit_enckey;
	private boolean bank_verify=false;
	private String firstname;
	private String lastname;
	private String UVR;
	
	private String phone;
	private String peerBankName;
	private String peerBankCode;
	private String peerBankBranch;
	private String currency;
	private String amount;
	private String pid;
	private String status;
	private String email;
	private String transactionid;
	private Long date = new Date().getTime();
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEncrypted_str() {
		return encrypted_str;
	}
	public void setEncrypted_str(String encrypted_str) {
		this.encrypted_str = encrypted_str;
	}
	public String getAes_128bit_enckey() {
		return aes_128bit_enckey;
	}
	public void setAes_128bit_enckey(String aes_128bit_enckey) {
		this.aes_128bit_enckey = aes_128bit_enckey;
	}
	public boolean isBank_verify() {
		return bank_verify;
	}
	public void setBank_verify(boolean bank_verify) {
		this.bank_verify = bank_verify;
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
	public String getUVR() {
		return UVR;
	}
	public void setUVR(String uVR) {
		UVR = uVR;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
}
