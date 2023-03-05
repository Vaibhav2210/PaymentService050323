package com.vaibhav.ws.bank;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.ws.bank.io.entity.UserBankEntity;

public interface BankRepository extends CrudRepository<UserBankEntity, String> {
	
	Optional<UserBankEntity> findById(int i);

}
