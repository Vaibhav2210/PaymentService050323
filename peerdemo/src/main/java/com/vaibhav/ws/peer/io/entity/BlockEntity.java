package com.vaibhav.ws.peer.io.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name="blocks")
public class BlockEntity implements Serializable {
	
	private static final long serialVersionUID = -5853028659164673309L;
	
	@Id
	@Column(nullable=false)
	private int id;
	
	@Column(nullable=false)
	private int nonce;
	
	@Column(nullable=false)
	private long timestamp;
	
	@Column(nullable=false)
	private String hash;
	
	@Column(nullable=false)
	private String previousHash;
	
	@Column(nullable=false)
	private String transaction;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
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
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	
	

}
