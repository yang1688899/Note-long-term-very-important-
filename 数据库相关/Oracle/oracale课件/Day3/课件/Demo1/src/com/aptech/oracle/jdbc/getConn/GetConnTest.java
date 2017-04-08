package com.aptech.oracle.jdbc.getConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Assert;

public class GetConnTest {

	@org.junit.Test
	public void getConn1() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL?user=scott&password=tiger");
			Assert.assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void getConn2() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props = new Properties();
			props.put("user", "scott");
			props.put("password", "tiger");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", props);
			Assert.assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void getConn3() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			Assert.assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
