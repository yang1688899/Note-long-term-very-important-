package com.yang.springjdbcpractice.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.springjdbcpractice.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans.xml"})

public class EmpDaoTest {
	
	@Autowired
	EmpDaoImpl empDao;
	
	
	@Test
	public void testEmpDao(){
		
		Emp emp = new Emp();
		emp.setEmpno(500);
		
		
		empDao.insert(emp);
	}
	
	@Test
	public void testEmpDao2(){
		
		Emp emp = new Emp();
		emp.setEmpno(501);
		emp.setEname("yang");
		
		empDao.insert2(emp);
	}
	
	@Test
	public void testEmpDao3(){
		
		Emp emp = new Emp();
		emp.setEmpno(502);
		emp.setEname("yang");
		
		empDao.insert2(emp);
	}
	
	@Test
	public void testBatchInsert(){
		
		ArrayList<Emp> emps = new ArrayList();
		
		for(int i=0; i<5; i++){
			Emp emp =  new Emp();
			emp.setEmpno(100+i);
			emps.add(emp);
		}
		
		empDao.batchInsert(emps);
	}
	
	@Test
	public void testInsertWithSq(){
		
		ArrayList<Emp> emps = new ArrayList();
		
		for(int i=0; i<5; i++){
			Emp emp =  new Emp();
			emp.setEname("yang"+i);
			emps.add(emp);
		}
		
		empDao.insertWithSq(emps);
	}
	
}
