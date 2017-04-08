package com.aptech.oracle.jdbc.daoexample;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.aptech.oracle.jdbc.daoexample.dao.UserDao;
import com.aptech.oracle.jdbc.daoexample.dao.UserDaoImpl;
import com.aptech.oracle.jdbc.daoexample.model.User;
import com.aptech.oracle.jdbc.getConn.ConnCreate;

public class UserDaoTest {
	/*@Test
	public void addUser() {
		Connection conn = ConnCreate.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
		UserDao dao = new UserDaoImpl(conn);
		User user = new User();
		user.setId(7);
		user.setName("liudehua");
		user.setBirthday(new Date(System.currentTimeMillis()));
		user.setMoney(456456);
		int result = dao.addUser(user);
		System.out.println("信息录入" + (result > 0 ? "成功!" : "失败!"));
	}*/
	
	@Test
	public void selectAllUser() {
		Connection conn = ConnCreate.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
		UserDao dao = new UserDaoImpl(conn);
		List<User> listUser = dao.queryUserForList("liudehua");
		for (int i=0;i<listUser.size();i++){
			User user = listUser.get(i); 
			System.out.println(user.getId()+":"+user.getMoney());	
		}
	}

}
