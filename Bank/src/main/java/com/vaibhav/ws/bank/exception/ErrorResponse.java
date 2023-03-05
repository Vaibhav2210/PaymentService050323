package com.vaibhav.ws.bank.exception;

public class ErrorResponse {
	
	private String msg;
	
	private String transactionid;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	@Override
	public String toString() {
		return "ErrorResponse [msg=" + msg + ", transactionid=" + transactionid + "]";
	}

}
