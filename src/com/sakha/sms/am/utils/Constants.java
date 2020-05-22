package com.sakha.sms.am.utils;

public interface Constants {
	
	String NOT_EQUAL="Password and Confirm Password must be equal!";
	String NAME_NOT_NULL="Name must not be blank";
	String ADDRESS_NOT_NULL="Adress must not be blank";
	String DATE_OF_BIRTH_NOT_NULL="Adress must not be blank";
	String NUMBER_NOT_NULL="Adress must not be blank";
	String GENDER_NOT_NULL="Adress must not be blank";
	String CHANGE_PASSWORD_ERROR="Invalid Email ID, Enter Correct Mail ID...";
	String LOGIN_VALIDATION_ERROR="invalid credentials, Please check and try again";
	String HASH_PASSWORD_MISMATCH="Enter password is wrong Please check and try Again!";
	String RESET_EMAIL_MISMATCH="Email not found, Please Enter the correct Email ID";
	String RESET_PASSWORD_MISMATCH="password and confirm password cannot be empty"
									+ " and both must be equal";
	String ERROR_URL = "Email Id Already Exists";
	String SUCCESS_URL = "Registration successfull, Please Login";
	String NOT_NULL = "Password cannot be Empty both	 must be equal!";
	String LOGIN_ERROR = "Email or Password is wrong";
	String QUERY = "from Student r where r.email=:email and r.password=:password";
	String EMAIL_CONSTRAINT_ERROR = "email already exists, please login";
	String EMAIL_QUERY = "select s.email from Student s where s.email = :email";
	String PROFILE_UPDATE_SUCCESS = "profile has been updated successully";
	String PROFILE_UPDATE_FAILURE = "profile update failed";
	String LOGOUT_STATUS = "Thank you, your account has been successfully logged out";
	String PASSWORD_RESET_QUERY="select r.email from Student r where r.email=:email";
	String PASSWORD_RESET_ERROR = "Invalid Student or Student not exists! Please use proper ID";
	String RESET_SUCCESS_MESSAGE = "password reset successful, please check your email and login";
	String SEARCH_QUERY = "select a from Student a where a.branch=:branch";
	String DELETE_QUERY = "select r.studentID from Student r where r.email=:email";
	String DELETE_SUCCESS = "Account has been Deleted Successfully ";
	String DELETE_ERROR = "Please Enter Correct Email ID";
	String CHANGE_PASSWORD_SUCCESS="Please enter the new password sent to your registered Email";
	String HQL_GET_DATA_QUERY="from Student r where r.email=:email and r.password=:password";
	String PASSWORD_RESET_UPDATE_QUERY="update Student r set r.password=:password, r.confirmPassword=:password where r.email=:email";
	String LOGIN_QUERY="from Student r where r.email=:email and r.password=:password";
	String UPDATE_QUERY="update Student s set s.address=:address,s.name=:name,s.number=:phone_number,s.dob=:dob,s.branch=:branch, s.gender=:gender where s.email=:email";
	String FAIL_LOGOUT_STATUS="Unable to Logout, Please wait..";
	String CHANGE_SUCCESS_MESSAGE="Password updated Successfully";
	String CHANGE_ERROR_MESSAGE="password Update Failed, Please Try Using Correct Credentials";
	String CHANGE_PASSWORD_QUERY="update Student s set s.password=:password, s.confirmPassword=:confirmPassword where s.email=:email";
	String DEACTIVATION_QUERY="update Student set active=:active where email=:email and password=:password";
	String DEACTIVATION_FAILED="Sorry Unable to Deactive, Please Try again";
	String DEACTIVATION_FAILURE_TO_LOGIN="Sorry Unable to Deactive, Please login Try again";
	String DEACTIVATION_SUCCESS="Your Account has been successfully deactivated..";
	String FAILED_STUDENT_LIST="Students Details";
	String SUCCESS_STUDENT_LIST="No Students Avalible";
	String SELECT_STUDENTS_QUERY="select r from Student r where r.active=:active ";
	String PASSWORD_MISMATCH="password and confirm password should be same";
	String ACTIVATION_SUCCESS="welcome back to SakhaSMS! your account has been activated successfully..";
	String ACTIVATION_QUERY="update Student r set active=:active where email=:email and password=:password";
	
	//DB SOURCES
	String DB_DRIVER="com.mysql.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost:3306/sakhatech";
	String DB_USER="root";
	String DB_PASSWORD="root";
	
	
	
}
