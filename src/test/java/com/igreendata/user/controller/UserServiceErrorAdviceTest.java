package com.igreendata.user.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;

import com.igreendata.user.exception.GeneralError;
import com.igreendata.user.response.GeneralResponse;

@SpringBootTest(classes = { MessageSource.class })
public class UserServiceErrorAdviceTest {
	
	@InjectMocks
	private UserServiceErrorAdvice userServiceErrorAdvice;
	
	@Test
	void handleRunTimeException_RuntimeException() {
		ResponseEntity<GeneralResponse<GeneralError>> response = userServiceErrorAdvice.handleGeneralError(new RuntimeException());
		assertNotNull(response);
	}
	

}
