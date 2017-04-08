<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
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
  	<h2>Please enter the userData:</h2>
  	
  	<form method="post" action="servlet/Register">
    <table width="960" align="center">
    	<tr>
    		<td width="240" align="right">
    		userName:
    		</td>
    		<td width="240">
    		<input type="text" name="userName"/>
    		</td>
    		<td width="240" align="right">
    		age:
    		</td>
    		<td width="240">
    		<input type="text" name="age"/>
    		</td>
    	</tr>
    	<tr>
    		<td width="240" align="right">
    		password:
    		</td>
    		<td width="240">
    		<input type="password" name="password1"/>
    		</td>
    		<td width="240" align="right">
    		confirm your password:
    		</td>
    		<td width="240">
    		<input type="password" name="password2"/>
    		</td>
    	</tr>
    	<tr>
    		<td width="240" align="right">
    		height:
    		</td>
    		<td width="240">
    		<input type="text" name="height"/>
    		</td>
    		<td width="240" align="right">
    		weight:
    		</td>
    		<td width="240">
    		<input type="text" name="weight"/>
    		</td>
    	</tr>
    	<tr>
    		<td width="240" align="right">
    		id:
    		</td>
    		<td width="240">
    		<input type="text" name="id"/>
    		</td>
    		<td width="240" align="right">
    		gender:
    		</td>
    		<td width="240">
    		<input type="radio" name="gender" value="1"/>male
    		<input type="radio" name="gender" value="0"/>female
    		</td>
    	</tr>
    </table>
    
    <br/>
    
    <div align="center">
    	<input type="submit" value="submit"/>
    </div>
    </form>
    
  </body>
</html>
