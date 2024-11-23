package test;
import java.sql.*;
public class DeleteBookDetailsDAO {
	public int k=0;
	public int delete(BookBean bb)
	{
		
		try
		{
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("Delete from BookDetails50 where bookcode=?");
		ps.setString(1, bb.getBookCode());
		k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
		
	

}
}