package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		HrService service=ctx.getBean(HrService.class);
		
		System.out.println(service.registerEmployee(100, "James", "Hyderabad", 78000));
	}

}
