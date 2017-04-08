package com.aptech.springioc83.reflect;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试使用JUNIT和Logback
 * 
 * @author Ryan
 *
 */
public class JunitTests {
	
	/**
	 * Logback日志输出级别分为四类：
	 * 1、info（一般信息）
	 * 2、error（错误信息）
	 * 3、warn （警告信息）
	 * 4、debug（测试环境使用）
	 */
	private static final Logger logger = LoggerFactory.getLogger(JunitTests.class);
	
	@Test
	public void testJunt(){
		
		try {
			
			logger.info("开始执行testJunt方法。");
			
			int i = 1/0;
			
		} catch (Exception e) {
			logger.error("执行testJunt发生了异常，异常信息 = ", e);
		}
		
	}
	
}
