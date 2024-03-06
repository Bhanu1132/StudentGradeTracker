<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.StudentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		StudentBean sb = (StudentBean)session.getAttribute("studentbean");
		String msg = (String)request.getAttribute("msg");
		out.println(msg);
		out.println("Name: " + sb.getName() +"<br>");
		out.println("RollNo: " + sb.getRollNo()+ "<br>");
	%>
	<a href="UploadMarks.html">Upload Marks</a>
	<a href="viewmarks">View Marks</a>
	<a href="logout">Logout</a>
</body>
</html>