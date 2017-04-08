package com.aptech.MvcExemple.dao;

import java.io.IOException;
import java.sql.*;

public class EmpDaoImpl implements EmpDao {

	@Override
	public ResultSet select(String sql) {
		ResultSet rs = null;
		
		String className = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracl:thin:@localhost:1521:ORCL";
		String account = "scott";
		String password = "yang";
		
		try
		{
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,account,password);
			PreparedStatement ps = con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	
}


