package com.igreendata.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.igreendata.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import com.igreendata.user.dto.User;
import com.igreendata.user.dto.UserAccounts;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Cacheable(value = "useraccounts")
	public List<UserAccounts> getAccountsByUser(String username) {
		log.info("getAccountsByUser: fetching accounts by the user...");
		return userRepository.findUserByUsername(username).getAccounts()
				.stream()
				.map(accounts -> modelMapper.map(accounts, UserAccounts.class))
				.collect(Collectors.toList());
	}
	
	@Cacheable(value = "users")
	public List<User> getAllUsers() {
		log.info("getAllUsers: fetching all the users...");
		return userRepository.findAll()
				.stream()
				.map(user -> modelMapper.map(user, User.class))
				.collect(Collectors.toList());
	}

}
