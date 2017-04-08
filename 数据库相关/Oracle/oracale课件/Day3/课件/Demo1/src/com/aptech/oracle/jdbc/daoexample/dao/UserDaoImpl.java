package com.aptech.oracle.jdbc.daoexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aptech.oracle.jdbc.daoexample.model.User;
import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class UserDaoImpl implements UserDao {

	private Connection conn = null;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public int addUser(User user) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "insert into t_user(id,name,birthday,money) values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setDate(3, user.getBirthday());
			stmt.setFloat(4, user.getMoney());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnCreate.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteUser(User user) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "delete from   t_user where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnCreate.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User queryUserById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from t_user where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getDate(3));
				user.setMoney(rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnCreate.close(null, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public List<User> queryUserForList(String name) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		List<User> lists = new ArrayList<User>();
		try {
			String sql = "select * from t_user where name=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getDate(3));
				user.setMoney(rs.getFloat(4));
				lists.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnCreate.close(null, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}

	public int updateUser(User newInfo, int id) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "update t_user set money=? where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newInfo.getName());
			stmt.setInt(2, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnCreate.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
