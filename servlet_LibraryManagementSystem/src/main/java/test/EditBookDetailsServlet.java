package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/editbook")
public class EditBookDetailsServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "SessionExpired..");
			req.getRequestDispatcher("Msg.jsp").forward(req,res);
		}
		else
		{
			String bCode = req.getParameter("bcode");
			@SuppressWarnings("unchecked")
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("alist");
			Iterator<BookBean>it=al.iterator();
			while(it.hasNext())
			{
				BookBean bb = (BookBean)it.next();
				
				if(bCode.equals(bb.getBookCode()))
				{
					req.setAttribute("bbean", bb);
					req.getRequestDispatcher("EditBookDetails.jsp").forward(req, res);
					break;
				}
			}//end of loop
			
		}
	}

}
