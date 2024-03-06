package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewStudentDAO
{
	public int k = 0;
	public int newStudentRegister(StudentBean sb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("INSERT INTO STUDENT(NAME, ROLLNO) VALUES(?,?)");
			ps.setString(1, sb.getName());
			ps.setInt(2, sb.getRollNo());
			k = ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return k;
	}
}
