package com.yang.strutsinterceptor.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginCheck extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String username = request.getParameter("user.username");
		String password = request.getParameter("user.password");
		
		System.out.println(username);
		System.out.println(password);
		
		/**
		 * 如username为"yang"且password为"5354"，则继续执行action所调用方法
		 */
		if( username.equals("yang") && password.equals("5354")){
			
			session.put("username", username);
			
			session.put("password", password);
			
			//执行该代码后，将继续执行action所调用方法
			return invocation.invoke();
		}
		else{
			return "input";
		}
	}

}
