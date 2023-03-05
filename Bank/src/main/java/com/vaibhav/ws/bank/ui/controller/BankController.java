package com.vaibhav.ws.bank.ui.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.ws.bank.BankRepository;
import com.vaibhav.ws.bank.PeerBankRepository;
import com.vaibhav.ws.bank.UserRepository;
import com.vaibhav.ws.bank.exception.TransactionIdNotFoundException;
import com.vaibhav.ws.bank.io.entity.BankEntity;
import com.vaibhav.ws.bank.io.entity.UserBankEntity;
import com.vaibhav.ws.bank.io.entity.UserEntity;
import com.vaibhav.ws.bank.shared.utils.AesCryptUtil;
import com.vaibhav.ws.bank.ui.model.request.BankDetailsRquestModel;
import com.vaibhav.ws.bank.ui.model.request.RequestData;
import com.vaibhav.ws.bank.ui.model.response.BankRest;


@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	PeerBankRepository peerBankRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	String isCheckUVR="";
	
	final static public String KEY = "1D2A907A05656A7E1A570B14C573D192";
	
	@GetMapping(path = "/")
	public String getAllUSers() {
		return "Get AllUser was called with page";
	}
	
	@GetMapping(path = "/view")
	public String getBankView() {
		return "<html><body>\"\n"
				+ "	            + \"<h1>WELCOME</h1>\"\n"
				+ "	            + \"</body></html>";
	}
	
	
	@PostMapping("/bank")
	public List<BankEntity> bankEntity(@RequestBody BankEntity bankEntity) {
		
		
		return (List<BankEntity>) peerBankRepository.findAll();
		
	}
	
	@PostMapping("/newbank")
	public List<UserBankEntity> newbankEntity(@RequestBody UserBankEntity userBankEntity) {
		
		
		return (List<UserBankEntity>) bankRepository.findAll();
		
	}
	
	@PostMapping("/transaction")
	public UserEntity newbankEntity(@RequestBody RequestData requestData) {
		
		//RequestData requestData = new RequestData();
		String txn = requestData.getTransactionid();
		System.out.println(requestData.getTransactionid());
		System.out.println(requestData.getUVR());
		
		
		Optional<UserBankEntity> LS;
		LS = bankRepository.findById(txn);
		if(LS.isEmpty()) {throw new TransactionIdNotFoundException("Tranasction ID Not Found", txn);}
		
		System.out.println("LS VALUE__"+LS);
		
		isCheckUVR = LS.get().getUVR();
		System.out.println(LS.get().getUVR());
		System.out.println(isCheckUVR.equals(requestData.getUVR()));
		UserEntity userEntity  = userRepository.findByTransactionid(txn);
		
		if(isCheckUVR.equals(requestData.getUVR())) {
			System.out.println("Hello World");
			
			AesCryptUtil aesCryptUtil = new AesCryptUtil(KEY);
			System.out.println(aesCryptUtil.decrypt(isCheckUVR));
			
			
			//Save Status
			userEntity.setStatus("Transaction Successful");
			System.out.println(userEntity);
			
			userRepository.save(userEntity);
			
			//return bankRepository.findById(txn);
			
			return userEntity;
			
		}else {
			System.out.println(bankRepository.findById(txn));
			//System.out.println(bankRepository.findById(requestData.getTransactionid().toString()));
			//return bankRepository.findById(null);
			return userEntity;
		}
		
		
		/*if(isCheckUVR.equals(requestData.getUVR()) || bankRepository.findById(txn).isEmpty()) {
			System.out.println("Hello World");
			
		}*/
	
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@PostMapping("/new")
	public BankRest newpostUser(@RequestBody BankDetailsRquestModel newBankDetails) {
		
		BankRest retunValue = new BankRest();
		
		
		retunValue.setFirstname(newBankDetails.getFirstname());
		retunValue.setLastname(newBankDetails.getLastname());
		retunValue.setPhone(newBankDetails.getPhone());
		retunValue.setUVR("UVR123456789QWERYT");
	
		return retunValue;
		
	}
}