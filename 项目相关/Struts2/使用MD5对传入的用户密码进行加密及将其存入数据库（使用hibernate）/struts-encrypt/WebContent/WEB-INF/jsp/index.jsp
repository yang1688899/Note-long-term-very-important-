<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form action="user/login">
		name:<input type="text" name="user.name"/><br/><br/>
		
		password:<input type="password" name="user.password"><br/><br/>
		
		<div align="center"><input type="submit" value="提交"></div>
		
	</form><br/><br/>
		<div align="center"><a href="register.jsp">注册</a></div>
	</div>
</body>
</html>