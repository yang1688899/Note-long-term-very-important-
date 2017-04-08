package com.yang.springtx.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.yang.springtx.model.Emp;

@Component("empDao")
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void insertEmp(final Emp emp) {
		
		String sql = "insert into emp (empno,ename) values (sq_emp.nextval,?)";
		
		jdbcTemplate.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, emp.getEname());
			}
			
		});

	}
	
}
