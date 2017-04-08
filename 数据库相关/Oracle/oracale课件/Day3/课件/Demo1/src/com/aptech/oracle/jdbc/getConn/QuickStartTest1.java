package com.aptech.oracle.jdbc.getConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class QuickStartTest1 {
	
	@Test
	public void regularWhole() throws Exception {// 抛出异常
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.获取数据库连接
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			// 3.创建执行句柄
			stmt = conn.createStatement();
			// 4.执行sql语句
			String Id = "1 or 1=1";
			rs = stmt.executeQuery("select * from t_user WHERE ID = " + Id);
			// 5.处理执行结果
			while (rs.next()) {
				System.out.println("id:" + rs.getInt(1) + "\tname:"
						+ rs.getString(2) + "\tbirthday:" + rs.getDate(3)
						+ "\tmoney:" + rs.getFloat(4));
			}
		} finally {
			try {
				// 6.释放资源
				if (null != rs) {
					rs.close();
				}
				if (null != stmt) {
					stmt.close();
				}
				if (null != conn) {
					conn.close();
				}
			} finally {
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
	}
}
