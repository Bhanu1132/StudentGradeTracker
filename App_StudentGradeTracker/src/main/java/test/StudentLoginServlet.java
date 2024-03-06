package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet("/studentlogin")

@SuppressWarnings("serial")
public class StudentLoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			int rollNo = Integer.parseInt(req.getParameter("rollno"));
			if(rollNo<=0 || rollNo>=99999)
			{
				req.setAttribute("msg", "Invalid RollNo...<br>");
				req.getRequestDispatcher("NewStudent.jsp").forward(req, res);
			}
			else
			{
				StudentBean sb = new StudentLoginDAO().stuLogin(rollNo);
				if(sb==null)
				{
					req.setAttribute("msg", "RollNo Doesn't Exist...<br>");
					req.getRequestDispatcher("NewStudent.jsp").forward(req, res);
				}
				else
				{
					hs.setAttribute("studentbean", sb);
					req.setAttribute("msg", "Login Successfull...<br>");
					req.getRequestDispatcher("StudentLogin.jsp").forward(req, res);
				}//end of if-else
			}//end of if-else
		}//end of if-else
	}
}
