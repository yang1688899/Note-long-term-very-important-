package com.aptech.springtx83.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aptech.springtx83.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"}) 
public class EmpServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpServiceTest.class);
	
	@Autowired
	@Qualifier("empService")
	private EmpService empService;
	
	@Test
	public void testAddEmps() {
		
		List<Emp> emps = new ArrayList<Emp>();
		
		for (int index = 1;index <= 1000;index ++) {
			Emp emp = new Emp();
			emp.setEmpno(index);
			emps.add(emp);
		}
		
		empService.addEmps(emps);
		
	}
}
