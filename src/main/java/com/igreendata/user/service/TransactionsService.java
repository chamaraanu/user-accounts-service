package com.igreendata.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.igreendata.user.dto.AccountTransactions;
import com.igreendata.user.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionsService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Cacheable(value = "accounttransactions")
	public List<AccountTransactions> getTransactionsByAccountNumber(int accountNumber) {
		log.info("getTransactionsByAccountNumber: fetching transactions by the account");
		return transactionRepository.findByTransactionAccount(accountNumber)
				.stream()
				.map(transactions -> modelMapper.map(transactions, AccountTransactions.class))
				.collect(Collectors.toList());
	}

}