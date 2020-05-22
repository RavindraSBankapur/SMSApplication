package com.sakha.sms.am.service;

import java.util.List;

import com.sakha.sms.am.model.*;

/**
 * @author Ravindra S Bankapur
 * @description : interface StudentService declares all the service methods required to
 *         perform the CRUD operation related to Student Model object
 * @creation date : 23-feb-2018
 * @modified dateW: 05-feb-2018
 */
public interface StudentService {
	public boolean saveStudent(Student student);

	public List<Student> findAllStudents(Student student);

	public int updateStudentProfile(Student student);

	public boolean updateStudentPassword(Student student);

	public Student loginStudent(Student loginDTO);

	public boolean deactivateStudent(Student studentDto);

	public boolean deleteStudentByEmail(String email);

	public List<Student> findStudentByBranch(Student studentDto, String branch);

}
