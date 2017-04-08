<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="user/register" method="post">
		<div align="center">
			id:<input type="text" name="user.id"/><br/><br/>
			name:<input type="text" name="user.name"/><br/><br/>
			password:<input type="password" name="user.password" id="password"/><br/><br/>
			age:<input type="text" name="user.age"/><br/><br/>
			<div><input type="submit" onclick='validicate()' value="submit"></div>
		</div>
	</form>
</body>
</html>