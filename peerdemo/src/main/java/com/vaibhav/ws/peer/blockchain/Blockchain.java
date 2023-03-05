package com.vaibhav.ws.peer.blockchain;

import java.util.LinkedList;
import java.util.List;

public class Blockchain {

	private List<Block> blockchain;

	public Blockchain() {
		super();
		this.blockchain = new LinkedList<>();
	}
	
	
	public void addBlock(Block block) {
		this.blockchain.add(block);
	}
	
	
	public List<Block> getBlockChain(){
		return this.blockchain;
	}
	
	public int getSize() {
		return this.blockchain.size();
	}


	@Override
	public String toString() {
		String s = "";
		for(Block block : this.blockchain)
			s += block.toString()+"\n";
		return s;
	}
	
}
