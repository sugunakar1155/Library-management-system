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
AdminBean ab =(AdminBean)session.getAttribute("abean");
out.println("Page belongs to Admin:"+ab.getfName()+"<br>");
LibrarianBean lb =(LibrarianBean)request.getAttribute("lbean");
System.out.println(lb);
%>
	<form action="update" method="post">
		<input type="hidden" name="lphno" value=<%=lb.getPhno() %>>
		First Name:<input type="text" name="fname" value=<%=lb.getfName() %>><br>
		Last Name:<input type="text" name="lname" value=<%=lb.getlName() %>><br>
		Address:<input type="text" name="addr" value=<%=lb.getAddr() %>><br>
		<input type="submit" value="UpdateLibrarian">
	</form>
</body>
</html>