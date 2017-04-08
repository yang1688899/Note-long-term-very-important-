<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Receive Result</title>
</head>
<body>
	<s:debug/>
	
	<!-- 使用Struts标签从stack value(值栈)中取值 -->
	Stack value:<br/>
	<s:property value="user.id"/><br>
	<s:property value="user.name"/><br/>
	<s:property value="user.age"/><br/>
	<br/><br/>
	
	<!-- 使用Struts标签从request中取值 -->
	request:<br/>
	<s:property value="#request.user.id"/><br/>
	<s:property value="#request.user.name"/><br/>
	<s:property value="#request.user.age"/><br/>
	<br/><br/>
	
	<!-- 使用Struts标签从session中取值 -->
	session:<br/>
	<s:property value="#session.user.id"/><br/>
	<s:property value = "#session.user.name"/><br/>
	<s:property value="#session.user.age"/><br/>
	<br/><br/>
	
	<!-- 使用Struts标签从application中取值 -->
	application:<br/>
	<s:property value="#session.user.id"/><br/>
	<s:property value="#session.user.name"/><br/>
	<s:property value="#session.user.age"/><br/>
	<br/><br/>
	
	
	<!-- 使用struts标签获取传入的Map的key和value -->
	This is the key and value of a Map:<br/>
	<s:iterator value="#session.map">
		<s:property value="key"/>:
		<s:property value="value"/>
		<br/>
	</s:iterator>
	<br/><br/>
	
	
	<!-- 使用struts标签获取传入的Set和List的values 
		status的使用没有列出，如有需要可自行查找-->
	This is the values of a list:<br/>
	<s:iterator value="#session.list" id="e" status="elementStatus">
		<s:property value="e"/><br/>
	</s:iterator>

	
</body>
</html>