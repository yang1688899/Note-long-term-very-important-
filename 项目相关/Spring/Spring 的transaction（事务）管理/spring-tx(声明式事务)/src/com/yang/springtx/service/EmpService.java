package com.yang.springtx.service;

import java.sql.SQLException;

import java.util.List;

import com.yang.springtx.model.Emp;

public interface EmpService {
	
	void addEmp(List<Emp> emps) throws SQLException;

}
