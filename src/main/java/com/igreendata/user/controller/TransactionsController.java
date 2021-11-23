package com.igreendata.user.controller;

import java.util.List;

import com.igreendata.user.exception.GeneralError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.igreendata.user.dto.AccountTransactions;
import com.igreendata.user.response.GeneralResponse;
import com.igreendata.user.service.TransactionsService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/accounts")
@Slf4j
public class TransactionsController {
	
	@Autowired
	TransactionsService transactionsService;

	@Operation(summary = "transactions list for user account",
			description = "Retrieves transactions list for user account")
	@ApiResponses( value = {
			@ApiResponse(responseCode = "200",
					description = "Successful retrieval of transactions list for user account"),
			@ApiResponse(responseCode = "400",
					description = "Error when fetching transactions",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = GeneralError.class)))
	})
	@GetMapping(value = "/{username}/transactions")
	public ResponseEntity<GeneralResponse<List<AccountTransactions>>> getTransactions(@PathVariable String username,
																					  @RequestParam int accountNumber,
																					  @RequestParam(defaultValue="0") int page ,
																					  @RequestParam(defaultValue="10") int size) {
		log.info("transactions for the account api");
		GeneralResponse<List<AccountTransactions>> accountTransactions = 
				new GeneralResponse<List<AccountTransactions>>();
		accountTransactions.setData(transactionsService.getTransactionsByAccountNumber(username, accountNumber, page, size));
		return ResponseEntity.ok(accountTransactions);
	}

}
