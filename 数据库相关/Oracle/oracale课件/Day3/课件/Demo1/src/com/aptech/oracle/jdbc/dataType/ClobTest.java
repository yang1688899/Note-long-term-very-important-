package com.aptech.oracle.jdbc.dataType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class ClobTest {

	@Test
	public void insertText() throws SQLException, FileNotFoundException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			String sql = "insert into clob_test(id,info) values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 31);
			File file = new File(
					"D:/bk/20150905/jdbcdemo/Demo1/src/com/aptech/oracle/jdbc/dataType/ClobTest.java");
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			stmt.setCharacterStream(2, buffer, 3);
			stmt.execute();
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}
	
	@Test
	public void queryText() throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			String sql = "select info from  clob_test where id=31";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				Reader r=rs.getCharacterStream(1);
				BufferedReader buffer = new BufferedReader(r);
				String temp = "";
				File f = new File("d:\\reader1.txt");
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				while((temp=buffer.readLine())!=null){
					System.out.println(temp);
					bw.write(temp+"\n");
					bw.flush();
				}
				bw.close();
				fw.close();
				buffer.close();
			}
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}
}