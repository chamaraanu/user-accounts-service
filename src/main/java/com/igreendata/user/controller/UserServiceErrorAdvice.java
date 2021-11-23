package com.igreendata.user.controller;

import com.igreendata.user.exception.AccountException;
import com.igreendata.user.exception.TransactionsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igreendata.user.exception.GeneralError;
import com.igreendata.user.response.GeneralResponse;

@ControllerAdvice
public class UserServiceErrorAdvice {

	@ExceptionHandler(AccountException.class)
	public ResponseEntity<GeneralError> handleAccountException(AccountException exception) {
		GeneralError response = new GeneralError(-99, exception.getMessage());
		return new ResponseEntity<GeneralError>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TransactionsException.class)
	public ResponseEntity<GeneralError> handleTransactionsException(TransactionsException exception) {
		GeneralError response = new GeneralError(-99, exception.getMessage());
		return new ResponseEntity<GeneralError>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<GeneralError> handleGeneralError(RuntimeException exception) {
		GeneralError response = new GeneralError(-99, "Error occurred!");
		return new ResponseEntity<GeneralError>(response, HttpStatus.BAD_REQUEST);
	}
}
