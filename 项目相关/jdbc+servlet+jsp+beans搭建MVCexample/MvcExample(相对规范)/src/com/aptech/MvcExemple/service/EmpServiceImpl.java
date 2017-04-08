package com.aptech.MvcExemple.service;

import java.sql.ResultSet;

import com.aptech.MvcExemple.dao.EmpDao;
import com.aptech.MvcExemple.dao.EmpDaoImpl;
import com.aptech.MvcExemple.model.Emp;

public class EmpServiceImpl implements EmpService {
	
	private EmpDao empDao = new EmpDaoImpl();

	@Override
	public ResultSet select(Emp emp) {
		ResultSet rs = null;
		String sql = "select * from emp where 1=1";
		
		if(!emp.getEmpno().trim().equals(""))
		{
			sql=sql + " and empno=" + emp.getEmpno();
		}
		
		rs = empDao.select(sql);
		
		return rs;
	}

}
