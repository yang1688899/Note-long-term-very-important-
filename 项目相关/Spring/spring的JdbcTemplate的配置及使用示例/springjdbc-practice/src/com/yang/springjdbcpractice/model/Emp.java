package com.yang.springjdbcpractice.model;

import org.springframework.stereotype.Component;

public class Emp {
	
	private String ename;

	private Integer empno;

	
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
}
