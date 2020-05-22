<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update_password</title>
</head>
<body style="margin-top: 50px" ,marginwidth="50px" bgcolor="#ffffcc">
	<center>
	<h2>Please Use Proper Credentials</h2>
		<form action="updatePassword.do" method="post">
			<table>
				<tr>	
					<td>Enter Your Registered Email ID:<input type="email"
						name="email">${updateEmailFailure}
					</td>
				</tr>
				<tr>
					<td>Enter old Password :<input type="password"
						name="oldPassword">${updatePasswordFailure}
					</td>
				</tr>
				<tr>
					<td>Enter New Password :<input type="password"
						name="password">${updatePasswordFailure}
					</td>
				</tr>
				<tr>
					<td>Confirm New Password:<input type="text"
						name="confirmPassword">${updatePasswordFailure}
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Password"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>