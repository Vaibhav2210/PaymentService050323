package com.vaibhav.ws.peer;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.ws.peer.io.entity.BlockEntity;

public interface BlockRepository extends CrudRepository<BlockEntity, Long> {

}
