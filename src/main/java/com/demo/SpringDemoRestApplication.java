package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class SpringDemoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoRestApplication.class, args);
//		
//		User user = new User();
//		user.setName("fabio");
//		user.setPassword("123");
//		user.setRole(Role.ADMIN);
//		
//		System.out.println(user.toString());


	}

}
