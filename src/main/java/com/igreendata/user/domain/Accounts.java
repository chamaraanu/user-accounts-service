package com.igreendata.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Accounts {
	
	@Id 
	@Column(name = "account_number")
	private int accountNumber;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "balance_date")
	private Date balanceDate;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "opening_available_balance")
	private float openingAvailableBalance;
	
}
