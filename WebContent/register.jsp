<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body bgcolor="#ffffcc" font-color="red" bottommargin="100%">
	<form action="register.do" method="post" border="1" name="student"
		enctype="multipart/form-data">
		<td align="center">
			<h1>
				<marquee>Welcome to Registration</marquee>
			</h1>
			<div align="center">
				<h1 style="color: green;">${success}</h1>
			</div>
		</td>
		<h2 align="center">Registration Form</h2>
		<h3 align="right">
			Please Login :<a href="login.jsp">Here</a>
		</h3>
		<table border='0' width='480px' cellpadding='0' cellspacing='0'
			align='center' bordercolor="black">
			<br>
			<tr>
				<div align="center">
					<font color="red">${uniqueEmailError}</font>
				</div>
				<td>Email ID :</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				
				<td>Password* :</td>
				<td><input type="password" name="password"><div align="center">
					<font color="red">${emptyPassword}</font>
				</div></td>
				
			
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				
				<td>Confirm Password* :</td>
				<td><input type="password" name="confirmPassword">
				<div align="center">
					<font color="red">${emptyPassword}</font>
				</div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<div align="center">
					<font color="red">${nameNotEmpty}</font>
				</div>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
						
				
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Address :</td>${addressNotEmpty}
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>$
			</tr>
			<tr>
				<td>Phone Number :</td>${numberNotNull}
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Date of Birth :</td>${dobNotEmpty}
				<td><input id="date" type="date" name="dob"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Gender :<br></td>${genderNotNull}
				<td><input type="radio" name="gender" value="male"
					checked="checked"> Male <br> <input type="radio"
					name="gender" value="female"> Female <br> <input
					type="radio" name="gender" value="other"> Other</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Upload Picture :<br></td>${upload_image}
				<td><input type="file" name="fileUpload" size="20"
					value="fileUpload" id="fileUpload"> <label for="fileUpload"></label>
					<br></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Branch :</td>
				<td><select name="branch">{field_black}
						<option value="default">ALL</option>
						<option value="ise">ISE</option>
						<option value="cse">CSE</option>
						<option value="tce">TCE</option>
						<option value="ECE">ECE</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<table border='0' cellpadding='0' cellspacing='0' width='480px'
				align='center'>
				<tr>
					<td align='center'><input type="submit" value="Register"></td>
					<br>
					<br>
					<br>
				</tr>
			</table>
			<br>
			<table border='0' cellpadding='0' cellspacing='0' width='480px'
				align='center'>
				<tr>
					<td align='center'><input type="reset" value="Reset"></td>
				</tr>
			</table>

		</table>
	</form>

</body>
</html>