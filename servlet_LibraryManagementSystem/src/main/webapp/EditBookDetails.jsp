<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
LibrarianBean lb =(LibrarianBean)session.getAttribute("lbean");
out.println("page belongs to Librarian:"+lb.getfName()+"<br>");
BookBean bb = (BookBean)request.getAttribute("bbean");
%>
<form action ="updatebook" method="post">
<input type="hidden" name="bcode" value=<%=bb.getBookCode() %>>
BookName:<input type="text" name="name" value=<%=bb.getBookName() %>><br>
AuthorName:<input type="text" name="aname" value=<%=bb.getAuthorName() %>><br>
Price:<input type="number" name="price" value=<%=bb.getPrice() %>><br>
Quantity:<input type="number" name="quantity" value=<%=bb.getQuantity() %>><br>
<input type="submit" value ="UpdateBookDetails">;
</form>
</body>
</html>