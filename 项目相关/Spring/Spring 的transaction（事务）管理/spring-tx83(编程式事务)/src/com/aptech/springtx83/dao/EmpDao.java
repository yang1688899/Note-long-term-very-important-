package com.aptech.springtx83.dao;

import java.sql.SQLException;

import com.aptech.springtx83.model.Emp;

public interface EmpDao {

	/**
	 * 新增雇员信息
	 * @param emp
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	void insertEmp(Emp emp) throws ClassNotFoundException ,SQLException;
	
}
