package com.yang.proxypracticejdk.proxy;

import java.lang.reflect.Proxy;

import com.yang.proxypracticejdk.service.ServiceSimulator;
import com.yang.proxypracticejdk.service.ServiceSimulatorImpl;

public class ProxyTest {
	
	public static void main(String[] args){
		
		/**
		 * 构造代理的目标对象
		 */
		ServiceSimulator target = new ServiceSimulatorImpl();
		
		/**
		 * 构造代理的handler
		 */
		PerformaceHandler handler = new PerformaceHandler(target);
		
		/**
		 * 调用Proxy的newProxyInstance静态方法把目标对象和handler绑定起来
		 * 
		 * 该方法构造了一个表面上与目标对象相同类的对象，实质上构造的是一个包含目标对象的代理对象(可通过debug观察)
		 * 
		 */
		ServiceSimulator proxy = 
				(ServiceSimulator) Proxy.newProxyInstance(
						target.getClass().getClassLoader(),
						target.getClass().getInterfaces(),
						handler);
		
		/**
		 * 通过代理对象调用方法
		 */
		proxy.select();
		
		proxy.delete();
	}

}
