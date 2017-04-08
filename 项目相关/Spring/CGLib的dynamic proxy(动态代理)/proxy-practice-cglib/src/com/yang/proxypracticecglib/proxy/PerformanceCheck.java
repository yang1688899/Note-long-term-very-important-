package com.yang.proxypracticecglib.proxy;

/**
 * 性能检测
 * 用于代理的具有横切逻辑的代码
 * @author Administrator
 *
 */
public class PerformanceCheck {
	
	private long start;
	
	private long end;
	
	/**
	 * 应在被检测程序前执行
	 * 用于获取程序执行的开始时间
	 */
	public void before(){
		
		start = System.currentTimeMillis();
	}
	
	/**
	 * 应在被检测程序后执行
	 * 用于获取程序执行的结束时间
	 */
	public void after(){
		
		end = System.currentTimeMillis();
	
	}
	
	/**
	 * 根据before(),after()情况，得出结论
	 */
	public void conclusion(){
		
		long duration = end - start;
		
		System.out.println("The method cost: " + duration + " millisecond");
	}
}
