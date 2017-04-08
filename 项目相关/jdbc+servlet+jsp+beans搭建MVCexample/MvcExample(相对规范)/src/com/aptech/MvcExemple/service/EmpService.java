package com.aptech.MvcExemple.service;

import java.sql.ResultSet;

import com.aptech.MvcExemple.model.Emp;

public interface EmpService {
	public ResultSet select(Emp emp);

}
