package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.demo.spring.entity.Emp;

public class JdbcMain2 {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

	List<Emp> empList=	jt.query("select * from emp", new RowMapper<Emp>() {

			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"),
						rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});
	
	List<Emp> empList1=	jt.query("select * from emp", (rs,rowNum)-> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"),
					rs.getString("ADDRESS"),
					rs.getDouble("SALARY"));
		});
	
	empList.stream().forEach(z->System.out.println(z.getName()
			+" "+z.getSalary()));
	
	
	Emp emp=	jt.queryForObject("select * from emp where empno=104", (rs,rowNum)-> {

		return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"),
				rs.getString("ADDRESS"),
				rs.getDouble("SALARY"));
	});
	}
}
