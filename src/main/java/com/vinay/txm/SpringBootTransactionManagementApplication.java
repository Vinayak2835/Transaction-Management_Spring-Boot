package com.vinay.txm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootTransactionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionManagementApplication.class, args);
	}

}
