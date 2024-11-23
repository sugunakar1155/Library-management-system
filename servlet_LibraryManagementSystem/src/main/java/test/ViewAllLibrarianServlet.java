package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllLibrarianServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		HttpSession hs = req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		
		}
		else
		{
			ArrayList<LibrarianBean>al = new ViewAllLibrariansDAO().retrieve();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllLibrarians.jsp").forward(req, res);
		}
	}

}
