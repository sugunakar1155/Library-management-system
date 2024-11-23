package test;
import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateLibrarianServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req,res);
		}
		else
		{
			@SuppressWarnings("unchecked")
			ArrayList<LibrarianBean> al =(ArrayList<LibrarianBean>)hs.getAttribute("alist");
			Long lPhno=Long.parseLong(req.getParameter("lphno"));
			String lfName =req.getParameter("fname");
			String llName = req.getParameter("lname");
			String lAddr = req.getParameter("addr");
			Iterator<LibrarianBean>it = al.iterator();
			while(it.hasNext())
			{
				LibrarianBean lb = (LibrarianBean)it.next();
				if(lPhno.equals(lb.getPhno()));
				lb.setfName(lfName);
				lb.setlName(llName);
				lb.setAddr(lAddr);
				
				int k = new UpdateLibrarianDAO().update(lb);
				if(k>0)
				{
					req.setAttribute("msg", "Librarian Updated Successfully...<br>");
					
					req.getRequestDispatcher("UpdateLibrarian.jsp").forward(req, res);
				}//end of if
				break;
			}
			
		}
	}

}
