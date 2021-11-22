package com.igreendata.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igreendata.user.dto.UserAccounts;
import com.igreendata.user.response.GeneralResponse;
import com.igreendata.user.service.AccountService;
import com.igreendata.user.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/accounts")
@Slf4j
public class AccountsController {

	@Autowired
	AccountService accountsService;
	
	@Autowired 
	UserService usersService;
	
	@GetMapping(value = "/useraccounts")
	public ResponseEntity<GeneralResponse<List<UserAccounts>>> getUserAccounts(@RequestParam String username) {
		log.info("accounts by the user api");
		GeneralResponse<List<UserAccounts>> userAccounts = new GeneralResponse<List<UserAccounts>>();
		userAccounts.setData(usersService.getAccountsByUser(username));
		return ResponseEntity.ok(userAccounts);
	}
}
