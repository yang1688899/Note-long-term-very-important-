package com.aptech.oracle.jdbc.getConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnCreate {

	/**
	 * 静态加载
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * @param url
	 * @param user
	 * @param pwd
	 * @return
	 */
	public static Connection getConnection(String url, String user, String pwd) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws SQLException
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs)
			throws SQLException {

		if (null != rs) {
			rs.close();
		}
		if (null != stmt) {
			stmt.close();
		}
		if (null != conn) {
			conn.close();
		}
	}
}
