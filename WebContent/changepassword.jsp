<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>change password</title>
</head>
<body>
	<form action="change.do">
		<table>

			<tr>
				<td><div>
						New Password : <input type="password" name="password">
						<div></td>
			</tr>


			<tr>
				<td>
					<div>
						Confirm Password: <input type="text" name="cpassword">
						<div>
				</td>
			</tr>


			<tr>
				<td><div>
						<input type="submit" value="Save">
						<div></td>
			</tr>
		</table>


	</form>
</body>
</html>