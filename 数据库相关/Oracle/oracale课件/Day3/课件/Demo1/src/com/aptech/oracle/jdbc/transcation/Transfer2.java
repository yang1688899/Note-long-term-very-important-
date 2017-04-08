package com.aptech.oracle.jdbc.transcation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class Transfer2 {
	
	@Test
	public void transcation2() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			conn = ConnCreate.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			String sql = "update t_user set money=money-1000 where id=1";
			stmt.execute(sql);
			
			sql = "select money from t_user where id=7";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				float money = rs.getFloat(1);
				if (money > 10000) {
					throw new Exception("钱已到上线，无法在增加");
				}
			}
			
			sql = "update t_user set money=money+1000 where id=7";
			stmt.execute(sql);
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
		conn.commit();
	}
}
