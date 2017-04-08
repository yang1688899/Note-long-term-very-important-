package com.yang.springtx.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.springtx.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/beans.xml")
public class TestEmpService {
	
	@Autowired
	private EmpService transactonEmpService;
	
	/**
	 * 尝试批量插入数据，由于出现异常(参考EmpServiceImpl类)，回滚，
	 * 最终没有向数据库插入任何数据
	 */
	@Test
	public void testAddEmp(){
		
		List<Emp> emps = new ArrayList<Emp>();
		
		for (int index = 1;index <= 1000;index ++) {
			Emp emp = new Emp();
			emp.setEname("yang"+index);
			emps.add(emp);
		}
		
		try {
			transactonEmpService.addEmp(emps);
			
			System.out.println(emps.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
