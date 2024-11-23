package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteLibrarianServlet  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
	{
		 HttpSession hs = req.getSession(false);
		 if(hs==null)
		 {
			 req.setAttribute("msg", "Session Expired");
			 req.getRequestDispatcher("Msg.jsp").forward(req, res);
		 }
		 else
		 {
			 @SuppressWarnings("unchecked")
			ArrayList<LibrarianBean> al = (ArrayList<LibrarianBean>)hs.getAttribute("alist");
			 Long lPhno=Long.parseLong(req.getParameter("lphno"));
			 Iterator<LibrarianBean>it = al.iterator();
			 while(it.hasNext())
			 {
				 LibrarianBean lb = (LibrarianBean)it.next();
				 if(lPhno.equals(lb.getPhno()));
				 lb.setPhno(lPhno);
				 int k = new DeleteLibrarianDAO().delete(lb);
					if(k>0)
					{
						req.setAttribute("msg", "Librarian Deleted Successfully...<br>");
						
						req.getRequestDispatcher("DeleteLibrarian.jsp").forward(req, res);
					}//end of if
					break;
				}//end of while
				
			}//end of else
			 }

		 
	}


