package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddLibrarianServlet extends HttpServlet{
	
	

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			LibrarianBean lb =new LibrarianBean();
			
			lb.setuName(req.getParameter("uname"));
			lb.setpWord(req.getParameter("pword"));
			lb.setfName(req.getParameter("fname"));
			lb.setlName(req.getParameter("lname"));
			lb.setAddr(req.getParameter("addr"));
			lb.setMid(req.getParameter("mid"));
			lb.setPhno(Long.parseLong(req.getParameter("phno")));
			int k = new AddLibrarianDAO().insert(lb);
			if(k>0)
			{
				req.setAttribute("msg", "Librarian Added Successfully..<br>");
				req.getRequestDispatcher("AddLibrarian.jsp").forward(req, res);
			}
		}
	}

}
