package com.aptech.oracle.jdbc.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class StatementTest {

	@Test
	public void insert() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "insert into t_user(id,name,birthday,money) values(3,'lisi',to_date('2010-05-05','YYYY-MM-DD'),13000.00)";
			stmt.executeUpdate(sql);
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}

	@Test
	public void update() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "update t_user set money=money+5000 where id=3";

			stmt.executeUpdate(sql);
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}

	@Test
	public void delete() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "delete from t_user where id=3";

			stmt.executeUpdate(sql);
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}

	/**
	 * Statement弊端演示
	 * 简单的SQL注入攻击演示
	 * @throws SQLException
	 */
	@Test
	public void conditionQuery() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "select * from t_user where name='wangwenjun' or 1=1";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("id:" + rs.getInt(1) + "\tname:"
						+ rs.getString(2) + "\tbirthday:" + rs.getDate(3)
						+ "\tmoney:" + rs.getFloat(4));
			}
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}
}
