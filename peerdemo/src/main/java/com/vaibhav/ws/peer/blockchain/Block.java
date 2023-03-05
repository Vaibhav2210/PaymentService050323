package com.vaibhav.ws.peer.blockchain;

import java.util.Date;

public class Block {
	
	private int id;
	private int nonce;
	private long timestamp;
	private String hash;
	private String previousHash;
	private String transaction;
	
	
	public Block(int id, String previousHash, String transaction) {
		super();
		this.id = id;
		this.timestamp = new Date().getTime();
		this.previousHash = previousHash;
		this.transaction = transaction;
		
		generateHash();
	}


	public void incrementNonce() {
		this.nonce++;
	}
	
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}


	public void generateHash() {
		String dataToHash = Integer.toString(id)+previousHash+
				Long.toString(timestamp)+
				Integer.toString(nonce)+
				transaction.toString();
		this.hash = SHA256Helper.generateHash(dataToHash);
	}


	@Override
	public String toString() {
		return "Block [id=" + id + ", hash=" + hash + ", previousHash=" + previousHash + ", transaction=" + transaction
				+ "]";
	}
}
