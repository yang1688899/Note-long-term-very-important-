package com.yang.springtx.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.yang.springtx.dao.EmpDao;
import com.yang.springtx.model.Emp;

/**
 * 业务实现类
 * 
 * 此处作为annotation配置声明事务的目标类
 * @author Administrator
 *
 */
@Component("empService2")
public class EmpServiceImpl2 implements EmpService {
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	TransactionTemplate transactionTemplate;

	@Override
	
	/**
	 * @Transactional annotation的propagation为必须配置，值一般配为Propagation.REQUIRED
	 * 其他的为可选，一般使用过程中不需要配
	 * 默认情况下遇到一切异常都回滚
	 * 以下配置PessimisticLockingFailureException不回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED,
					isolation=Isolation.READ_COMMITTED,
					noRollbackFor = { PessimisticLockingFailureException.class }, 
					rollbackFor = { NullPointerException.class })
	public void addEmp(List<Emp> emps) throws SQLException {
		
		for (int index=0; index<emps.size(); index++){
			Emp emp = emps.get(index);
			
			empDao.insertEmp(emp);
			
			if(index>11){
				throw new SQLException();
			}
		}
	}
}