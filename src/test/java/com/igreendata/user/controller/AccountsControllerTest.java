package com.igreendata.user.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
import static org.mockito.ArgumentMatchers.anyString;

import com.igreendata.user.dto.UserAccounts;
import com.igreendata.user.service.AccountService;
import com.igreendata.user.service.UserService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AccountsController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest
public class AccountsControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	UserService userService;
	
	@MockBean
	AccountService accountService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getUserAccountsTest() throws Exception {
		List<UserAccounts> userAccounts = new ArrayList<UserAccounts>();
		userAccounts.add(new UserAccounts());
		when(userService.getAccountsByUser(anyString())).thenReturn(userAccounts);
		
		MvcResult result = mvc.perform(get("/accounts/user?username=abc"))
				.andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}
