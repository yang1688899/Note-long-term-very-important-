package com.yang.proxypracticecglib.service;


/**
 * 业务模拟实现类，用于作为添加动态代理的target
 * @author Administrator
 *
 */
public class ServiceSimulatorImpl implements ServiceSimulator {
	
	/**
	 * 模拟select方法
	 */
	@Override
	public void select() {
		
		try {
			System.out.println("Simulating select......");
			Thread.currentThread().sleep(500);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 模拟delete方法
	 */
	@Override
	public void delete() {
		
		try {
			
			System.out.println("Simulating delete......");
			Thread.currentThread().sleep(300);
			
		} catch (InterruptedException e) {
			
			
			e.printStackTrace();
		}

	}

}
