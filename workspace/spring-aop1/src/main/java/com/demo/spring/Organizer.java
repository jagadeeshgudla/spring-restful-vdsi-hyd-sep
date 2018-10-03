package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class Organizer {
	@Pointcut("execution(* com.demo.spring.*.performe(..))")
	private void mypcut() {}
	
	@Around("mypcut()")
	public void service(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Arond Advice: Tickets collected...");
		pjp.proceed();
		System.out.println("Around Advice: Audience Exited...");
	}
	
}
