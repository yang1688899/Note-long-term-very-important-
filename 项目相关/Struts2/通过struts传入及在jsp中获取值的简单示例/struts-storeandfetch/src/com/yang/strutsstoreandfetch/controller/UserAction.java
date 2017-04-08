package com.yang.strutsstoreandfetch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yang.strutsstoreandfetch.model.User;
import com.yang.strutsstoreandfetch.property.Common;

/**
 * Action基类
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport{
	
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String select(){
		
		
		
		//获取request及向request传入值
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(Common.USER, user);
		
		//获取session及向session传入值
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put(Common.USER, user);
		
		//获取application及向application传入值
		Map<String,Object> application = ActionContext.getContext().getApplication();
		application.put(Common.USER, user);
		
		return SUCCESS;
	}
	
	public String storeMap(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("height", 172);
		map.put("weight", 50);
		
		//向session传入一个Map
		ActionContext.getContext().getSession().put(Common.MAP, map);
		
		return SUCCESS;
		
	}
	
	public String storeList(){
		
		List<String> list = new ArrayList();
		for(int i=0; i<5; i++){
			list.add("yang"+i);
		}
		
		//向session传入一个List
		ActionContext.getContext().getSession().put(Common.LIST,list);
		
		return SUCCESS;
	}

}
