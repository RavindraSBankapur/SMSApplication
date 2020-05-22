<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deactivate</title>
</head>
<body>
<a href="welcome.jsp">Home</a>
<form action="deactive.do" method="post">
	<table align="center" cellspacing="20%">
		<tr>
			<div>
				<td><h3 style="color: green;">${message}</h3></td>
			</div>
		</tr>
		<tr>
			<div>
				<td><h3 style="color: green;">${noMatchCredential}</h3></td>
			</div>
		</tr>
		<tr>
			<div>
				<td>Email ID :<input type="email" name="email"></td>
			</div>
		</tr>
		<tr>
			<div>
				<td>Password :<input type="password" name="password"></td>
			</div>
		</tr>
		<tr>
			<div align="center">
				<td><input type="submit" value="Deactivate"></td>
			</div>
			<!-- </tr>
				<tr> -->
			<div>
				<td><input type="reset" value="Reset"></td>
			</div>
		</tr>
	</table>
</form>
</body>
</html>