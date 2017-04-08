package com.yang.hibernateexample.dao;

import org.junit.Test;

import com.yang.hibernateexample.model.Emp;

public class EmpDaoTest {
	
	private EmpDao empDao=new EmpDaoImpl();
	
	@Test
	public void testInsert(){
		
		Emp emp = new Emp();
		emp.setEmpno(888);
		emp.setEname("yang");
		
		empDao.insert(emp);
	}
	
	

}
