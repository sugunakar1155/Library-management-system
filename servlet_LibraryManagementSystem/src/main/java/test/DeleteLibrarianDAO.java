package test;
import java.sql.*;
public class DeleteLibrarianDAO {
	public int k=0;
	public int delete(LibrarianBean lb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Delete from librarian where phno=?");
			ps.setLong(1, lb.getPhno());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

}
