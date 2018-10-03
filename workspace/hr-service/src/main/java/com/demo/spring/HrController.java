package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class HrController {

	@Autowired
	HrService service;

	@GetMapping(path = "/hr/get", produces = "application/json")
	public MessageWrapper<Emp> getEmp(@RequestParam("eid") int id) {
		return service.getEmpDetails(id);
	}

	@GetMapping(path = "/hr/emplist", produces = "application/json")
	public MessageWrapper<List<Emp>> listAllEmp() {
		return service.getEmpList();
	}
}
