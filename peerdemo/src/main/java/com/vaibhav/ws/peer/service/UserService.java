package com.vaibhav.ws.peer.service;

import org.springframework.stereotype.Service;

import com.vaibhav.ws.peer.shared.dto.BankDto;
import com.vaibhav.ws.peer.shared.dto.UserDto;

@Service
public interface UserService {

	UserDto createUser(UserDto user);

	BankDto createUser(BankDto bankDto);
}
