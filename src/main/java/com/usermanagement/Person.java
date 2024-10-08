package com.usermanagement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Person {
	public void talking() {
		System.out.println("person is talking");
	}
	public void walking() {
		System.out.println("person is walking");
			
		}
		public void eating() {
			System.out.println("person is eating");
		}
}
