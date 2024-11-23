<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="test.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Librarian Information</title>
</head>
<body>
    
    <% AdminBean ab = (AdminBean) session.getAttribute("abean");
       ArrayList<LibrarianBean> al = (ArrayList<LibrarianBean>) session.getAttribute("alist");
    %>
    
    
    <p>Page belongs to Admin: <%= ab.getfName() %> </p>
    
    <%-- Check if there are librarians available --%>
    <% if (al == null || al.isEmpty()) { %>
        <p>No Librarians available...</p>
    <% } else {
    	
    	%>
        <table border="1" style="width:60%;">
            <thead>
                <tr>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Action</th>
                     <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%-- Iterate through the list of librarians --%>
                <% for (LibrarianBean lb : al) { %>
                    <tr>
                    
                        <td align="center"><%= lb.getuName() %></td>
                        <td align="center"><%= lb.getpWord() %></td>
                        <td align="center"><%= lb.getfName() %></td>
                        <td align="center"><%= lb.getlName() %></td>
                        <td align="center"><%= lb.getAddr() %></td>
                        <td align="center"><%= lb.getMid() %></td>
                        <td align="center"><%= lb.getPhno() %></td>
                        <td align="center">
                            <a href="edit?lphno=<%= lb.getPhno() %>">Edit</a>

                        </td>
                        <td align="center"><a href="delete?lphno=<%= lb.getPhno() %>">Delete</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>
    
    <a href="logout">Logout</a>
</body>
</html>
