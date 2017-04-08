<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="EmpServlet">
	<table width="800" align="center">
		<tr>
			<td width="400" align="right">
			Empnno:
			</td>
			<td width="400">
				<input type="text" name="empno">
			</td>
		</tr>
	</table>
	<div align = "center">
		<input type="submit" value="Search">
	</div>
	</form>
</body>
</html>