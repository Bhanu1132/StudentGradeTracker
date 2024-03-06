package test;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet("/uploadmarks")
@SuppressWarnings("serial")
public class UplaodMarksServlet extends HttpServlet 
{
	@SuppressWarnings("removal")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		int sub1  = Integer.parseInt(req.getParameter("sub1"));
		int sub2  = Integer.parseInt(req.getParameter("sub2"));
		int sub3  = Integer.parseInt(req.getParameter("sub3"));
		int sub4  = Integer.parseInt(req.getParameter("sub4"));
		int sub5  = Integer.parseInt(req.getParameter("sub5"));
		int sub6  = Integer.parseInt(req.getParameter("sub6"));
		if((sub1<0 || sub1>100) || (sub2<0 || sub2>100) || (sub3<0 || sub3>100) ||
				(sub4<0 || sub4>100) || (sub5<0 || sub5>100) || (sub6<0 || sub6>100))
		{
			req.setAttribute("msg", "Invalid Marks...<br>");
			req.getRequestDispatcher("StudentLogin.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession(false);
			if(hs==null)
			{
				req.setAttribute("msg", "Session Expired...<br>");
				req.getRequestDispatcher("Home.jsp").forward(req, res);
			}
			else
			{
				StudentBean sb = (StudentBean)hs.getAttribute("studentbean");
				sb.setSub1(sub1);
				sb.setSub2(sub2);
				sb.setSub3(sub3);
				sb.setSub4(sub4);
				sb.setSub5(sub5);
				sb.setSub6(sub6);
				int totMarks = (sb.getSub1() + sb.getSub2() + sb.getSub3() + sb.getSub4() + sb.getSub5() + sb.getSub6());
				sb.setTotalMarks(totMarks);
				float per = (float)(totMarks)/6;
				sb.setPercentage(per);
				if((sub1>=0 && sub1<=34) || (sub2>=0 &&  sub2<=34) || (sub3>=0 && sub3<=34) || 
						(sub4>=0 && sub4<=34) || (sub5>=0 && sub5<=34) || (sub6>=0 && sub6<=34))
				{
					sb.setGrade("F");
				}//end of if
				else if((sb.getPercentage()>35 && sb.getPercentage()<=50))
				{
					sb.setGrade("D");
				}//end of else-if
				else if((sb.getPercentage()>50 && sb.getPercentage()<=60))
				{
					sb.setGrade("C");
				}//end of else-if
				else if((sb.getPercentage()>60 && sb.getPercentage()<=70))
				{
					sb.setGrade("B");
				}//end of else-if
				else if((sb.getPercentage()>70 && sb.getPercentage()<=100))
				{
					sb.setGrade("A");
				}//end of else-if
				TreeSet<Integer> ts = new TreeSet<Integer>();
				ts.add(new Integer(sub1));
				ts.add(new Integer(sub2));
				ts.add(new Integer(sub3));
				ts.add(new Integer(sub4));
				ts.add(new Integer(sub5));
				ts.add(new Integer(sub6));
				System.out.println(ts.toString());
				sb.setlMarks(ts.first());
				sb.sethMarks(ts.last());
				int size = ts.size();
				Integer arr[] = new Integer[size];
				arr = ts.toArray(arr);
				sb.setavgMarks(arr[size/2]);
				int k = new UploadMarksDAO().uploadMarks(sb);
				if(k>0)
				{
					req.setAttribute("msg", "Marks Uploaded Successfully...<br>");
					req.getRequestDispatcher("UploadMarks.jsp").forward(req, res);
				}//end of if
			}//end of if
		}//end of if-else
	}//end of if-else
}
