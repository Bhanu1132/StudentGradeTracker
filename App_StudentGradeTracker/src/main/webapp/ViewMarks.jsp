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
	%>
	<h2>Marks Details</h2>
	<table border="1" cellspacing="0">
		<tbody>
			<tr>
				<th>NAME</th>
				<th>ROLLNO</th>
				<th>SUB1</th>
				<th>SUB2</th>
				<th>SUB3</th>
				<th>SUB4</th>
				<th>SUB5</th>
				<th>SUB6</th>
				<th>TOTALMARKS</th>
				<th>PERCENTAGE</th>
				<th>GRADE</th>
				<th>LMARKS</th>
				<th>AVGMARKS</th>
				<th>HMARKS</th>
			</tr>
			<tr>
				<td><%=sb.getName()%></td>
				<td><%=sb.getRollNo() %>
				<td><%=sb.getSub1() %></td>
				<td><%=sb.getSub2() %></td>
				<td><%=sb.getSub3() %></td>
				<td><%=sb.getSub4() %></td>
				<td><%=sb.getSub5() %></td>
				<td><%=sb.getSub6()%></td>
				<td><%=sb.getTotalMarks() %></td>
				<td><%=sb.getPercentage() %></td>
				<td><%=sb.getGrade()%></td>
				<td><%=sb.getlMarks() %></td>
				<td><%=sb.getavgMarks() %></td>
				<td><%=sb.gethMarks() %></td>
			</tr>
		</tbody>
	</table><br>
	<a href="logout">Logout</a>
</body>
</html>