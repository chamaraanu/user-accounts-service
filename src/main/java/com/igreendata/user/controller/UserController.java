package com.igreendata.user.controller;

import java.util.List;

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
	
	@GetMapping(value = "/all")
	public ResponseEntity<GeneralResponse<List<User>>> getAllUsers() throws RuntimeException {
		log.info("all users are requested. sample api");
		GeneralResponse<List<User>> userResponse = new GeneralResponse<List<User>>();
		userResponse.setData((List<User>) usersService.getAllUsers());
		return ResponseEntity.ok(userResponse);
	}

}
