package com.igreendata.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.igreendata.user.dto.User;
import com.igreendata.user.service.UserService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {UserController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	UserService userService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllUsersTest() throws Exception {
		List<User> users = new ArrayList<User>();
		when(userService.getAllUsers()).thenReturn(users);
		
		MvcResult result = mvc.perform(get("/users/all"))
				.andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}
