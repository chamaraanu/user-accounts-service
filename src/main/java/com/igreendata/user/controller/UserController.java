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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreendata.user.dto.User;
import com.igreendata.user.response.GeneralResponse;
import com.igreendata.user.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
	
	@Autowired 
	UserService usersService;

	@Operation(summary = "all users",
			description = "Retrieves all users")
	@ApiResponses( value = {
			@ApiResponse(responseCode = "200",
					description = "Successful retrieval of all users"),
			@ApiResponse(responseCode = "400",
					description = "Error when fetching users",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = GeneralError.class)))
	})
	@GetMapping(value = "/all")
	public ResponseEntity<GeneralResponse<List<User>>> getAllUsers() throws RuntimeException {
		log.info("all users are requested. sample api");
		GeneralResponse<List<User>> userResponse = new GeneralResponse<List<User>>();
		userResponse.setData((List<User>) usersService.getAllUsers());
		return ResponseEntity.ok(userResponse);
	}

}
