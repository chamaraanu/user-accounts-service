package com.igreendata.user.controller;

import java.util.List;

import com.igreendata.user.exception.GeneralError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@Operation(summary = "accounts list for user",
		description = "Retrieves accounts list for user")
	@ApiResponses( value = {
			@ApiResponse(responseCode = "200",
					description = "Successful retrieval of accounts list for user"),
			@ApiResponse(responseCode = "400",
					description = "Error when fetching accounts",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = GeneralError.class)))
	})
	@GetMapping(value = "/{username}")
	public ResponseEntity<GeneralResponse<List<UserAccounts>>> getUserAccounts(@PathVariable String username) {
		log.info("accounts by the user api");
		GeneralResponse<List<UserAccounts>> userAccounts = new GeneralResponse<List<UserAccounts>>();
		userAccounts.setData(usersService.getAccountsByUser(username));
		return ResponseEntity.ok(userAccounts);
	}


}
