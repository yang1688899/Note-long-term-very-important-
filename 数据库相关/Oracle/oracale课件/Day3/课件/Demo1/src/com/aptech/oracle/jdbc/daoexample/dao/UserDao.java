package com.aptech.oracle.jdbc.daoexample.dao;

import java.util.List;

import com.aptech.oracle.jdbc.daoexample.model.User;

public interface UserDao {
	
	/**
	 * 增加一个用户
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user);

	/**
	 * 删除一个用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int deleteUser(User user);

	/**
	 * 查询用户信息通过id编号
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id);

	/**
	 * 查询用户列表通过用户名
	 * 
	 * @param name
	 * @return
	 */
	public List<User> queryUserForList(String name);

	/**
	 * 更新用户信息,根据id编号来更新
	 * 
	 * @param newInfo
	 * @param id
	 * @return
	 */
	public int updateUser(User newInfo, int id);
}
