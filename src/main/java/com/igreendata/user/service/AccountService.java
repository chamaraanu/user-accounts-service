package com.igreendata.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igreendata.user.dto.UserAccounts;
import com.igreendata.user.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<UserAccounts> getAllAccounts() {
		return accountRepository.findAll()
				.stream()
				.map(accounts -> modelMapper.map(accounts, UserAccounts.class))
				.collect(Collectors.toList());
	}
}
