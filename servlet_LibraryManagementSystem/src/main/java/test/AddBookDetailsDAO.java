package test;
import java.sql.*;
public class AddBookDetailsDAO{
	public int k=0;
	public int insert(BookBean bb)
	{
		try
		{
			Connection con =DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into bookdetails50 values (?,?,?,?,?)");
			ps.setString(1, bb.getBookCode());
			ps.setString(2, bb.getBookName());
			ps.setString(3, bb.getAuthorName());
			ps.setFloat(4, bb.getPrice());
			ps.setInt(5, bb.getQuantity());
			 k =ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	
	
}
