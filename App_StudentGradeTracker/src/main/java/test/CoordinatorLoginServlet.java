package test;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/coordinatorlogin")

@SuppressWarnings("serial")
public class CoordinatorLoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		int rollNo = Integer.parseInt(req.getParameter("rollno"));
		if(rollNo<=0 ||  rollNo>=99999)
		{
			req.setAttribute("msg", "Invalid RollNo...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}//end of if
		else
		{
			CoordinatorBean cb = new CoordinatorLoginDAO().coordinatorLogin(rollNo);
			if(cb==null)
			{
				req.setAttribute("msg", "RollNo Not Exist...<br>");
				req.getRequestDispatcher("Home.jsp").forward(req, res);
			}
			else
			{
				HttpSession hs = req.getSession();			
				hs.setAttribute("coordinatorbean", cb);
				req.setAttribute("msg", "Login Successfull...<br>");
				req.getRequestDispatcher("CoordinatorLogin.jsp").forward(req, res);
			}//end of if-else
		}
	}
}
