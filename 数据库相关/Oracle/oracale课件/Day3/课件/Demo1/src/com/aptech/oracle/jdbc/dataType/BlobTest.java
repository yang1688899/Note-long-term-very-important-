package com.aptech.oracle.jdbc.dataType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class BlobTest {
	@Test
	public void insertBlob() throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			String sql = "insert into blob_test(id,info) values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 30);
			File file = new File(
					"D:/bk/20150905/jdbcdemo/example.jpg");
			FileInputStream fis = new FileInputStream(file);
			stmt.setBinaryStream(2, fis, (int) file.length());
			stmt.execute();
			fis.close();
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}

	@Test
	public void queryBlob() throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnCreate.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			String sql = "select info from  blob_test where id=30";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				InputStream is = rs.getBinaryStream(1);
				File file = new File("d:/a.bmp");
				OutputStream os = new FileOutputStream(file);
				int len = 0;
				byte[] buffers = new byte[1024];
				while ((len = is.read(buffers)) > 0) {
					os.write(buffers, 0, len);
				}
				os.flush();
				os.close();
				is.close();
			}
		} finally {
			ConnCreate.close(conn, stmt, rs);
		}
	}
}
