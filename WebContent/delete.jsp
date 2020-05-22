<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Student Record</title>
</head>
<header align="left"> <a href="welcome.jsp"><h3
		style="border: 2";>Home</h3></a></header>
<body>
	<div align="center">
		<a href="logout.jsp">Logout</a>
	</div>
	<div align="center">
		<h4 style="color: brown;">${deleteStatus}</h4>
	</div>
	
<h3>Want to go off from account for Sometime??</h3>
<h4>You can be back any time</h4><td><a href="deactivate.jsp">Click here</td></a>
		<%-- <center>
		<h2>Delete Student Record</h2>
		<br>
		<form action="delete.do" method="post" name="student">
			<table>
				<tr>
					<th>Enter Email ID :</th>
					<td><input type="email" name="email" required></td>
					<td>${deleteError}</td>
					
				</tr>

				<tr>
					<td><input type="submit" value="Delete"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
	</center> --%>

</body>

</body>
</html>