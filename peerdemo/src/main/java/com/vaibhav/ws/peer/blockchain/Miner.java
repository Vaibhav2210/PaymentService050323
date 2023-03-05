package com.vaibhav.ws.peer.blockchain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.ws.peer.UserRepository;
import com.vaibhav.ws.peer.io.entity.UserEntity;

public class Miner {

	private double reward;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserEntity userEntity;
	
	String UVR;
	
	/*List<UserEntity> userList = userRepository.findAll();
	
	public void checkUserData() {
		
		//List<UserEntity> userList = userRepository.findAll();
		
		//List<UserEntity> newUserList = userRepository.findAll();
		
		
		try{
			if(userList.isEmpty()) {
				System.out.println("Hehehe");
				}
		}
		catch(Exception e) {
			System.out.println("Exception"+e);
		}
		
		
		
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUVR().equals(userEntity.getUVR())) {
				//System.out.println(bankList.get(i).getPeerBankCode());
				
				UVR=userList.get(i).getUVR().toString();
				System.out.println("\n\n UVR : "+UVR);
				
				break;
				
				}
		}
		
	}*/
	
	public void transaction(Block block, Blockchain blockchain) {
		while(!isNewGoldenHash(block)) {
			
			block.incrementNonce();
			block.generateHash();
		}
	}
	
	private boolean isNewGoldenHash(Block block) {
		
		String leadigZeors = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
		return block.getHash().substring(0,Constants.DIFFICULTY).equals(leadigZeors);
	}

	public void mine(Block block, Blockchain blockchain) {
		while(!isGoldenHash(block)) {
			
			block.incrementNonce();
			block.generateHash();
		}
		
		System.out.println("\n"+block + " has just mined !!\n");
		System.out.println("Hash is " + block.getHash());
		
		blockchain.addBlock(block);
		reward+= Constants.REWARD;
	}

	private boolean isGoldenHash(Block block) {
		
		String leadigZeors = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
		return block.getHash().substring(0,Constants.DIFFICULTY).equals(leadigZeors);
	}

	public double getReward() {
		return reward;
	}
}
