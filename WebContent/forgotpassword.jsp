<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forgot password reset</title>
</head>
<header> <a href="login.jsp">Login</a> <a href="register.jsp">Register</a></header>
<body>

	<center>
		<h2>
			<font color="green">${passwordResetError}</font>
		</h2>
		<form action="forgot.do" method="post">
			<div>
				Enter Registered Email : <input type="email" name="email"><input
					type="submit" value="Reset">
			</div>
	</center>
	</form>
</body>
</html>