package test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet("/viewmarks")

@SuppressWarnings("serial")
public class ViewMarksServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
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
			req.getRequestDispatcher("ViewMarks.jsp").forward(req, res);
		}//end of if-else
	}
}
