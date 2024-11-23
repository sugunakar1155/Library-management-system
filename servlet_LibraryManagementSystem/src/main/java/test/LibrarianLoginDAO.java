package test;
import java.sql.*;
public class LibrarianLoginDAO {
	
	public LibrarianBean lb=null;
	public LibrarianBean login(String uName,String pWord)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from librarian where uname =? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				lb=new LibrarianBean();
				lb.setuName(rs.getString(1));
				lb.setpWord(rs.getString(2));
				lb.setfName(rs.getString(3));
				lb.setlName(rs.getString(4));
				lb.setAddr(rs.getString(5));
				lb.setMid(rs.getString(6));
				lb.setPhno(rs.getLong(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lb;
		
	}

	
	

}
