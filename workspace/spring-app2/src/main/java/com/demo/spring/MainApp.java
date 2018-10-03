package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
		
		HrService service=ctx.getBean(HrService.class);
		
		System.out.println(service.registerEmployee(100, "James", "Hyderabad", 78000));
	}

}
