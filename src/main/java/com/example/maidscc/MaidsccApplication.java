package com.example.maidscc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MaidsccApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaidsccApplication.class, args);
	}

}
