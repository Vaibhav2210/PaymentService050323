package com.vaibhav.ws.peer.shared.dto;

import java.io.Serializable;

public class BankDto implements Serializable {
	
private static final long serialVersionUID = 4724810265377777658L;

private long id;
	
	private String peerBankCode;
	
	private String peerBankBranch;
	
	private String peerBankName;
	
	private String UVR;
	
	private String transactionid;
	
	private boolean bank_verify=true;

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

	public String getUVR() {
		return UVR;
	}

	public void setUVR(String uVR) {
		UVR = uVR;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public boolean isBank_verify() {
		return bank_verify;
	}

	public void setBank_verify(boolean bank_verify) {
		this.bank_verify = bank_verify;
	}
	
	
	

}
