package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AopConfig.class);
		
		//Thread.sleep(5000);
		//Performer singer = (Performer) ctx.getBean("singer");
		Singer singer=(Singer)ctx.getBean("singer");
		//Thread.sleep(5000);
		singer.performe();
		
		System.out.println(singer.getClass().getName());
	}

}
