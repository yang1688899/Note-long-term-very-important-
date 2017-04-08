package com.yang.datasourcepractice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans.xml"})
public class DaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DaoTest.class);
	
	@Autowired
	Dao dao;
	
	@Test
	public void testDao(){
		
		String sql = "select * from emp";
		
		try {
			ResultSet rs = dao.selectAll(sql);
			
			Assert.assertNotNull(rs);
			
			logger.info(rs.toString());
			
			
		} catch (SQLException e) {
			logger.error("Ther is a SQLException occure: ",e); 
		}
	}
	
}
