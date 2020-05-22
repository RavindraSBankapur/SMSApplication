<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search By Department</title>
</head>
<body>
	<h1></h1>
	<div align="center">
		<table border="2" cellpadding="5">
			<caption>
				List of Students
			</caption>
			<tr>
				<th>Name</th>
				<th>Contact No.</th>
				<th>Branch</th>
				<th>Email</th>
			</tr>
			<c:forEach var="student" items="${lists}">
				<tr>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.number}" /></td>
					<td><c:out value="${student.branch}" /></td>
					<td><c:out value="${student.email}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="welcome.jsp">Back</a>
</body>
</html>