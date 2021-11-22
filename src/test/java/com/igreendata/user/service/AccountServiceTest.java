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

import com.igreendata.user.domain.Accounts;
import com.igreendata.user.repository.AccountRepository;

@SpringBootTest
@ContextConfiguration(classes = {AccountService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountServiceTest {
	
	@MockBean 
	AccountRepository accountRepository;
	
	@MockBean 
	ModelMapper modelMapper;
	
	@InjectMocks
	AccountService accountService;
	
	@BeforeAll
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getAllAccountsTest() {
		List<Accounts> accounts = new ArrayList<Accounts>();
		accounts.add(new Accounts());
		when(accountRepository.findAll()).thenReturn(accounts);
		assertNotNull(accountService.getAllAccounts());
	}

}
