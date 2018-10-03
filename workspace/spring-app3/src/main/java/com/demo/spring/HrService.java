package com.demo.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService implements InitializingBean {

	@Autowired
	EmpDao dao;

	/*public void setDao(EmpDao dao) {	this.dao = dao;	}*/

	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("I am ready Now..");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("I am now even better...");
		
	}
}
