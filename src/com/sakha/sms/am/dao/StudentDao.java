package com.sakha.sms.am.dao;

import java.util.List;

import com.sakha.sms.am.model.*;

/**
 * @author Ravindra S Bankapur
 * @description : The interface provides the method to perform the operations
 *              related to student model, The interface has two implementation
 *              classes AbstractDao and StudentDaoImpl
 *              
 * @creation date: 22-feb-2018
 * @modified date: 05-feb-2018
 * 
 * 
 *
 */
public interface StudentDao {

	public boolean saveStudent(Student student);

	public int updateStudentProfile(Student student);

	public int updateStudentPassword(Student student);

	public boolean validateEmailDao(String email);

	public String resetPwdByEmail(String emailID, String randomPassword);

	public boolean resetStudentPassword(String emal, String password);

	public Student loginStudent(Student student);

	public List<Student> findStudentByBranch(Student student, String branch);

	public int deactivateStudent(Student student);

	public boolean deleteStudentByEmail(String email);

	public List<Student> findAllStudents(Student student);

	public int activateStudent(Student student);

}
