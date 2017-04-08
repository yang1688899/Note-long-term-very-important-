package com.aptech.springtx83.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aptech.springtx83.model.Emp;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void insertEmp(final Emp emp) throws ClassNotFoundException, SQLException {

		final String sql = "insert into emp (empno) values (?)";

		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, emp.getEmpno());
			}
		});
		
	}

}
