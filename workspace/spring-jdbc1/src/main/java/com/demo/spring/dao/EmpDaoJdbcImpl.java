package com.demo.spring.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public String save(Emp e) {
		jt.update((con)-> {
				PreparedStatement pst = con
						.prepareStatement("insert into emp(empno,name,address,salary) values(?,?,?,?)");
				pst.setInt(1, e.getEmpid());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
		});
		return "saved";
	}

	@Override
	public String delete(int id) {
		jt.update((con)-> {
			PreparedStatement pst = con
					.prepareStatement("delete from emp where empno=?");
			pst.setInt(1, id);
			
			return pst;
	});
		return "deleted";
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> empList=	jt.query("select * from emp", (rs,rowNum)-> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"),
					rs.getString("ADDRESS"),
					rs.getDouble("SALARY"));
		});
		return empList;
	}

	@Override
	public Emp findById(int id) {
		Emp emp=	jt.queryForObject("select * from emp where empno="+id, (rs,rowNum)-> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"),
					rs.getString("ADDRESS"),
					rs.getDouble("SALARY"));
		});
		return emp;
	}

	@Override
	public Emp updte(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveGroup(List<Emp> empList) {
		for(Emp e:empList) {
			save(e);
		}
		return "group saved";
	}

}
