package com.vaibhav.ws.bank.exception;

public class TransactionIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String transactionid;

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public TransactionIdNotFoundException(String msg, String transactionid) {
		super(msg);
		this.transactionid = transactionid;
	}

	@Override
	public String toString() {
		return "TransactionIdNotFoundException [transactionid=" + transactionid + "]";
	}
	
	
}
