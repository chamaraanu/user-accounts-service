package com.igreendata.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igreendata.user.exception.GeneralError;
import com.igreendata.user.response.GeneralResponse;

@ControllerAdvice
public class UserServiceErrorAdvice {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<GeneralResponse<GeneralError>> handleGeneralError(RuntimeException exception) {
		GeneralError generalError = new GeneralError(-99, "Error occurred!");
		GeneralResponse<GeneralError> response = new GeneralResponse<GeneralError>();
		response.setData(generalError);
		
		return new ResponseEntity<GeneralResponse<GeneralError>>(response, HttpStatus.BAD_REQUEST);
	}
}
