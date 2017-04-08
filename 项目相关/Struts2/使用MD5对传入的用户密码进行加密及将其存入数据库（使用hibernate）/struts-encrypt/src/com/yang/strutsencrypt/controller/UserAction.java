package com.yang.strutsencrypt.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.strutsencrypt.model.UserData;
import com.yang.strutsencrypt.service.UserDataService;
import com.yang.strutsencrypt.service.UserDataServiceImpl;

public class UserAction extends ActionSupport {
	
	private UserDataService userDataService = new UserDataServiceImpl();
	
	private UserData user;

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}
	
	
	
	public String login(){
		
		System.out.println(user.getEncryptPassword());
		
		return SUCCESS;
		
	}
	
	public String toHome(){
		
		return SUCCESS;
	}
	
	public String register(){
		
		System.out.println(user.toString());
		
		userDataService.insert(user);
		
		return SUCCESS;
	}

}
