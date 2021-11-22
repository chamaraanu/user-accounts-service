package com.igreendata.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data 
@Entity
@Table(name = "transactions")
public class Transactions {
	
	@Id
	@Column(name = "transaction_number")
	private int transactionNumber;
	
	@Column(name = "transaction_account")
	private int transactionAccount;
	
	@Column(name = "value_date")
	private Date valueDate;
	
	@Column(name = "debit_amount")
	private float debitAmount;
	
	@Column(name = "credit_amount")
	private float creditAmount;
	
	@Column(name = "book_keeping")
	private String bookkeeping;
	
	@Column(name = "transaction_narrative")
	private String transactionNarrative;

}
