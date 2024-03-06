<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.CoordinatorBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		CoordinatorBean cb = (CoordinatorBean)session.getAttribute("coordinatorbean");
		String msg = (String)request.getAttribute("msg");
		out.println(msg);
		out.println("Name: " + cb.getName() + "<br>");
		out.println("RollNo: "+ cb.getRollNo() + "<br>");
	%>
	<a href="NewStudent.html">New Student Register?</a>
	<a href="StudentLogin.html">Student Login</a>
	<a href="logout">Logout</a>
</body>
</html>