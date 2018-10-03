package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Audience {
	@Pointcut("execution(* com.demo.spring.*.performe(..))")
	private void mypcut() {}

	@Before("mypcut()")
	public void takeSeat() {
		System.out.println("Audience now take seats...");
	}

	@Before("mypcut()")
	public void switchedOffMobile() {
		System.out.println("Audience now switched off mobiles...");
	}

	@AfterReturning("mypcut()")
	public void applaud() {
		System.out.println("Good singing..Clap!Clap!Clap!");
	}
}
