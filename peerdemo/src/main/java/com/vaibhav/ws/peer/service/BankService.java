package com.vaibhav.ws.peer.service;

import org.springframework.stereotype.Service;

import com.vaibhav.ws.peer.shared.dto.BankDto;

@Service
public interface BankService {
	
	BankDto createUser(BankDto bank);

}
