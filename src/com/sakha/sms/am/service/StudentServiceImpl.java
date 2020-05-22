package com.sakha.sms.am.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakha.sms.am.controller.StudentController;
import com.sakha.sms.am.dao.StudentDao;
import com.sakha.sms.am.model.*;
import com.sakha.sms.am.utils.ControllerUtils;

/**
 * @author Ravindra S Bankapur
 * @description : The StudentServiceImpl gives implementation for all the
 *              unimplemented methods of StudentService
 * @creation date : 23-feb-2018
 * @modified date : 03-march-2018
 */
@SuppressWarnings("unused")
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao dao;
	@Autowired
	MailSender sender;
	private static final Logger log = Logger.getLogger(StudentServiceImpl.class);

	public StudentServiceImpl() {
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the saveStudent performs the database save operation related
	 *              to student model
	 *
	 */
	public boolean saveStudent(Student student) {
		return dao.saveStudent(student);
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the updateStudenProfile performs the database update operation
	 *              related to student model
	 *
	 */
	public int updateStudentProfile(Student student) {
		try {
			int recordAffected = dao.updateStudentProfile(student);
			return recordAffected;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the updateStudentPassword performs the database update
	 *              operation related to student model
	 *
	 */
	public boolean updateStudentPassword(Student student) {
		try {
			int rowsAffected = dao.updateStudentPassword(student);
			if (rowsAffected > 0) {
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the performs the database email validation operation related
	 *              to student model
	 *
	 */
	public boolean validateStudentEmail(String email) {
		return dao.validateEmailDao(email);
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the resetPassword method is used to perform password reset
	 *              operation and also it generates the random number password and
	 *              sends it to the respective email of student model in case i the
	 *              student user opt for password reset
	 *
	 */
	public boolean resetPassword(String email) {
		String password = ((String) UUID.randomUUID().toString().subSequence(0, 8));
		String hashedPassword=ControllerUtils.hashUpdatePassword(password);
		Boolean res = dao.resetStudentPassword(email, hashedPassword);
		Date date=new Date();
		try {
			if (res) {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setSentDate(date);
				mailMessage.setTo(email);
				mailMessage.setSubject("Password Reset Successful");
				mailMessage.setText("Dear user, \n \t"
						+ "Your Password is Successfully Reset By  Admin, to login with new Password follow the below Details:"
						+" \n\n"
						+ "UserName :" + email + "\n" + "Password :" + password
						+ " \n Click the Link for Login : http://192.198.43.115:8080/SakhaSMS/login.jsp"
						+ "\n\n Regards, \n  Sakhatech"
						+ mailMessage.getSentDate());
				sender.send(mailMessage);
				
				return true;
			}
		} catch (Exception e) {
			log.debug("reset password " + e.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the loginStudent used to perorm the login operation related to
	 *              student model
	 *
	 */
	public Student loginStudent(Student student) {
		return dao.loginStudent(student);
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the methos is used to the list of student model based on the
	 *              speicified branch or department
	 *
	 */

	public List<Student> findStudentByBranch(Student student, String branch) {
		List<Student> studentList = null;
		try {
			studentList = dao.findStudentByBranch(student, branch);
			return studentList;
		} catch (HibernateException e) {
			e.getMessage();
		}
		return Collections.emptyList();
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : The methos is used to delete the student model permnantly from
	 *              the database, it is called as hard delete, once the delete
	 *              operation is performed then the method completely removes
	 *              student object from tyhe database
	 *
	 */
	public boolean deleteStudentByEmail(String email) {
		try {
			return dao.deleteStudentByEmail(email);
		} catch (HibernateException e) {
			e.getMessage();
		}
		return false;
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the method is used to perform the softdelete operation, once
	 *              the user wishes to deactivate the student model it changes the
	 *              status of student object to inactive from active state
	 *
	 */
	public boolean deactivateStudent(Student student) {
		try {
			int rowsAffected = dao.deactivateStudent(student);
			if (rowsAffected > 0)
				return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the method is used to find the list of students from the
	 *              database based on the status of student object, only the lsit of
	 *              active students is displayed on the dashboard
	 *
	 */
	public List<Student> findAllStudents(Student student) {
		try {
			List<Student> recordFromDB = dao.findAllStudents(student);
			return recordFromDB;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author Ravindra S Bankapur
	 * @description : the method activates the student object to active status if
	 *              the student user accountStatus is inactive, i.e softdeleted
	 *              studend object is reactivated by calling this method, the method
	 *              is invoked while performing login operation
	 *
	 */
	public boolean activateStudent(Student student) {
		try {
			int rowsAffected = dao.activateStudent(student);
			if (rowsAffected > 0)
				return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

}
