<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Student List</title>
</head>
<body>
	<h1>data displaying</h1>
	<div align="center">
		<table border="2" cellpadding="5">
			<caption>
				<h2>List of Students</h2>
			</caption>
			<tr>
				<th>Student ID</th>
				<th>Name</th>
				<th>Contact No.</th>
				<th>Branch</th>
				<th>Email</th>
			</tr>
		<%-- 	<h4>welcome</h4><font color="blue">${list.name}</font> --%>
			<c:forEach var="student" items="${lists}">
				<tr>
					<td><c:out value="${student.studentID}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.number}" /></td>
					<td><c:out value="${student.branch}" /></td>
					<td><c:out value="${student.email}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>