<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
<header align="right"> <font color="#cc6633"><h2
		align="center">Welcome to Sakha Account Management System</h2></font>
<h3>
	<font color="#663300">Welcome</font> <font color="blue">${name.name}</font>
	<br>
</h3>
<font align="right"><h4>${name.branch}</h4></font>
<h2>${student.name}</h2>
<h3>${name.address}</h3>
<a href="settings.jsp">Account Settings</a> | <a href="search.jsp">Search</a>
<br>
<!-- 	<a href="logout.jsp">Logout</a>  -->
<div>
	<form action="logout.do" method="get">
		<div>
			<input type="submit" value="Logout" name="logout">
		</div>
	</form>
</div>
</header>

</head>
</html>