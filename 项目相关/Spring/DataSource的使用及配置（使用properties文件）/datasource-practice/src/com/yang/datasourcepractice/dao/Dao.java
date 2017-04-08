package com.yang.datasourcepractice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Dao {
	
	public ResultSet selectAll(String sql) throws SQLException;
}
