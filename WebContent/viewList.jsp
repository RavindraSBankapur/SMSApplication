<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All Students</title>
<a href="welcome.jsp">Back</a>
</head>
<body>
<!-- 	<form action="view.do">
		<input type="submit" value="Search">
	</form>
 -->	<div align="center">
		<table border="1" cellpadding=10 cellspacing="5" style="border: 2px"medium;  >
			<caption>
				<h2>
					List of Students
				</h2>
			</caption>
			<!-- 			<td>Branch :</td> -->
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Contact No.</th>
				<th>Branch</th>
				<th>Email</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Address</th>

			</tr>
			<c:forEach var="user" items="${studentList}">
				<tr>
					<td><c:out value="${user.studentID}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.number}" /></td>
					<td><c:out value="${user.branch}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.dob}" /></td>
					<td><c:out value="${user.gender}" /></td>
					<td><c:out value="${user.address}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>




</body>
</html>