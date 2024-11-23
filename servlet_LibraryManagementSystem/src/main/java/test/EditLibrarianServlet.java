package test;
import java.io.*;


import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditLibrarianServlet extends HttpServlet{
	
	@Override
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);//Accessing Existing object
		if(hs==null)
		{
			req.setAttribute("msg", "SessionExpired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			Long lPhno = Long.parseLong(req.getParameter("lphno")); 
			@SuppressWarnings("unchecked")
			ArrayList<LibrarianBean>al = (ArrayList<LibrarianBean>)hs.getAttribute("alist");
			Iterator<LibrarianBean>it = al.iterator();
			while(it.hasNext())
			{
				LibrarianBean lb =(LibrarianBean)it.next();
				if(lPhno.equals(lb.getPhno()))
				{
					
					req.setAttribute("lbean", lb);
					req.getRequestDispatcher("EditLibrarian.jsp").forward(req, res);
					
					break;
				}
			}//end of loop
			
		}
	}

}
