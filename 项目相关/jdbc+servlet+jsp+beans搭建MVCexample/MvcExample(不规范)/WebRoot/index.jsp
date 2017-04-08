<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
  <form method="post" action="servlet/LogOnIdentify">
    <table width="400" align="center">
    	<tr>
    		<td width="200" align="right">
    			UserName:
    		</td>
    		<td width="200">
    		<input type="text" name="userName"/>
    		</td>
    	</tr>
    	
    	<tr>
    		<td width="200" align="right">
    			Password:
    		</td>
    		<td width="200">
    			<input type="password" name="password"/>
    		</td>	
    	</tr>
    </table>
    <div align="center">
    	<input type="submit"  value="Log on"/>
    </div>
    </form>
    
     <form method="post" action="result/RegisterInput.jsp">
     <div align="center">
    	<input type="submit" value="Log in"/>
    </div>
    </form>
    
  </body>
</html>
