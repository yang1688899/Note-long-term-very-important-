<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.sql.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>empno</td>
			<td>ename</td>
			<td>job</td>
			<td>mgr</td>
			<td>sal</td>
			<td>comm</td>
			<td>deptno</td>
		</tr>
	<%
		ResultSet rs = (ResultSet) session.getAttribute("rs");
	
		while(rs.next())
		{
			String empno = rs.getString("EMPNO");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			String mgr = rs.getString("SAL");
			String sal = rs.getString("SAL");
			String comm = rs.getString("COMM");
			String deptno = rs.getString("DEPTNO");
		
	%>
		<tr>
			<td><%=empno %></td>
			<td><%=ename %></td>
			<td><%=job %></td>
			<td><%=mgr %></td>
			<td><%=sal %></td>
			<td><%=comm %></td>
			<td><%=deptno %></td>
		</tr>
	
	<%} %>
	</table>

</body>
</html>