<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<script type="text/javascript">
function disableBackButton()
{
	
	location.href(logout.jsp);
}
if(window.history.forward(1)!=null)
	window.history.forward(1);
</script>

</head>
<body topmargin="50px" bottommargin="50px">
	<center>
		<font>
			<form action="logout.do" method="get">
				<div>
					<input type="submit" value="Logout" name="logout" onclick="disableBackButton()">
				</div>
			</form>
		</font>
	</center>
	<!-- <font color="#ff3399">{message}</font> -->
	<!-- <br> click here to <a href="login.jsp">Login</a> -->
</body>
</html>