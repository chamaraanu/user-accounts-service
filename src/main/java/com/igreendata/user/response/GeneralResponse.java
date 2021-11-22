package com.igreendata.user.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class GeneralResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6926971253117407154L;
	
	private int statusCode;
	private String statusDesc;
	private String messageId;
	private T data;
}
