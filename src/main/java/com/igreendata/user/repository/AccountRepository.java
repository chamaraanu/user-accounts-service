package com.igreendata.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igreendata.user.domain.Accounts;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Long> {
	
	List<Accounts> findByUserId(int userId);	
	
	Accounts findTransactionsByAccountNumber(int accountNumber);
	
	List<Accounts> findAll();

}
