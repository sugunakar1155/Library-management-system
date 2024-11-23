<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
LibrarianBean lb = (LibrarianBean)session.getAttribute("lbean");
ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("alist");
out.println("Page belongs to Librarian:"+lb.getfName()+"<br>");

if(al.size()==0)
{
	out.println("No books Available");
}
else
{
	Iterator<BookBean> it = al.iterator();
	while(it.hasNext())
	{
		BookBean bb = (BookBean)it.next();
		
	out.println(bb.getBookCode()+"&nbsp&nbsp"+bb.getBookName()+"&nbsp&nbsp"+bb.getAuthorName()+"&nbsp&nbsp"+bb.getPrice()+"&nbsp&nbsp"
	+bb.getQuantity()+"&nbsp&nbsp"+
	
	"<a href = 'editbook?bcode="+ bb.getBookCode()+"'>Edit</a>"+"&nbsp&nbsp"+
	"<a href = 'deletebook?bcode="+bb.getBookCode()+"'>Delete</a><br>");
			
		
		
	}
}
%>
	<a href="logout">Logout</a>
</body>
</html>