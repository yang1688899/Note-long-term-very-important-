package com.yang.strutsencrypt.service;

import com.yang.strutsencrypt.dao.UserDataDao;
import com.yang.strutsencrypt.dao.UserDataDaoImpl;
import com.yang.strutsencrypt.model.UserData;

public class UserDataServiceImpl implements UserDataService {
	
	private UserDataDao userDataDao=new UserDataDaoImpl();

	@Override
	public void insert(UserData user) {
		
		userDataDao.insert(user);
		
	}

}
