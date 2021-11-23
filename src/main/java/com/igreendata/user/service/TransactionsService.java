package com.igreendata.user.service;

import java.util.List;
import java.util.stream.Collectors;

import com.igreendata.user.exception.AccountException;
import com.igreendata.user.exception.TransactionsException;
import com.igreendata.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Cacheable(value = "accounttransactions")
	public List<AccountTransactions> getTransactionsByAccountNumber(String username, int accountNumber, int page, int size) {
		log.info("getTransactionsByAccountNumber: fetching transactions by the account");

		if (userRepository.findUserByUsername(username).getAccounts()
				.stream()
				.anyMatch(accounts -> accounts.getAccountNumber() == accountNumber)) {
			log.info("account exists");
			List<AccountTransactions> accountTransactions;
			try {
				accountTransactions = transactionRepository.findByTransactionAccount(accountNumber, PageRequest.of(page, size))
						.stream()
						.map(transactions -> modelMapper.map(transactions, AccountTransactions.class))
						.collect(Collectors.toList());
				if (accountTransactions.size() > 0) {
					return accountTransactions;
				} else {
					throw new TransactionsException("Zero transactions found for the account!");
				}
			} catch (Exception e) {
				throw new TransactionsException("Error occurred while retrieving transactions", e.getCause());
			}
		} else {
			throw new AccountException("Account not found for the user!");
		}
	}
}