package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")
@WebServlet("/deletebook")
public class DeleteBookDetailsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			@SuppressWarnings("unchecked")
			ArrayList<BookBean> al =(ArrayList<BookBean>)hs.getAttribute("alist");
			String bCode=req.getParameter("bcode");
			
			Iterator<BookBean>it=al.iterator();
			while(it.hasNext())
			{
				BookBean bb =(BookBean)it.next();
				if(bCode.equals(bb.getBookCode()))
				{
					bb.setBookCode(bCode);  //Deleting BookBean
			
					int k = new DeleteBookDetailsDAO().delete(bb);
					if(k>0)
					{
						req.setAttribute("msg", "BookDetails Deleted Successfully...<br>");
						req.getRequestDispatcher("DeleteBookDetails.jsp").forward(req, res);
					}//end of if
					break;
				}//end of if
			}//end of while
		}
		}
	}


