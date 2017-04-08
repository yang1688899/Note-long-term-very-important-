package Model;

import java.sql.*;

import Common.Values;

public class UserData {
	
	private String id;
	private String userName;
	private String password;
	private String age;
	private String height;
	private String weight;
	private String gender;
	
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	
	
	public Connection buildConnection() throws SQLException
	{
		Connection con = DriverManager.getConnection(Values.url + ";" + Values.DataBaseName, Values.DataBaseUserName, Values.DataBasePassword);
		return con;
	}
	
	public ResultSet identify()
	{
		ResultSet rs = null;
		String sql = null;
		
		if (!userName.trim().equals("") && !password.trim().equals(""))
			{
				sql = "select * from userData where userName = '" +userName + "'" + " and password = '" + password + "'";
			}
		else
		{
			return rs;
		}
		
		
		try
		{
			Connection con = buildConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public Boolean register()
	{
		String sql = "insert into userData values(" 
			+id +", "
			+"'" + userName + "', "
			+"'" + password + "', "
			+age + ", "
			+height + ", "
			+weight + ", "
			+gender + ")";
		
		Boolean isSuccess = new Boolean(false);
		
		try
		{
			Connection con = buildConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			isSuccess = new Boolean(ps.execute());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	
}
