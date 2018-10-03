package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		String response = "";
		try {
			em.persist(e);
			response = "Saved";
		} catch (EntityExistsException ex) {

			response = "Employee exists in Database";
			// throw new RuntimeException("Emp exists");
		}
		return response;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Emp> getAll() {
		Query query = em.createQuery("select e from Emp e");
		//Query query = em.createNativeQuery("select * from EMP");
		return query.getResultList();

	}

	@Override
	public Emp findById(int id) {
		Emp e = em.find(Emp.class, id);
		if (e == null) {
			return new Emp();
		}
		return e;
	}

	@Override
	public Emp updte(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveGroup(List<Emp> empList) {

		return "";
	}

}
