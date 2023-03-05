/**
 * 
 */
package com.vaibhav.ws.peer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vaibhav.ws.peer.io.entity.BankEntity;
/**
 * @author Admin
 *
 */

@Repository
@Service
public interface BankRepository extends CrudRepository<BankEntity, Integer> {
	
	 
	
	BankEntity findById(int id);
	List<BankEntity> findAll();
	void deleteById(int id);
	BankRepository findById(String peerBankCode);
}
