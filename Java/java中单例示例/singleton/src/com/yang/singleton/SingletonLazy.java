package com.yang.singleton;

/**
 * 懒汉式单例示例
 * @author Administrator
 *
 */
public class SingletonLazy {
	
	/**
	 * 指向唯一单例的静态属性
	 */
	private static SingletonLazy singleton;
	
	/**
	 * 私有化构造
	 */
	private SingletonLazy(){
		
	}
	
	/**
	 * 获得单例的方法
	 * @return SingletonLazy的单例
	 */
	public synchronized static SingletonLazy getInstance(){
		
		if(singleton == null){
			singleton = new SingletonLazy();
		}
		
		return singleton;
	}

}
