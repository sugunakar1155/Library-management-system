package test;
import java.io.*;
import jakarta.servlet.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")
@WebServlet("/librarian")
public class LibrarianLoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		
		LibrarianBean lb=new LibrarianLoginDAO().login(uName,pWord);
		
		if(lb==null)
		{
			req.setAttribute("msg","Invalid Login Proces...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);;
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("lbean", lb);
			req.getRequestDispatcher("LibrarianLogin.jsp").forward(req, res);
		}
	}

}
