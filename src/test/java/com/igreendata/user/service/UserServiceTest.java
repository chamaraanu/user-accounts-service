package com.igreendata.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.igreendata.user.exception.AccountException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import static org.mockito.ArgumentMatchers.anyString;

import com.igreendata.user.domain.Accounts;
import com.igreendata.user.domain.User;
import com.igreendata.user.repository.UserRepository;

@SpringBootTest
@ContextConfiguration(classes = {UserService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@MockBean
	UserRepository userRepository;
	
	@MockBean
	ModelMapper modelMapper;
	
	@InjectMocks
	UserService userService;
	
	@BeforeAll
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void getAccountsByUserTest() {
		List<Accounts> accounts = new ArrayList<Accounts>();
		accounts.add(new Accounts());
		User user = new User();
		user.setAccounts(accounts);
		when(userRepository.findUserByUsername(anyString())).thenReturn(user);
		assertNotNull(userService.getAccountsByUser("abc"));
	}

	@Test
	public void getAccountByUserFailTest() {
		User user = new User();
		user.setUsername("abc");
		when(userRepository.findUserByUsername(anyString())).thenReturn(user);
		AccountException accountException = assertThrows(
				AccountException.class, () -> userService.getAccountsByUser("abc"));
		assertTrue(accountException.getMessage().contains("Account Not Found!"));
	}

	@Test
	public void getAllUsersServiceTest() {
		List<User> users = new ArrayList<User>();
		users.add(new User());
		when(userRepository.findAll()).thenReturn(users);
		assertNotNull(userService.getAllUsers());
	}
	


}
