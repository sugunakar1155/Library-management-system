<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.AdminBean"%>
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
	main img{
	height:"500px";
	width:100%;
	}
	
</style>
<body>
<div class="container">
<nav>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Welcome Admin:"+ab.getfName()+"<br>");
%>
<a href="librarian.html">AddLibrarian</a>
	<a href="view">viewAllLibrarian</a>
	<a href="logout">Logout</a>
</nav>
<main>
<img src="https://static.vecteezy.com/system/resources/previews/026/442/701/large_2x/education-concept-with-laptop-and-books-stack-with-library-background-generative-ai-photo.jpg">
</main>
</div>
	
</body>
</html>