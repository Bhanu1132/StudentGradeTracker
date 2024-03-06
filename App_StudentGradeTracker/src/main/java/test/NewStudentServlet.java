package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/newstudent")

@SuppressWarnings("serial")
public class NewStudentServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String name = req.getParameter("sname");
		int rollNo = Integer.parseInt(req.getParameter("rollno"));
		if(rollNo<=0 || rollNo>=99999)
		{
			req.setAttribute("msg", "Invalid RollNo...<br>");
			req.getRequestDispatcher("CoordinatorLogin.jsp").forward(req, res);
		}
		else
		{
			StudentBean sb = new StudentBean();
			sb.setName(name);
			sb.setRollNo(rollNo);
			int k = new NewStudentDAO().newStudentRegister(sb);
			if(k>0)
			{
				req.setAttribute("msg", "Registered Successfully...<br>");
				req.getRequestDispatcher("NewStudent.jsp").forward(req, res);
			}//end of if
		}//end of if-else
	}
}
