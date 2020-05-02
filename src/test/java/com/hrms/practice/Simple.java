package com.hrms.practice;

import org.junit.Test;

public class Simple {
	@Test
 public static void hello() {
		String name=hello.sayHello("Anna");
		System.out.println(name);
	}
 
}

class hello{
	
	public static String sayHello(String name) {
		 System.out.println("Hello, "+name+"!");
		return name;
	 }
	
}