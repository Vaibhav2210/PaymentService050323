package com.vaibhav.ws.peer.ui.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.ws.peer.BankRepository;
import com.vaibhav.ws.peer.BlockRepository;
import com.vaibhav.ws.peer.blockchain.Block;
import com.vaibhav.ws.peer.blockchain.Blockchain;
import com.vaibhav.ws.peer.blockchain.Constants;
import com.vaibhav.ws.peer.blockchain.Miner;
import com.vaibhav.ws.peer.blockchain.SHA256Helper;
import com.vaibhav.ws.peer.io.entity.BankEntity;
import com.vaibhav.ws.peer.io.entity.BlockEntity;
import com.vaibhav.ws.peer.service.UserService;
import com.vaibhav.ws.peer.shared.AesCryptUtil;
import com.vaibhav.ws.peer.shared.dto.BankDto;
import com.vaibhav.ws.peer.shared.dto.UserDto;
import com.vaibhav.ws.peer.ui.model.request.UserDetailsRquestModel;
import com.vaibhav.ws.peer.ui.model.response.UserRest;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//@Autowired
	//BankService bankService;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	BlockRepository blockRepository;
	
	//@Autowired
	//BankService bankService1;
	
	UserDetailsRquestModel newUserDetails;
	
	UserRest newRest;
	
	BankEntity bankEntity;
	
	
	final static public String KEY = "1D2A907A05656A7E1A570B14C573D192";
	
	AesCryptUtil aesCryptUtil;
	
	List<BlockEntity> blockList;
	
	
	@GetMapping
	public List<BankEntity> findAllBanks() {
		return bankRepository.findAll();
	}
	
	@GetMapping("/getData")
	public String getUser() {
		
		return "<html><body>"
	            + "<h1>WELCOME</h1>"
	            + "</body></html>";
	}
	
	@PostMapping("/blocks")
	@ResponseStatus(HttpStatus.CREATED)
	public BlockEntity blockEntity() {
		
		BlockEntity blockEntity = new BlockEntity();
		return blockEntry(blockEntity);
	}
	
	private BlockEntity blockEntry(BlockEntity blockEntity) {
		
		// TODO Auto-generated method stub
		
		blockList = (List<BlockEntity>) blockRepository.findAll();
		
		blockEntity.setHash("VaibhavTest");
		blockEntity.setId(7);
		blockEntity.setNonce(1233);
		blockEntity.setPreviousHash("VaibhavTest");
		blockEntity.setTimestamp(new Date().getTime());
		blockEntity.setTransaction("VaibhavTest");
	
		return blockRepository.save(blockEntity);
		
	}

	@PostMapping("/banks")
	@ResponseStatus(HttpStatus.CREATED)
	public BankEntity bankEntity(@RequestBody BankEntity bankEntity) {
		
		//bankEntity.setTransactionid("Test");
		//bankEntity.setUVR("vaibhav");
		return bankRepository.save(bankEntity);
	}
	
	
	@PostMapping("/new")
	public UserRest newpostUser(@RequestBody UserDetailsRquestModel newUserDetails) {
		
		UserRest retunValue = new UserRest();
		BankEntity bank = new BankEntity();
		
		
		retunValue.setFirstname(newUserDetails.getFirstname());
		retunValue.setLastname(newUserDetails.getLastname());
		retunValue.setPeerBankCode(newUserDetails.getPeerBankCode());
		retunValue.setPhone(newUserDetails.getPhone());
		retunValue.setEmail(newUserDetails.getEmail());
		
		retunValue.setAmount("1000.00");
		retunValue.setCurrency("INR");
		retunValue.setOptional("Optinal Field");
		retunValue.setPeerBankName("State Bank of India");
		retunValue.setPeerBankBranch("Goregaon West");
		
		retunValue.setPid("123456789");
		retunValue.setUVR("UVR123456789QWERYT");
		
		bank.setBank_verify(false);
		bank.setId(12123);
		bank.setPeerBankBranch("Test");
		bank.setPeerBankCode("Test");
		bank.setPeerBankName("test");
		//bank.setTransactionid("test");
		//bank.setUVR("test");
		//bankR.save(bank);
		System.out.println(bank.getId());
		
		BankDto bankDto = new BankDto();
		BeanUtils.copyProperties(bank, bankDto);
		
		//bankRepository.save(bankDto);
	
		
		Blockchain blockchain = new Blockchain();
		Miner miner = new Miner();
		
		Block block0 = new Block(0, "" , Constants.GENESIS_PREV_HASH);
		miner.mine(block0, blockchain);
		
		Block block1 = new Block(1, "transaction1" , blockchain.getBlockChain().get(blockchain.getSize()-1).getHash());
		miner.mine(block1, blockchain);
		
		Block block2 = new Block(2, "transaction2" , blockchain.getBlockChain().get(blockchain.getSize()-1).getHash());
		miner.mine(block2, blockchain);
		
		System.out.println("\n"+ "BLOCKCHAIN \n"+blockchain);
		System.out.println("Miner's Reward : "+miner.getReward());
		
		//miner.checkUserData();
		
		BlockEntity blockEntity = new BlockEntity();
		blockEntry(blockEntity);
		
		
		return retunValue;
		
	}
	
	/*@GetMapping("/students") 
	public List<Object> getStudents() {
		Object[] objects = blockRepository.getForObject("http://student-microservice/students", Object[].class);
		return Arrays.asList(objects);
	}*/
	
	@PostMapping
	public UserRest postUser(@RequestBody UserDetailsRquestModel UserDetails) {
		
		
		/*AesCryptUtil aesCryptUtil = new AesCryptUtil(KEY);
		aesCryptUtil.encrypt("VAIBHAV");
		
		System.out.println(aesCryptUtil.encrypt("VAIBHAV"));*/ //testing code snippet
		
		UserRest retunValue = new UserRest();
		
		System.out.println(UserDetails.getFirstname());
		System.out.println(UserDetails.getLastname());
		System.out.println(UserDetails.getPeerBankCode());
		System.out.println(UserDetails.getPhone());
		
		
		/*retunValue.setFirstname(UserDetails.getFirstname());
		retunValue.setLastname(UserDetails.getLastname());
		retunValue.setPeerBankCode(UserDetails.getPeerBankCode());
		retunValue.setPhone(UserDetails.getPhone());
		
		retunValue.setAmount("1000.00");
		retunValue.setCurrency("INR");
		retunValue.setOptional("Optinal Field");
		retunValue.setPeerBankName("State Bank of India");
		retunValue.setPeerBankBranch("Goregaon West");
		
		retunValue.setPid("123456789");
		retunValue.setUVR("UVR123456789QWERYT");*/
		
		
		
		//Bank DB
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(UserDetails, userDto);
		
		UserDto createUser =userService.createUser(userDto);
		BeanUtils.copyProperties(createUser, retunValue);
		
		
		
		//BANK DB
		/*BankDto bankDto = new BankDto();
		
		bankDto.setBank_verify(false);
		bankDto.setId(111);
		bankDto.setPeerBankBranch("Test");
		bankDto.setPeerBankCode("Test");
		bankDto.setPeerBankName("Test");
		bankDto.setTransactionid("Test");
		bankDto.setUVR("Test");
		
		BankDto bankdDto = userService.createUser(bankDto);
		
		System.out.println(bankdDto.getPeerBankBranch());
		
		
		
		
		/*BankDto bankDto = new BankDto();
		
		bankDto.setBank_verify(false);
		bankDto.setId(111);
		bankDto.setPeerBankBranch("Test");
		bankDto.setPeerBankCode("Test");
		bankDto.setPeerBankName("Test");
		bankDto.setTransactionid("Test");
		bankDto.setUVR("Test");
		
		BankDto createBankUser = bankService1.createUser(bankDto);
		
		createBankUser.setBank_verify(false);
		createBankUser.setId(111);
		createBankUser.setPeerBankBranch("Test");
		createBankUser.setPeerBankCode("Test");
		createBankUser.setPeerBankName("Test");
		createBankUser.setTransactionid("Test");
		createBankUser.setUVR("Test");*/
		
		
		
		
		return retunValue;
	}
	
}
