package com.yang.proxypracticecglib.proxy;

import com.yang.proxypracticecglib.service.ServiceSimulator;
import com.yang.proxypracticecglib.service.ServiceSimulatorImpl;

public class ProxyTest {
	public static void main(String[] args){
		
		/**
		 * 构造代理的handler
		 */
		PerformaceHandler handler = new PerformaceHandler();
		
		/**
		 * 调用代理的handler中的动态创建子类实例的方法
		 */
		ServiceSimulator proxy = (ServiceSimulator) handler.getProxy(ServiceSimulatorImpl.class);
		
		/**
		 * 通过代理对象调用方法
		 */
		proxy.select();
		
		proxy.delete();
	}
}
