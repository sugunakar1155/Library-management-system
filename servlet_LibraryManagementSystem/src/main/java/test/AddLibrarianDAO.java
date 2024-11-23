package test;
import java.sql.*;

public class AddLibrarianDAO {
	
	public int k=0;
	public int insert(LibrarianBean lb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into Librarian values(?,?,?,?,?,?,?)");
			ps.setString(1, lb.getuName());
			ps.setString(2, lb.getpWord());
			ps.setString(3, lb.getfName());
			ps.setString(4, lb.getlName());
			ps.setString(5, lb.getAddr());
			ps.setString(6, lb.getMid());
			ps.setLong(7, lb.getPhno());
			k=ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

}
