package com.igreendata.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igreendata.user.dto.AccountTransactions;
import com.igreendata.user.response.GeneralResponse;
import com.igreendata.user.service.TransactionsService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/transactions")
@Slf4j
public class TransactionsController {
	
	@Autowired
	TransactionsService transactionsService;
	
	@GetMapping(value = "/foraccount")
	public ResponseEntity<GeneralResponse<List<AccountTransactions>>> getTransactions(@RequestParam int accountNumber) {
		log.info("transactions for the account api");
		GeneralResponse<List<AccountTransactions>> accountTransactions = 
				new GeneralResponse<List<AccountTransactions>>();
		accountTransactions.setData(transactionsService.getTransactionsByAccountNumber(accountNumber));
		return ResponseEntity.ok(accountTransactions);
	}

}
