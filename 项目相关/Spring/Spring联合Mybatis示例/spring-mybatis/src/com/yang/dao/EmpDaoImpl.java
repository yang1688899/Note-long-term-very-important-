package com.yang.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yang.model.Emp;

@Component("empDao")
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	SqlSessionTemplate daoTemplate;

	@Override
	public Emp selectByEmpno(Emp emp) {
		
		emp = daoTemplate.selectOne("com.yang.model.config.selectEmpByEmpno", emp);
		
		return emp;
	}

}
