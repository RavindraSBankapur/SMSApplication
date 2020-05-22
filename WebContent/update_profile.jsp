<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
</head>
<!-- <tr>
	<th>Employee Name :</th>
	<td><input type="text" name="name" value="edto.empName"></td>
</tr>
 -->
<body bgcolor="#ccccff" font-color="red" bottommargin="100%">

	<a href="welcome.jsp"><h3 style="border: 2">Home</h3></a>
	<form action="updateProfile.do" method="post" border="1" name="student"
		enctype="multipart/form-data">
		<td align="center">
			<div align="center">
				<h3 style="color: green;">${message}</h3>
			</div>
		</td>
		<h2 align="center">Update Profile</h2>
		<table border='0' width='480px' cellpadding='0' cellspacing='0'
			align='center' bordercolor="black">
			<br>
			<tr>
				<td>Email ID :</td>
				<td><input type="text" name="email" value="${student.email}" readonly="readonly"><font
					color="red">${error_email}</font></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" value="${student.name}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" value="${student.address}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><input type="text" name="number" value="${student.number}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Date of Birth :</td>
				<td><input id="date" type="text" name="dob" value="${student.dob}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Gender :<br></td>
				<td>
				<input type="radio" name="gender" value="male"
					placeHolder="${student.gender}" checked="checked"> Male <br>
					<input type="radio" name="gender" value="female">Female <br> 
					<input type="radio" name="gender" value="other">Other</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Upload Picture :<br></td>
				<td><input type="file" name="fileUpload" size="50"
					value="fileUpload" id="fileUpload"> <label for="fileUpload"></label>
					<br></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Branch :</td>
				<td><select name="branch" value="${dto.branch}">
						<option value=" ">Select</option>
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
					<td align='center'><input type="submit" value="Save Update"></td>
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