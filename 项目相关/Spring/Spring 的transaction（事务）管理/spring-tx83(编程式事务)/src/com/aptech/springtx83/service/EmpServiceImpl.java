package com.aptech.springtx83.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.aptech.springtx83.dao.EmpDao;
import com.aptech.springtx83.model.Emp;

/**
 * 
 * 事物放在业务层
 * 
 * @author Ryan
 *
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {

	private static final Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);
	
	@Autowired
	@Qualifier("empDao")
	private EmpDao empDao;
	
	@Autowired
	private TransactionTemplate template;
	
	/**
	 * 编程式事物
	 */
	@Override
	public void addEmps(final List<Emp> emps) {
		
		template.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(
					TransactionStatus arg0) {
				try {
					
					for (int index = 0;index < emps.size() ; index ++){
						
						if (index > 10) {
							throw new RuntimeException();
						}
						
						empDao.insertEmp(emps.get(index));
						
					}
					
				} catch (ClassNotFoundException e) {
					log.error("新增雇员信息异常：",e);
				} catch (SQLException e) {
					log.error("新增雇员信息异常：",e);
				}
			}
			
		});
		
	}

}
