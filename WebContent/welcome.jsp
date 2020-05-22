<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<script type="text/javascript">
function disableBackButton()
{
	
	location.href(logout.jsp);
}
if(window.history.forward(1)!=null)
	window.history.forward(1);
</script>
</head>
<body bgcolor="#ccccff">
	<!-- <a href="viewList.jsp">Search All Student</a>
 -->
	<%-- <font align="center" color="orange"><h3>${dto}</h3></font> --%>
	<%-- welcome --${name.name}
		${name.fileName} } --%>
	<center>
		<font size="5px" style="color: green; font-style:oblique; font-family: cursive;">${activated}</font>
		<font size="5px" style="color: green; font-style:oblique; font-family: cursive;">${changeSuccess}</font>
		<font size="5px" style="color: green; font-style:oblique; font-family: cursive;">${profile}</font>
	</center>	
		
	
	<header align="right">
	 <font color="#cc6633"><h2 align="center">Welcome to Sakha Account Management System</h2></font>
	<h3>
		<font color="#663300">Welcome</font> <font color="blue">${name.name}</font>
		<br>
	</h3>
	<%-- <font align="right"><h4>${name.branch}</h4></font> --%>
	<h2>${student.name}</h2>
	<h3>${name.address}</h3>
	<a href="settings.jsp">Account Settings</a><!--  | <a href="search.jsp">Search</a> -->
	<br>
	<!-- 	<a href="logout.jsp">Logout</a>  -->
	<div>
		<form action="logout.do" method="get">
			<div>
				<input type="submit" value="Logout" name="logout" onclick="disableBackButton()">
			</div>
		</form>
	</div>
	</header>

	</h3>
	<font color="green"><h2 align="center">${msg}</h2></font>
	<form action="search.do" method="post">
		<div align="left">
			<table>
				<tr>
					<td>Search Students By Department :<select name="branch">
							<option value="default">Select</option>
							<option value="ise">ISE</option>
							<option value="cse">CSE</option>
							<option value="tce">TCE</option>
							<option value="ece">ECE</option>
					</select> <input type="submit" value="Search">
					</td>
				</tr>
			</table>
		</div>
	</form>
	<form action="view.do">
	<div align="center"><input type="submit" value="Search All Students"></div>	
	</form>
	
	
	<div align="center">
		<table border="1" cellpadding=10 cellspacing="5" style="border: 2px"medium;  >
			<caption>
				<h2>List of Students</h2>
			</caption>

			<!-- 			<td>Branch :</td> -->
			<tr>
				<th>Student ID</th>
				<th>Name</th>
				<th>Contact No.</th>
				<th>Branch</th>
				<th>Email</th>
			</tr>
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


	<footer> </footer>


</body>
</html>