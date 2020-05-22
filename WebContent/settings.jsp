<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Settings</title>
<!-- <script type="text/javascript">
function disableBackButton()
{
	location.href(logout.jsp);
}
if(window.history.forward(1)!=null)
	window.history.forward(1);
</script> -->
<a href="welcome.jsp">Back</a>
</head>
<body>
	<center style="margin-top: 50px; margin-bottom: 50px">

		<ul>
			<a href="update_password.jsp">Reset Password</a>
		</ul>
		<ul>
			<a href="update_profile.jsp">Update Profile</a>
		</ul>
		<ul>
			<a href="delete.jsp">Delete Account</a>
		</ul>
		<ul>
			<a href="logout.jsp">Logout</a>
			<!-- <form action="logout.do" method="get">
				<div>
					<input type="submit" value="Logout" name="logout" onclick="disableBackButton()">
				</div>
			</form> -->
		</ul>
	</center>
</body>
</html>