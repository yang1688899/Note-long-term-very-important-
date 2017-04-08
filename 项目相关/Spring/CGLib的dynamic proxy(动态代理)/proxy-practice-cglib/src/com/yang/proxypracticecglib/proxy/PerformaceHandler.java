package com.yang.proxypracticecglib.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.yang.proxypracticecglib.service.ServiceSimulator;

public class PerformaceHandler implements MethodInterceptor {
	
	
	/**
	 * 基于CGLib的动态代理的handler要有Enhancer对象作为属性目前并不清楚Enhancer是什么
	 * 
	 * 看不到Enhancer源码，貌似与字节码技术相关
	 */
	private Enhancer enhancer = new Enhancer();
	
	
	/**
	 * 基于CGLib的动态代理的handler应该有一个通过字节码技术，动态创建子类实例的方法
	 * 
	 * 通过字节码技术，动态创建子类实例
	 */
	public Object getProxy(Class<?> clazz) {
		/**
		 * 设置需要创建子类的类
		 */
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		
		/**
		 * 创建子类实例
		 */
		return enhancer.create();
	}
	

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		/**
		 * 调用代理的目标对象方法前调用
		 */
		PerformanceCheck check = new PerformanceCheck();
		check.before();
		
		/**
		 * 调用代理的目标对象方法
		 */
		Object result = methodProxy.invokeSuper(obj, args);
		
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
