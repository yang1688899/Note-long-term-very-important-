package com.aptech.oracle.jdbc.daoexample.model;

import java.sql.Date;

/**
 * POJO or Java Bean or domain 
 * is data model
 * @author Ryan
 *
 */
public class User {
	private int id;
	private Date birthday;
	private String name;
	private float money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
}
