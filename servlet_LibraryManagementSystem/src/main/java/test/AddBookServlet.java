package test;
import java.io.*;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")
@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			BookBean bb = new BookBean();
			bb.setBookCode(req.getParameter("code"));
			bb.setBookName(req.getParameter("name"));
			bb.setAuthorName(req.getParameter("aname"));
			bb.setPrice(Float.parseFloat(req.getParameter("price")));
			bb.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			
			int k =new AddBookDetailsDAO().insert(bb);
			
				if(k>0)
				{
					req.setAttribute("msg","BookDetails Added Successfully...<br>");
					req.getRequestDispatcher("AddBookDetails.jsp").forward(req, res);
				}
			
			
		
		}
		
	}
}


	