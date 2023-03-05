package com.vaibhav.ws.peer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vaibhav.ws.peer.io.entity.UserEntity;
@Repository
@Service
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	
	UserEntity findById(int id);
	List<UserEntity> findAll();
	void deleteById(int id);
	UserRepository findById(String UVR);
}
