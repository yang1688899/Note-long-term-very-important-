<%@ page language="java" import="java.util.*,java.sql.*,Common.Values,Model.UserData" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'IdentifyResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  	<%
  	UserData ud = new UserData();
  	
  	try
    {
    ud.buildConnection();
    }
    catch(SQLException e)
    {
  	 %>
  	 
  	 <h1>
  	 		<font color="#FF0000">Cannot connect to the DataBase!</font>
  	 </h1>
  	 
  	 <%
  	 }
  	  %>
  	  
  	  
    <%
    ResultSet rs = (ResultSet) session.getAttribute(Values.rs);
    
    if(rs==null || !rs.next())
    {
     %>
     
     <div align="center">
     <font color="#FF0000" size="+3" >The userName or the password is wrong!</font>
     </div>
     
     <%
     }
     else
     {
	    int id = rs.getInt("id");
	    String userName = rs.getString("userName");
	    int age = rs.getInt("age");
	    int height = rs.getInt("height");
	    int weight = rs.getInt("weight");
      %>
      
      <h1 align="center">
      	Welcome, <%=userName %>!
      </h1>
      <h2>
      The data of your acount is:
      </h2>
      <table width="960" align="center">
      	<tr>
      		<td width="192" align="center">
      		id
      		</td>
      		<td width="192" align="center">
      		userName
      		</td>
      		<td width="192" align="center">
      		age
      		</td>
      		<td width="192" align="center">
      		height
      		</td>
      		<td width="192" align="center">
      		weight
      		</td>
      	</tr>
      	
      	<tr>
      		<td width="192" align="center">
      		<%=id %>
      		</td>
      		<td width="192" align="center">
      		<%=userName %>
      		</td>
      		<td width="192" align="center">
      		<%=age %>
      		</td>
      		<td width="192" align="center">
      		<%=height %>
      		</td>
      		<td width="192" align="center">
      		<%=weight %>
      		</td>
      	</tr>
      </table>
      
      <%
      }
       %>
      
  </body>
</html>
