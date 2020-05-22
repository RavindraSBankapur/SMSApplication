<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
</head>
<body bgcolor="#996666">
<center>
<h1>Search Student Records</h1><br>
<form action="search.do" method="post" name="student" >
<table>
<tr>
	<th>Student Name :</th>
	<td><input type="text" name="name" ></td>
</tr>

<tr>
	<th>Email ID (Must):</th>
	<td><input type="email" name="email" required></td>
</tr>

<tr>
	<th>Branch  :</th>
	<td><input type="text" name="branch"></td>
</tr>


<tr>
	<td><input type="submit" value="Search"></td>
	<td><input type="reset" value="Clear" ></td>
</tr>
</table>
</form>
</center>
<a href="welcome.jsp"><h4 style="border: 2">Back</h4></a>

</body>
</html>