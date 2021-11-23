package com.igreendata.user.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.igreendata.user.domain.User;
import com.igreendata.user.exception.AccountException;
import com.igreendata.user.exception.TransactionsException;
import com.igreendata.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyObject;

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
	UserRepository userRepository;
	
	@MockBean
	ModelMapper modelMapper;

	@Mock
	private Pageable pageableMock;
	
	@InjectMocks
	TransactionsService transactionsService;
	
	@BeforeAll
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getTransactionsByAccountNumberTest() {
		User user = new User();
		Accounts account = new Accounts();
		account.setAccountNumber(13956);
		user.setAccounts(Arrays.asList(account));
		List<Transactions> transactions = new ArrayList<Transactions>();
		transactions.add(new Transactions());
		when(userRepository.findUserByUsername(anyString())).thenReturn(user);
		when(transactionRepository.findByTransactionAccount(anyInt(), anyObject())).thenReturn(transactions);
		assertNotNull(transactionsService.getTransactionsByAccountNumber("abc", 13956, 0, 1));
	}

	@Test
	public void getTransactionsByAccountNumberErrorTest() throws Exception {
		User user = new User();
		user.setAccounts(Arrays.asList(new Accounts()));
		List<Transactions> transactions = new ArrayList<Transactions>();
		transactions.add(new Transactions());
		when(userRepository.findUserByUsername(anyString())).thenReturn(user);
		when(transactionRepository.findByTransactionAccount(anyInt(), anyObject())).thenReturn(transactions);
		AccountException accountException = assertThrows(
				AccountException.class, () -> transactionsService.getTransactionsByAccountNumber("abc", 123, 0, 1));
		assertTrue(accountException.getMessage().contains("Account not found for the user!"));
	}

}
