package com.igreendata.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.igreendata.user.dto.AccountTransactions;
import com.igreendata.user.service.TransactionsService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {TransactionsController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest
public class TransactionsControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	TransactionsService transactionsService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getTransactionsTest() throws Exception {
		List<AccountTransactions> accoutTransactions = new ArrayList<AccountTransactions>();
		when(transactionsService.getTransactionsByAccountNumber(anyInt())).thenReturn(accoutTransactions);
		
		MvcResult result = mvc.perform(get("/transactions/foraccount?accountNumber=123"))
				.andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
}
