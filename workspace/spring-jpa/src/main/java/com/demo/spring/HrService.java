package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service

public class HrService {

	@Autowired
	private EmpDao dao;
	
	@Transactional()
	public String registerEmp(int id, String name,String city,double salary) {
		String resp="";
		try {
		resp=dao.save(new Emp(id, name, city, salary));
		}catch(Exception ex) {
			System.out.println("We caught you!!!");
		}
		return resp;
	}
	
	public List<Emp> getEmpList(){
		return dao.getAll();
	}
	
	@Transactional()
	public String addToDept(List<Emp> emps) {
		return dao.saveGroup(emps);
	}
}
