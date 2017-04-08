package com.yang.singleton;

/**
 * 饿汉式单例示例，在类初始化时，单例已实例化
 * @author Administrator
 *
 */
public class SingletonHungry {
	
	/**
	 * 指向单例的静态常量，类加载时初始化
	 */
	private static final SingletonHungry singleton = new SingletonHungry();
	
	/**
	 * 私有化构造
	 */
	private SingletonHungry(){
		
	}
	
	/**
	 * 获取单例方法
	 * @return SingletonHungry的单例
	 */
	public static SingletonHungry getInstance(){
		
		return singleton;
	}

}
