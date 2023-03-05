package com.vaibhav.ws.peer.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.ws.peer.BankRepository;
import com.vaibhav.ws.peer.BlockRepository;
import com.vaibhav.ws.peer.PeerBankRepository;
import com.vaibhav.ws.peer.UserRepository;
import com.vaibhav.ws.peer.blockchain.Block;
import com.vaibhav.ws.peer.blockchain.Blockchain;
import com.vaibhav.ws.peer.blockchain.Constants;
import com.vaibhav.ws.peer.blockchain.Miner;
import com.vaibhav.ws.peer.io.entity.BankEntity;
import com.vaibhav.ws.peer.io.entity.PeerBankEntity;
import com.vaibhav.ws.peer.io.entity.UserEntity;
import com.vaibhav.ws.peer.service.UserService;
import com.vaibhav.ws.peer.shared.AesCryptUtil;
import com.vaibhav.ws.peer.shared.Utils;
import com.vaibhav.ws.peer.shared.dto.BankDto;
import com.vaibhav.ws.peer.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	BlockRepository blockRepository;
	
	@Autowired
	PeerBankRepository peerBankRepository;
	
	@Autowired 
	Utils utils;
	
	@Autowired 
	AesCryptUtil aesCryptUtil;
	
	final static public String KEY = "1D2A907A05656A7E1A570B14C573D192";
	
	String bankName="";
	String bankBranch="";
	String bankCode="";
	Boolean bankVerify=false;
	String status = "Request Initiated";
	
	String UVR;
	
	Boolean getUVRFromDB=false;
	
	BankDto bankDto = new BankDto();
	
	Logger lg;
	
	@Override
	public BankDto createUser(BankDto bankDto) {
		//BankDB
		
		BankEntity bankEntity = new BankEntity();
		BeanUtils.copyProperties(bankDto, bankEntity);
		
				bankDto.setBank_verify(false);
				bankDto.setId(111);
				bankDto.setPeerBankBranch("Test");
				bankDto.setPeerBankCode("Test");
				bankDto.setPeerBankName("Test");
				bankDto.setTransactionid("Test");
				bankDto.setUVR("Test");
				
				BankServiceImpl bankServiceImpl = new BankServiceImpl();
				bankServiceImpl.createUser(bankDto);
				
				BankEntity storedBankDetails = bankRepository.save(bankEntity);
				
				BankDto returnValue = new BankDto();
				BeanUtils.copyProperties(storedBankDetails, returnValue);
				
		
		return returnValue;
	}

	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		/*System.out.println(user.getAes_128bit_enckey());
		System.out.println(user.getAmount());
		System.out.println(user.getCurrency());
		System.out.println(user.getEncrypted_str());
		System.out.println(user.getFirstname());
		System.out.println(user.getId());
		System.out.println(user.getLastname());
		System.out.println(user.getOptional());
		System.out.println(user.getPeerBankBranch());
		System.out.println(user.getPeerBankCode());
		System.out.println(user.getPeerBankName());
		System.out.println(user.getPhone());
		System.out.println(user.getPid());
		System.out.println(user.getUVR());
		
		userEntity.setAes_128bit_enckey("test");
		userEntity.setAmount("10.00");
		userEntity.setCurrency("INR");
		userEntity.setEncrypted_str("test");
		userEntity.setId(1);
		userEntity.setOptional("optional");
		userEntity.setPeerBankBranch("test");
		userEntity.setPeerBankCode("test");
		userEntity.setPeerBankName("test");
		userEntity.setPhone("test");
		userEntity.setPid("test");
		userEntity.setUVR("test");*/
		
		//String newBankDetails = bankUtils.getBankDetails("SBI0004");
		//System.out.println(newBankDetails);
		
		
		
		String publicUserId = utils.generateUserId(10);
		userEntity.setPid(publicUserId);
		
		String tarnsactionId = utils.generateTransactionId(10);
		userEntity.setTransactionid(tarnsactionId);
		
		
		AesCryptUtil aesCryptUtil = new AesCryptUtil(KEY);
		String AESData = aesCryptUtil.encrypt(userEntity.getPid()+"&"+userEntity.getTransactionid()+"&"+userEntity.getFirstname()+"&"+userEntity.getLastname()+"&"+userEntity.getAmount()+"&"+userEntity.getCurrency()+"&"+userEntity.getEmail());
		
		System.out.println(aesCryptUtil.encrypt(userEntity.getFirstname())); // test working
		System.out.println(AESData); // test working
		
		userEntity.setAes_128bit_enckey(KEY);
		userEntity.setEncrypted_str(AESData);
		userEntity.setUVR(AESData);
		
		
		/*bankEntity =new BankEntity();
		
		bankEntity.setBank_verify(false);
		bankEntity.setId(111);
		bankEntity.setPeerBankBranch("Test");
		bankEntity.setPeerBankCode("Test");
		bankEntity.setPeerBankName("Test");
		bankEntity.setTransactionid("Test");
		bankEntity.setUVR("Test");
		
		List<BankEntity> bankEntity2 = (List<BankEntity>) bankEntity;
		userEntity.setBanktable(bankEntity2);*/
		
		/*List<UserEntity> userList = userRepository.findAll();
		
		for(int i = 0; i < userList.size(); i++){
		if(userList.get(i).getUVR().equals(userEntity.getUVR())) {
			getUVRFromDB = true;
			
			//System.out.println(bankList.get(i).getPeerBankCode());
			
			UVR=userList.get(i).getUVR().toString();
			System.out.println("\n\n UVR : "+UVR);
			
			Blockchain blockchain = new Blockchain();
			Miner miner = new Miner();
			
			Block block0 = new Block(0, "GENESIS_BLOCK" , Constants.GENESIS_PREV_HASH);
			miner.mine(block0, blockchain);
			
			Block block1 = new Block(1, "transaction1" , blockchain.getBlockChain().get(blockchain.getSize()-1).getHash());
			miner.mine(block1, blockchain);
			
			Block block2 = new Block(2, "transaction2" , blockchain.getBlockChain().get(blockchain.getSize()-1).getHash());
			miner.mine(block2, blockchain);
			
			System.out.println("\n"+ "BLOCKCHAIN \n"+blockchain);
			System.out.println("Miner's Reward : "+miner.getReward());
			
			break;
			
			}	
		}*/
		
		
		/*if(getUVRFromDB) {
			System.out.println("\n"+ "TRUE STATEMENT UPDATED !! \n");
			
			Blockchain blockchain = new Blockchain();
			Miner miner = new Miner();
			
			Block block0 = new Block(0, "GENESIS_BLOCK" , Constants.GENESIS_PREV_HASH);
			miner.mine(block0, blockchain);
			
			for (int i = 1; i < userList.size(); i++) {
				
				Block block = new Block(i, "Transaction"+i , blockchain.getBlockChain().get(blockchain.getSize()-1).getHash());
				miner.mine(block, blockchain);

			}
			
			
			System.out.println("\n"+ "BLOCKCHAIN \n"+blockchain);
			System.out.println("Miner's Reward : "+miner.getReward());
		}*/

		//List<BankEntity> bankList = bankRepository.findAll();
		
		List <PeerBankEntity> bankList = (List<PeerBankEntity>) peerBankRepository.findAll();
		
		for(int i = 0; i < bankList.size(); i++){
		if(bankList.get(i).getPeerBankCode().equals(userEntity.getPeerBankCode())) {
			//System.out.println(bankList.get(i).getPeerBankCode());
			
			bankName=bankList.get(i).getPeerBankName().toString();
			bankBranch=bankList.get(i).getPeerBankBranch().toString();
			bankCode=bankList.get(i).getPeerBankCode().toString();
			bankVerify = bankList.get(i).isBank_verify();
			break;
			
			}	
		}
		
		//System.out.println(BankName);
		//System.out.println(BankBranch);
		//System.out.println(BankCode);
		
		//userEntity.setOptional("optional");
		userEntity.setStatus(status);
		userEntity.setPeerBankBranch(bankBranch);
		userEntity.setPeerBankName(bankName);
		userEntity.setBank_verify(bankVerify);
		
		//bankList.forEach(System.out::println); //printArrays
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		
		//Bank DB
		/*BankDto bankDto = new BankDto();
		
		bankDto.setBank_verify(false);
		bankDto.setId(111);
		bankDto.setPeerBankBranch("Test");
		bankDto.setPeerBankCode("Test");
		bankDto.setPeerBankName("Test");
		bankDto.setTransactionid("Test");
		bankDto.setUVR("Test");*/
		
		
		
		
		//User Methods
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		
		//printValues
		System.out.println(returnValue.getAes_128bit_enckey());
		System.out.println(returnValue.getAmount());
		System.out.println(returnValue.getCurrency());
		System.out.println(returnValue.getEncrypted_str());
		System.out.println(returnValue.getFirstname());
		System.out.println(returnValue.getId());
		System.out.println(returnValue.getLastname());
		//System.out.println(returnValue.getOptional());
		System.out.println(returnValue.getStatus());
		System.out.println(returnValue.getPeerBankBranch());
		System.out.println(returnValue.getPeerBankCode());
		System.out.println(returnValue.getPeerBankName());
		System.out.println(returnValue.getPhone());
		System.out.println(returnValue.getPid());
		System.out.println(returnValue.getUVR());
		System.out.println(returnValue.getEmail());
		
		
		
		BankEntity bankEntity = new BankEntity();
		bankEntity.setUVR(AESData);
		bankEntity.setBank_verify(!bankVerify);
		bankEntity.setPeerBankBranch(bankBranch);
		bankEntity.setPeerBankCode(bankCode);
		bankEntity.setPeerBankName(bankName);
		bankEntity.setTransactionid(tarnsactionId);
		
		
		bankRepository.save(bankEntity);
		
		
		
		
		return returnValue;
	}
}
