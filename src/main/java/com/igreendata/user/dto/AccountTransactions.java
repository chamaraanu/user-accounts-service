package com.igreendata.user.dto;

import java.util.Date;
import lombok.Data;

@Data
public class AccountTransactions {
	
	private int transactionNumber;
	private int transactionAccount;
	private Date valueDate;
	private float debitAmount;
	private float creditAmount;
	private String bookkeeping;
	private String transactionNarrative;

}
