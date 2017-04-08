package com.yang.proxypracticejdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.yang.proxypracticejdk.service.ServiceSimulator;

public class PerformaceHandler implements InvocationHandler {
	
	/**
	 * 动态代理handler最好定义代理目标属性target，以便调用代理目标的方法
	 */
	private Object target;
	
	/**
	 * 动态代理handler应定义参数构造以便传入代理目标属性target
	 * @param target 目标对象
	 */
	public PerformaceHandler(ServiceSimulator target){
		this.target = target;
	}
	
	/**
	 * 
	 * （1）横切特性的代码：PerformanceCheck
	 * 
	 * （2）目标对象：ServiceServiceSimulatorImpl
	 * 
	 * （3）连接点：select(),delete()
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		/**
		 * 调用代理的目标对象方法前调用
		 */
		PerformanceCheck check = new PerformanceCheck();
		
		check.before();
		
		/**
		 * 调用代理的目标对象方法
		 */
		Object result = method.invoke(target, args);
		
		/**
		 * 调用代理的目标对象方法后调用
		 */
		check.after();
		
		check.conclusion();
		
		/**
		 * 返回调用代理的目标对象方法后得出的返回对象
		 */
		return result;
	}

}
