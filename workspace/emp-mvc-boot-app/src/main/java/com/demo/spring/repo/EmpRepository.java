package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	@Query(name="getEmpWithSal",value="select e from Emp e where salary between ?1 and ?2")
	public List<Emp> getEmpWithSal(double sal1,double sal2);
}
