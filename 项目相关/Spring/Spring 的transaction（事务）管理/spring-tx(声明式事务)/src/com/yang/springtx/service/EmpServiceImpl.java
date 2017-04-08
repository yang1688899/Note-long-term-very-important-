package com.yang.springtx.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.yang.springtx.dao.EmpDao;
import com.yang.springtx.model.Emp;
/**
 * 业务实现类
 * 
 * 此处作为xml配置声明事务的目标类
 * @author Administrator
 *
 */
@Component("empService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	TransactionTemplate transactionTemplate;

	@Override
	public void addEmp(List<Emp> emps) throws SQLException {
		
		for (int index=0; index<emps.size(); index++){
			Emp emp = emps.get(index);
			
			empDao.insertEmp(emp);
			
			if(index>11){
				throw new RuntimeException();
			}
		}
	}
}
	
