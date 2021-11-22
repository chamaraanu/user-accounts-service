package com.igreendata.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class UserAccountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAccountsServiceApplication.class, args);
	}

}
