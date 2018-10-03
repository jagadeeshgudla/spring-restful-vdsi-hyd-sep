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
	
	public String registerEmp(int id, String name,String city,double salary) {
		String resp=dao.save(new Emp(id, name, city, salary));
		return resp;
	}
	
	public List<Emp> getEmpList(){
		return dao.getAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public String addToDept(List<Emp> emps) {
		return dao.saveGroup(emps);
	}
}
