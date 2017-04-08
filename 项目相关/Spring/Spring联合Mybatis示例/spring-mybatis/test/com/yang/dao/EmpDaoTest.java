package com.yang.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class EmpDaoTest {
	
	@Autowired
	private EmpDao empDao;

	@Test
	public void testSelectByEmpno(){
		
		Emp emp = new Emp();
		emp.setEmpno(7788);
		
		emp = empDao.selectByEmpno(emp);
		
		System.out.println(emp.toString());
	}
}
