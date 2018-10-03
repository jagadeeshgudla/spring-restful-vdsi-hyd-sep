package com.demo.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MyJmsReceiver {

	public static void main(String[] args) throws JMSException{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt = ctx.getBean(JmsTemplate.class);
		
		TextMessage tm=(TextMessage)jt.receive("testQueue");
		System.out.println(tm.getText());


	}

}
