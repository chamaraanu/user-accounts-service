package com.igreendata.user.exception;

import lombok.Getter;

@Getter
public class GeneralError {
	
	private int errorCode;
	private String errorMessage;
	private String messageId;
	
	public GeneralError(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public GeneralError(int errorCode, String errorMessage, String messageId) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.messageId = messageId;
	}

}
