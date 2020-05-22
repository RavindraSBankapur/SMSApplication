<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
</head>
<body marginheight="30%" marginwidth="30%" leftmargin="50%"
	topmargin="50%" bgcolor="skyblue">
	<font align="center">Please enter the code sent to your
		Registered Email ID</font>
	<form action="resetpassword.do" method="post">
		<table>
			<tr>
				<div>
					<td><font>Enter the Code:<input type="password"
							name="code"></font></td> <br>
				</div>
			</tr>
			<tr>
				<div>
					<td><font>New Password :<input type="password"
							name="password"></font></td> <br>
				</div>
			</tr>
			<tr>
				<div>
					<td><font>Confirm Password :<input type="cpassword"
							name="cpassword"></font></td> <br>
				</div>
			</tr>
			<tr>
				<div>
					<td align="center"><input type="submit" value="Save"></font></td>
				</div>
			</tr>
		</table>
	</form>
</body>
</html>