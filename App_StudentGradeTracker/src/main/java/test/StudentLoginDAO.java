package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginDAO
{
	public StudentBean sb = null;
	public StudentBean stuLogin(int rollNo)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM STUDENT WHERE ROLLNO=?");
			ps.setInt(1, rollNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				sb = new StudentBean();
				sb.setName(rs.getString(1));
				sb.setRollNo(rs.getInt(2));
				sb.setSub1(rs.getInt(3));
				sb.setSub2(rs.getInt(4));
				sb.setSub3(rs.getInt(5));
				sb.setSub4(rs.getInt(6));
				sb.setSub5(rs.getInt(7));
				sb.setSub6(rs.getInt(8));
				sb.setTotalMarks(rs.getInt(9));
				sb.setPercentage(rs.getFloat(10));
				sb.setGrade(rs.getString(11));
				sb.setlMarks(rs.getInt(12));
				sb.setavgMarks(rs.getInt(13));
				sb.sethMarks(rs.getInt(14));
			}
		}//end of try
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return sb;
	}
}
