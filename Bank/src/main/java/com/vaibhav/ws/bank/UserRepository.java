package com.vaibhav.ws.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vaibhav.ws.bank.io.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	

	UserEntity findByTransactionid(String transactionid);

}
