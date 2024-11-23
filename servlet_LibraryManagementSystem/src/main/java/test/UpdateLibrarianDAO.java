package test;
import java.sql.*;
public class UpdateLibrarianDAO {
	public int k =0;
	public synchronized int update(LibrarianBean lb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update librarian set fname=?,lname=?,addr=? where phno=?");
			ps.setString(1, lb.getfName());
			ps.setString(2, lb.getlName());
			ps.setString(3, lb.getAddr());
			ps.setLong(4,lb.getPhno());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return k;
	}

}
