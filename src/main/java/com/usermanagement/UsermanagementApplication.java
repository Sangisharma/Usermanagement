package com.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UsermanagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(UsermanagementApplication.class, args);
//		//for (int i = 0; i < 10; i++) {
//			Person p = ctx.getBean(Person.class);
//			System.out.println(p.hashCode());
//		}
	}

}
