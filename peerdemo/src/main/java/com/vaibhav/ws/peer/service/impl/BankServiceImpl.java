package com.vaibhav.ws.peer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.ws.peer.BankRepository;
import com.vaibhav.ws.peer.io.entity.BankEntity;
import com.vaibhav.ws.peer.service.BankService;
import com.vaibhav.ws.peer.shared.dto.BankDto;


public class BankServiceImpl implements BankService {
	
	@Autowired
	BankRepository bankRepository;

	@Override
	public BankDto createUser(BankDto bank) {
		
		BankEntity bankEntity = new BankEntity();
		BeanUtils.copyProperties(bank, bankEntity);
		
		
		bankEntity.setBank_verify(false);
		bankEntity.setId(111);
		bankEntity.setPeerBankBranch("Test");
		bankEntity.setPeerBankCode("Test");
		bankEntity.setPeerBankName("Test");
		//bankEntity.setTransactionid("Test");
		//bankEntity.setUVR("Test");
		
		BankEntity storedBankDetails = bankRepository.save(bankEntity);
		
		BankDto returnValue = new BankDto();
		BeanUtils.copyProperties(storedBankDetails, returnValue);
		
		return returnValue;
	}

}
