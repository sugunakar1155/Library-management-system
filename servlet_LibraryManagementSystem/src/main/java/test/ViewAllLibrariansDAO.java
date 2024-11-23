package test;
import java.sql.*;


import java.util.*;
public class ViewAllLibrariansDAO {
	
	public ArrayList<LibrarianBean>al = new ArrayList<LibrarianBean>();
	
	public ArrayList<LibrarianBean> retrieve()
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from librarian");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				LibrarianBean lb = new LibrarianBean();
				lb.setuName(rs.getString(1));
				lb.setpWord(rs.getString(2));
				lb.setfName(rs.getString(3));
				lb.setlName(rs.getString(4));
				lb.setAddr(rs.getString(5));
				lb.setMid(rs.getString(6));
				lb.setPhno(rs.getLong(7));
				
				al.add(lb); //LibrarianBean added to ArrayList Object
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return al;
	}

}
