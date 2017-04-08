package com.yang.springtx.model;

import java.sql.Date;

public class Emp {
	
	// 雇员编号 -- 主键
	private Integer empno;
	
	// 雇员名称
	private String ename;
	
	// 雇员工资
	private Double sal;
	
	// 雇员奖金
	private Double comm;
	
	// 雇佣日期
	private Date hireDate;
	
	// 上司
	private Integer mgr;
	
	// 职位
	private String job;
	
	// 部门编号--外键
	private Integer deptno;

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

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal
				+ ", comm=" + comm + ", hireDate=" + hireDate + ", mgr=" + mgr
				+ ", job=" + job + ", deptno=" + deptno + "]";
	}
	
}
