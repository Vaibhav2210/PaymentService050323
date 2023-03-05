package com.vaibhav.ws.peer.io.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity(name="users")
public class UserEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1614555416513213L;
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=true)
	private String encrypted_str;
	
	@Column(nullable=true)
	private String aes_128bit_enckey;
	
	@Column(nullable=true)
	private boolean bank_verify=false;
	
	@Column(nullable=true)
	private String firstname;
	
	@Column(nullable=true)
	private String lastname;
	
	@Column(nullable=true)
	private String UVR;
	
	@Column(nullable=true)
	private String phone;
	
	@Column(nullable=true)
	private String peerBankName;
	
	@Column(nullable=true)
	private String peerBankCode;
	
	@Column(nullable=true)
	private String peerBankBranch;
	
	@Column(nullable=true)
	private String currency;
	
	@Column(nullable=true)
	private String amount;
	
	@Column(nullable=true)
	private String pid;
	
	@Column(nullable=true)
	private String status;
	
	@Column(nullable=true)
	private String email;
	
	@Column(nullable=true , unique=true)
	private String transactionid;
	
	@Column(nullable=true)
	private Long date = new Date().getTime();
	
	
	/*@OneToMany(targetEntity=BankEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name="newtxnid",referencedColumnName= "id")
	private List<BankEntity> banktable;
	
	public List<BankEntity> getBanktable() {
		return banktable;
	}
	public void setBanktable(List<BankEntity> banktable) {
		this.banktable = banktable;
	}*/
	
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
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
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
