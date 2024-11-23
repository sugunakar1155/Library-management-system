<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
nav{
		display: flex;
		padding: 30px;
		background-color: darkblue;
		color: white;
	}
	nav a{
		color: white;
		text-decoration: none;
		margin-left: 20px;
	}
</style>
<body>
	<% 
AdminBean admin =(AdminBean)session.getAttribute("abean");
String msg =(String)request.getAttribute("msg");
out.print("page belongs to"+admin.getfName()+"<br>");
out.println(msg);
%>
<nav>

	<a href="librarian.html">AddLibrarian</a>
	<a href="view">ViewAllLibrarians</a>
	<a href="logout">Logout</a>
	</nav>
</body>
</html>