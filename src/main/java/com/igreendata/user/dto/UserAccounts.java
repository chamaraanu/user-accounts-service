package com.igreendata.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccounts {
	
	private int accountNumber;
	private String accountName;
	private String accountType;
	private Date balanceDate;
	private String currency;
	private float openingAvailableBalance;
	

}
