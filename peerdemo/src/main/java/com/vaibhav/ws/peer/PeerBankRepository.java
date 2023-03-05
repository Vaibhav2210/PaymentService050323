package com.vaibhav.ws.peer;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.ws.peer.io.entity.PeerBankEntity;

public interface PeerBankRepository extends CrudRepository<PeerBankEntity, Integer> {

}
