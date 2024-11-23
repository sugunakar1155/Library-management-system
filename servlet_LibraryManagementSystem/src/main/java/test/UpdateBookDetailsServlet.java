package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")
@WebServlet("/updatebook")
public class UpdateBookDetailsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp");
		}
		else
		{
			
			@SuppressWarnings("unchecked")
			ArrayList<BookBean> al =(ArrayList<BookBean>)hs.getAttribute("alist");
			String bCode=req.getParameter("bcode");
			String bName=req.getParameter("name");
			String authorName=req.getParameter("aname");
			float bprice=Float.parseFloat(req.getParameter("price"));
			int bQuantity=Integer.parseInt(req.getParameter("quantity"));
			
			Iterator<BookBean>it=al.iterator();
			while(it.hasNext())
			{
				BookBean bb =(BookBean)it.next();
				if(bCode.equals(bb.getBookCode()))
				{
					bb.setBookName(bName);  //Updating BookBean
			bb.setAuthorName(authorName); //Updating BookBean
					bb.setPrice(bprice); //Updating BookBean
					bb.setQuantity(bQuantity); //Updating BookBean
					
					int k = new UpdateBookDetailsDAO().update(bb);
					if(k>0)
					{
						req.setAttribute("msg", "BookDetails Updated Successfully...<br>");
						req.getRequestDispatcher("UpdateBookDetails.jsp").forward(req, res);
					}//end of if
					break;
				}//end of if
			}//end of while
		}
	}

}
