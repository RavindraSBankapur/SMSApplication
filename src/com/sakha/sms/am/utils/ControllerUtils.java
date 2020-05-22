package com.sakha.sms.am.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sakha.sms.am.model.*;

public class ControllerUtils {
	public static final Logger log=Logger.getLogger(ControllerUtils.class);
	public static String updatePasswordHashing(HttpServletRequest request)
	{
		String password=request.getParameter("oldPassword");
		return password;
	}
	public static Student hashPassword(HttpServletRequest request, Student student)
	{		
		
			String password=request.getParameter("password");
			StringBuilder hash = new StringBuilder();

			try {
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				byte[] hashedBytes = sha.digest(password.getBytes());
				char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
						'a', 'b', 'c', 'd', 'e', 'f' };
				for (int idx = 0; idx < hashedBytes.length; ++idx) {
					byte b = hashedBytes[idx];
					hash.append(digits[(b & 0xf0) >> 4]);
					hash.append(digits[b & 0x0f]);
				}
			} catch (NoSuchAlgorithmException e) {
				// handle error here.
			}
			String hashedPassword=hash.toString();
			student.setPassword(hashedPassword);
			student.setConfirmPassword(hashedPassword);
			
			return student;
		}
	
	
	public static boolean isPasswordNull(Student student, HttpServletRequest request) {
		String password = request.getParameter("password");
		String cpassword = request.getParameter("confirmPassword");
		if (password.equals(null) || cpassword.equals(null) || !password.equals(cpassword) ||password.isEmpty()||cpassword.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isPasswordEqual(Student student, HttpServletRequest request) {
		String password = request.getParameter("password");
		String cpassword = request.getParameter("confirmPassword");
		if (!password.equals(cpassword)) {
			return true;
		}
		return false;
	}

	public static boolean uploadFile(CommonsMultipartFile[] fileUpload, Student student) {
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {
				student.setFileName(aFile.getOriginalFilename());
				student.setData(aFile.getBytes());
			}
		}
		return true;
	}

	public static boolean isValidLoginCredential(String email, String password) {
		if (password.isEmpty() || email.isEmpty() || password.equals(null))
			return false;
		else
			return true;
	}
	public static String hashUpdatePassword(String password) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}
		String hashedPassword=hash.toString();
	
		return hashedPassword;
	}
}
