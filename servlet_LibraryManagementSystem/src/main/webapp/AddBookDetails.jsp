<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
LibrarianBean librarian = (LibrarianBean)session.getAttribute("lbean");
	  String msg = (String)request.getAttribute("msg");
out.print("Welcome librarian"+librarian.getfName()+"<br>");

   out.println(msg);
%>
	<a href="BookDetails.html">AddBookDetails</a>
	<a href="viewbooks">ViewAllBookDetails</a>
	<a href="logout">Logout</a>
</body>
</html>