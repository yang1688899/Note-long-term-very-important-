package com.aptech.oracle.jdbc.dataType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;

import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class TimestampTest {

	@Test
	public void compareDate(){
		java.util.Date date1 = new java.util.Date();
		System.out.println(date1);
		System.out.println("=====================");
		java.sql.Date date2 = new java.sql.Date(0);
		System.out.println(date2);
	}
	
	@Test
	public void insertTimeStamp() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			String sql = "insert into t_user(id,name,birthday,money) values(51,'zhaowu',?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			stmt.setDouble(2, 13000.00);
			stmt.execute();
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}
}
