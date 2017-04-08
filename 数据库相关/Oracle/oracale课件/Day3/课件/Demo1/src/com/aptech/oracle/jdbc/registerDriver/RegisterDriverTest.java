package com.aptech.oracle.jdbc.registerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;

public class RegisterDriverTest {

	@org.junit.Test
	public void registDriver1() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			Assert.assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@org.junit.Test
	public void registDriver2() {
		try {
			System.setProperty("jdbc.drivers", "oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			Assert.assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@org.junit.Test
	public void registDriver3() {
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
