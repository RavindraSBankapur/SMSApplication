<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<a href="index.jsp">Home</a>
<body background="/img/students.jpg" topmargin="15%">

	<center>
		<h2 style="color: activecaption;">Welcome to Login</h2>
		<h2>
			<font color="green">${logoutSuccess}</font>
		</h2>
		<h2>
			<font color="green">${PasswordResetSuccess}</font>
		</h2>

		<h2>
			<font color="green">${changeFailure}</font>
		</h2>
		<h2>
			<font color="green">${deleteSuccess}</font>
		</h2>
		<h2>
			<font color="green">${loginError}</font>
		</h2>
		<h2>
			<font color="green">${validationFailed}</font>
		</h2>
		<h2>
			<font color="green">${registrationSuccess}</font>
		</h2>
		<h2>
			<font color="green">${deleteStatus}</font>
		</h2>
		<h2>
			<font color="green">${message}</font>
		</h2>
		<h2>
			<font color="green">${invalidDeactivateAttempt}</font>
		</h2>
	</center>
	<form action="login.do" method="post" modelAttribute="login"
		id="loginProcess">
		<center>
			<table cellspacing="20%">

				<tr>
					<div>
						<td>Email ID :<input type="email" name="email"></td>
					</div>
				</tr>
				<tr>
					<div>
						<font color="green">${PasswordMisMatch}</font>
					</div>

					<div>
						<td>Password :<input type="password" name="password"></td>
					</div>
				</tr>
				<tr>
					<div>
						<td><input type="submit" value="Login"></td>
					</div>
					<div>
						<td><input type="reset" value="Reset"></td>
					</div>
				</tr>
			</table>

			<font
				style="color: maroon; font-style: italic; font-family: cursive;">
				<p>
					<a href="forgotpassword.jsp">forgot password ?</a>
				</p>
			</font>
		</center>
	</form>
</body>
</html>