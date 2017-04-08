package com.yang.springjdbcpractice.dao;

import java.util.List;

import com.yang.springjdbcpractice.model.Emp;

public interface EmpDao{
	
	void insert(Emp emp);
	
	void insert2(Emp emp);
	
	void insert3(Emp emp);
	
	void batchInsert(List<Emp> emps);

}
