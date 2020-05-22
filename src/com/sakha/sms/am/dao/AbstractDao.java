package com.sakha.sms.am.dao;

import java.util.List;

import com.sakha.sms.am.model.*;

/**
 * @author Ravindra S Bankapur
 * @description : The AbstractDao class provides the empty implementation for
 *              all the unimplmented methods of StudentDao interface
 *              
 * @creation date:22-feb-2018 
 * @modified date:05-feb-2018
 *
 */
public abstract class AbstractDao implements StudentDao {

	@Override
	public boolean saveStudent(Student student) {
		return false;
	}

	@Override
	public int updateStudentProfile(Student student) {
		return 0;
	}

	@Override
	public int updateStudentPassword(Student student) {
		return 0;
	}

	@Override
	public boolean validateEmailDao(String email) {
		return false;
	}

	@Override
	public String resetPwdByEmail(String emailID, String randomPassword) {
		return null;
	}

	@Override
	public boolean resetStudentPassword(String emal, String password) {
		return false;
	}

	@Override
	public Student loginStudent(Student student) {
		return null;
	}

	@Override
	public List<Student> findStudentByBranch(Student student, String branch) {
		return null;
	}

	@Override
	public int deactivateStudent(Student student) {
		return 0;
	}

	@Override
	public boolean deleteStudentByEmail(String email) {
		return false;
	}

	@Override
	public List<Student> findAllStudents(Student student) {
		return null;
	}

	@Override
	public int activateStudent(Student student) {
		return 1;
	}
}
