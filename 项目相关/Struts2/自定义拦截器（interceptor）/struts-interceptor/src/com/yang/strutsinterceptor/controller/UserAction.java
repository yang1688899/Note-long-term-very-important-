package com.yang.strutsinterceptor.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yang.strutsinterceptor.model.User;


public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String login(){
		
		return SUCCESS;
	}

}
