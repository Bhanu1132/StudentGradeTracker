package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadMarksDAO
{
	public int k = 0;
	public int uploadMarks(StudentBean sb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("UPDATE STUDENT SET SUB1=?, SUB2=?, SUB3=?, SUB4=?, SUB5=?, SUB6=?, TOTALMARKS=?, PERCENTAGE=?, GRADE=?, LMARKS=?, AVGMARKS=?, HMARKS=? WHERE ROLLNO=?");
			ps.setInt(1, sb.getSub1());
			ps.setInt(2, sb.getSub2());
			ps.setInt(3, sb.getSub3());
			ps.setInt(4, sb.getSub4());
			ps.setInt(5, sb.getSub5());
			ps.setInt(6, sb.getSub6());
			ps.setInt(7, sb.getTotalMarks());
			ps.setFloat(8, sb.getPercentage());
			ps.setString(9, sb.getGrade());
			ps.setInt(10, sb.getlMarks());
			ps.setInt(11, sb.getavgMarks());
			ps.setInt(12, sb.gethMarks());
			ps.setInt(13, sb.getRollNo());
			k = ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return k;
	}
}
