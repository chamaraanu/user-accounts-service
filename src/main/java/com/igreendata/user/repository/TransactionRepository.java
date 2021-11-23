package com.igreendata.user.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.igreendata.user.domain.Transactions;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transactions, Long> {

	List<Transactions> findByTransactionAccount(int transactionAccount, Pageable pageable);
}
