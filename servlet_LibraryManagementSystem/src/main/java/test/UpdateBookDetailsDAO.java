package test;
import java.sql.*;
public class UpdateBookDetailsDAO {
	public int k=0;
	public synchronized int update(BookBean bb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update bookdetails50 set bookname=?,author=?,price=?,quantity=? where bookcode=?");
			ps.setString(1, bb.getBookName());
			ps.setString(2, bb.getAuthorName());
			ps.setFloat(3,bb.getPrice() );
			ps.setInt(4, bb.getQuantity());
			ps.setString(5, bb.getBookCode());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	

}
