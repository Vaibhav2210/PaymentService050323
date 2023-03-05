package com.vaibhav.ws.bank;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vaibhav.ws.bank.io.entity.BankEntity;

@Repository
@Service
public interface PeerBankRepository extends CrudRepository<BankEntity, Integer> {

}
