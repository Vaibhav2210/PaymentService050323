package com.vaibhav.ws.bank.io.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="banks")
public class BankEntity implements Serializable {

	private static final long serialVersionUID = 3645501906273003880L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable=true)
	private String peerBankCode;
	
	@Column(nullable=true)
	private String peerBankBranch;
	
	@Column(nullable=true)
	private String peerBankName;
	
	@Column(nullable=true)
	private boolean bank_verify=false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPeerBankName() {
		return peerBankName;
	}

	public void setPeerBankName(String peerBankName) {
		this.peerBankName = peerBankName;
	}

	public boolean isBank_verify() {
		return bank_verify;
	}

	public void setBank_verify(boolean bank_verify) {
		this.bank_verify = bank_verify;
	}
	
	
}