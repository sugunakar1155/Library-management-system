package test;
import java.sql.*;
import java.util.*;
public class ViewAllBooksDAO {
	
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	
	public ArrayList<BookBean> retrieve()
	{
		
		try
		{
		Connection con = DBConnection.getCon();
		
		PreparedStatement ps = con.prepareStatement("select * from bookdetails50 ");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			BookBean bb = new BookBean();
			
			bb.setBookCode(rs.getString(1));
			bb.setBookName(rs.getString(2));
			bb.setAuthorName(rs.getString(3));
			bb.setPrice(rs.getFloat(4));
			bb.setQuantity(rs.getInt(5));
			al.add(bb);
			
	     }

		}
		catch(Exception e)
		{
			e.printStackTrace();
	}
		return al;

	
		
	}

}
