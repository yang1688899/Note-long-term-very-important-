package com.yang.datasourcepractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements Dao {
	
	@Autowired
	DataSource dataSource;

	@Override
	public ResultSet selectAll(String sql) throws SQLException {
		
		Connection con = dataSource.getConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ps.close();
		
		con.close();
		
		return rs;	
		
		
	}

}
