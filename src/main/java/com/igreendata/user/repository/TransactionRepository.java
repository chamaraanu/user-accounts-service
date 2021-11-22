package com.igreendata.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igreendata.user.domain.Transactions;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Long>{

	List<Transactions> findByTransactionAccount(int transactionAccount);
}
