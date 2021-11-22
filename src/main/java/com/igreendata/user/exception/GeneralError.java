package com.igreendata.user.exception;

import lombok.Getter;

@Getter
public class GeneralError {
	
	private int errorCode;
	private String errorMessage;
	
	public GeneralError(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
