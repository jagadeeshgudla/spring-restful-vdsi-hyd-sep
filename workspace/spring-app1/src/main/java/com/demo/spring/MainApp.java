package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
		Mail mail=(Mail)ctx.getBean("mail");
		System.out.println(mail.getMessage().getBody());
		
		Mail mail1=(Mail)ctx.getBean("mail");
		
		System.out.println("Are these same objects: "+(mail.getMessage()==mail1.getMessage()));

	}

}
