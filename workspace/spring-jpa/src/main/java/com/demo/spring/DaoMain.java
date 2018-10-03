package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;

public class DaoMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService service = ctx.getBean(HrService.class);

		
		//System.out.println(service.registerEmp(204, "Reena", "Hyderabad", 78000));

		
		 for(Emp e:service.getEmpList()) {
		 System.out.println(e.getName()+" "+e.getSalary()); }
		 
/*
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(305, "Robin", "Chennai", 89000));
		empList.add(new Emp(306, "Scott", "London", 78000));
		empList.add(new Emp(307, "King", "Hyderabad", 89000));
		empList.add(new Emp(303, "Shrek", "Bangalore", 89000));
		empList.add(new Emp(308, "Barbie", "Hyderabad", 89000));
		
		System.out.println("*************"+service.getClass().getName());
		
		System.out.println(service.addToDept(empList));
		*/
		
	}

}
