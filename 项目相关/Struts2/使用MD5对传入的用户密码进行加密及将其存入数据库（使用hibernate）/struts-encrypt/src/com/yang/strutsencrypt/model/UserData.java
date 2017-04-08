package com.yang.strutsencrypt.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserData {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String password;
	
	private String encryptPassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		
		try {
			//获取MD5的实例
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//对明文密码进行加密
			byte[] words = md.digest(password.getBytes());
			String encryptPassword = new String(words);
			
			this.encryptPassword = encryptPassword;
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public String getEncryptPassword() {
		return encryptPassword;
	}

	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password
				+ ", encryptPassword=" + encryptPassword + "]";
	}
	
	
}
	