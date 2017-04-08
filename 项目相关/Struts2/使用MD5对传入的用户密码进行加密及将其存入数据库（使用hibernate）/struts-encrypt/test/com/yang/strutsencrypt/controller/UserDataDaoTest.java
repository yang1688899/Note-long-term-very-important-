package com.yang.strutsencrypt.controller;

import org.junit.Test;

import com.yang.strutsencrypt.dao.UserDataDao;
import com.yang.strutsencrypt.dao.UserDataDaoImpl;
import com.yang.strutsencrypt.model.UserData;

public class UserDataDaoTest {
	
	private UserDataDao userDataDao=new UserDataDaoImpl();
	
	@Test
	public void testInsert(){
		UserData user = new UserData();
		
		user.setId(888);
		user.setName("yang");
		user.setAge(23);
		user.setPassword("yang16888");
		
		userDataDao.insert(user);
		
		
	}
}
