package com.yang.springjdbcpractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.yang.springjdbcpractice.model.Emp;

@Component("empDao")
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 直接使用JdbcTemplate执行 方式一
	 */
	@Override
	public void insert(final Emp emp) {
		
		final String sql = "insert into emp (empno) values (?)";
		
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement arg0) throws SQLException {
				arg0.setInt(1, emp.getEmpno());				
			}
		};
		
		jdbcTemplate.update(sql, pss );

	}
	
	/**
	 * 直接使用JdbcTemplate执行 方式二
	 */
	@Override
	public void insert2(final Emp emp){
		
		final String sql = "insert into emp (empno,ename) values (?,?)";
		
		Object[] args = new Object[]{emp.getEmpno(),emp.getEname()};
		
		jdbcTemplate.update(sql, args, new int[]{Types.INTEGER,Types.VARCHAR});
	}
	
	/**
	 * 直接使用JdbcTemplate执行 方式三
	 */
	@Override
	public void insert3(final Emp emp) {
		
		final String sql = "insert into emp (empno,ename) values (?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, emp.getEmpno());
				ps.setString(2, emp.getEname());
				
				return ps;
			}
		});
		
	}
	
	
	/**
	 *  批量插入数据
	 */
	public void batchInsert(final List<Emp> emps){
		final String sql = "insert into emp (empno) values (?)";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				
					Emp emp = emps.get(index);
					
					ps.setInt(1, emp.getEmpno());
			}
			
			@Override
			public int getBatchSize() {
			
				return emps.size();
			}
		});
	}
	
	/**
	 * 实际使用时，使用序列(sequence)来确保唯一标识符
	 */
	
	public void insertWithSq(final List<Emp> emps){
		
		final String sql = "insert into emp (empno,ename) values (sq_emp.nextval,?)";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				
				Emp emp = emps.get(index);
				
				ps.setString(1, emp.getEname());
			}
			
			@Override
			public int getBatchSize() {
				
				return emps.size();
			}
		});
		
	}
	
	

	

}
