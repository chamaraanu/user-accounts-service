package com.igreendata.user.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import static org.mockito.ArgumentMatchers.anyInt;

import com.igreendata.user.domain.Accounts;
import com.igreendata.user.domain.Transactions;
import com.igreendata.user.repository.TransactionRepository;

@SpringBootTest
@ContextConfiguration(classes = {TransactionsService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransactionsServiceTest {
	
	@MockBean
	TransactionRepository transactionRepository;
	
	@MockBean
	ModelMapper modelMapper;
	
	@InjectMocks
	TransactionsService transactionsService;
	
	@BeforeAll
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getTransactionsByAccountNumberTest() {
		List<Transactions> transactions = new ArrayList<Transactions>();
		transactions.add(new Transactions());
		when(transactionRepository.findByTransactionAccount(anyInt())).thenReturn(transactions);
		assertNotNull(transactionsService.getTransactionsByAccountNumber(123));
	}

}
