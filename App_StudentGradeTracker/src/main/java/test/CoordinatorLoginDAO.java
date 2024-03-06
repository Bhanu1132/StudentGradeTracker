package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinatorLoginDAO 
{
	public CoordinatorBean cb = null;
	public CoordinatorBean coordinatorLogin(int rollNo)
	{
		try
		{
			Connection con = DBConnection.getCon();
			//preparing statement
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM COORDINATORLOGIN WHERE ROLLNO=?");
			ps.setInt(1, rollNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				cb = new CoordinatorBean();
				cb.setName(rs.getString(1));
				cb.setRollNo(rs.getInt(2));
			}
		}//end of try
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return cb;
	}
}
