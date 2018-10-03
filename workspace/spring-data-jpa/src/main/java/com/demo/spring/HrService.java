package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Service

public class HrService {

	@Autowired
	private EmpRepository dao;

	@Transactional()
	public String registerEmp(int id, String name, String city, double salary) {
		String resp = "";
		if(dao.existsById(id)) {
			resp="Emp Exists";
		}else {
			dao.save(new Emp(id, name, city, salary));
			 resp="data saved";
		}
		return resp;
	}

	public List<Emp> getEmpList() {
		return dao.findAll();
	}

	@Transactional()
	public String addToDept(List<Emp> emps) {
		for (Emp e : emps) {
			dao.save(e);
		}
		return "success";
	}
}
