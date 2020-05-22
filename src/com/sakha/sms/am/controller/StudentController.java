package com.sakha.sms.am.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.sakha.sms.am.service.StudentServiceImpl;
import com.sakha.sms.am.utils.Constants;
import com.sakha.sms.am.utils.ControllerUtils;
import com.sakha.sms.am.model.*;

/**
 * @author Ravindra S Bankapur
 * 
 * @Description : The class the controller for student model which perform the
 *              controlling actions for all the neccessory operation needed for
 *              student model
 * 
 * @methods :
 *          saveStudent(),loginStudent(),logoutStudent(),updateStudentProfile(),
 *          updateStudentPassword(),deleteStudent(),deactivateStudent(),
 *          activateStudent(),findStudentByBranch(),findAllStudents()
 * @param :HttpServletRequest,
 *            Student.
 * 
 * @creation Date: 23-02-2018
 * 
 * @Modified Date: 03-March-2018
 *
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/")
public class StudentController {
	@Autowired
	StudentServiceImpl service;
	final static ControllerUtils util = new ControllerUtils();
	// costant variables related to service URLs
	private static final String REGISTER_URL = "/register.do";
	private static final String LOGIN_URL = "/login.do";
	private static final String LOGOUT_URL = "/logout.do";
	private static final String UPDATE_PROFILE_URL = "/updateProfile.do";
	private static final String UPDATE_PASSWORD_URL = "/updatePassword.do";
	private static final String RESET_PASSWORD_URL = "/forgot.do";
	private static final String SEARCH_BY_BRANCH_URL = "/search.do";
	private static final String SEARCH_ALL_URL = "/view.do";
	private static final String DEACTIVATE_URL = "/deactive.do";
	private static final String DELETE_STUDENT_URL = "/delete.do";
	private static final Logger log = Logger.getLogger(StudentController.class);

	/**
	 * @author Ravidra Bankapur
	 * 
	 * @param :
	 *            HttpServletRequest
	 * @Description : Method is used to rendere the form data to the saveStudent
	 *              controller
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showUploadForm(HttpServletRequest request) {
		return "register";
	}

	/**
	 * @author Ravidra Bankapur
	 * @param :
	 *            Student, HttpServletRequest,CommonsMultipartFile
	 * @description : the method acts as a service to store the student information
	 *              into database, internally it will give a call to the save method
	 *              of service
	 *
	 */
	@RequestMapping(value = REGISTER_URL, method = RequestMethod.POST)
	public ModelAndView saveStudent(Student student, HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
		log.debug("debug :: registration controller");
		boolean isUploaded = ControllerUtils.uploadFile(fileUpload, student);
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		boolean isPasswordNull = ControllerUtils.isPasswordNull(student, request);
		boolean isPasswordEqual = ControllerUtils.isPasswordEqual(student, request);
		if (isPasswordNull) {
			return new ModelAndView("/register.jsp", "emptyPassword", Constants.NOT_NULL);
		} else {
			student = ControllerUtils.hashPassword(request, student);
			boolean saveService = service.saveStudent(student);
			if (saveService)
				return new ModelAndView("/login.jsp", "registrationSuccess", Constants.SUCCESS_URL);
			else
				return new ModelAndView("/register.jsp", "uniqueEmailError", Constants.EMAIL_CONSTRAINT_ERROR);
		}
	}

	/**
	 * @author Ravidra Bankapur
	 * @Description : The method is used to render the updateForm data to the update
	 *              service
	 * @param :
	 *            Student
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showUpdateForm(Student student) {
		return "updateProfile";
	}

	/**
	 * @author Ravidra Bankapur
	 * @description : The methods provides a service for updating the student model
	 *              which internally give a call to update method of service
	 * @param Student,
	 *            HttpServletRequest
	 */
	@RequestMapping(value = UPDATE_PROFILE_URL, method = RequestMethod.POST)
	public ModelAndView updateStudentProfile(Student student, HttpServletRequest request) {
		HttpSession session = request.getSession();
		log.debug("debug :: update profile controller");
		Student adminSession = (Student) session.getAttribute("student");
		try {
			int recordAffected = service.updateStudentProfile(student);
			if (recordAffected > 0) {
				return new ModelAndView("/welcome.jsp", "profile", Constants.PROFILE_UPDATE_SUCCESS);
			}
		} catch (HibernateException e) {
			log.error("debug :: update controller :" + e.getMessage());
		}
		return new ModelAndView("/update_profile.jsp", "message", Constants.PROFILE_UPDATE_FAILURE);
	}

	/**
	 * @author Ravidra Bankapur
	 * @Description : The method provides a service for updating the student
	 *              password which internally gives a call to updatemethos of
	 *              service
	 * @param :
	 *            Student, HttpServletRequest
	 *
	 */
	@RequestMapping(value = UPDATE_PASSWORD_URL, method = RequestMethod.POST)
	public ModelAndView updateStudentPassword(Student student, HttpServletRequest request) {
		log.debug("debug :: update password controller");
		HttpSession session = request.getSession();
		String formEmail = request.getParameter("email");
		String oldPassword = request.getParameter("oldPassword");
		String hashedUpdatePassword=ControllerUtils.hashUpdatePassword(oldPassword);
		student=ControllerUtils.hashPassword(request, student);
		String password = request.getParameter("password");
		String newPassword = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		Student adminSession = (Student) session.getAttribute("student");
		String dbPassword = adminSession.getPassword();
		String dbEmail = adminSession.getEmail();
		if (!password.equals(null) || !confirmPassword.equals(null) || !password.equals(confirmPassword)
				|| !confirmPassword.isEmpty() || !password.isEmpty()) {
			if (!formEmail.equals(dbEmail))
				return new ModelAndView("/update_password.jsp", "updateEmailFailure", Constants.RESET_EMAIL_MISMATCH);
			else if ((formEmail.equals(dbEmail))) {
				if (password.equals(null) || confirmPassword.equals(null) || !password.equals(confirmPassword)
						|| !(hashedUpdatePassword.equals(dbPassword))) {
					return new ModelAndView("/update_password.jsp", "updatePasswordFailure",
							Constants.RESET_PASSWORD_MISMATCH);
				} else {
					try {
						boolean updateStatus = service.updateStudentPassword(student);
						if (updateStatus) {
							return new ModelAndView("/welcome.jsp", "changeSuccess", Constants.CHANGE_SUCCESS_MESSAGE);
						}
					} catch (HibernateException e) {
						log.error("debug :: update password " + e.getMessage());
					}
				}
			}
		}
		session.invalidate();
		return new ModelAndView("/login.jsp", "changeFailure", Constants.CHANGE_ERROR_MESSAGE);
	}

	/**
	 * @author Ravidra S Bankapur
	 * @Description : The method is used to render the forgetpassword form data to
	 *              its service method
	 * @param :
	 *            HttpServletRequest
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showView(HttpServletRequest request) {
		return "forgot";
	}

	/**
	 * @author Ravidra Bankapur
	 * @Description : The method provides a service for resetting the student model
	 *              password which internally give a call to the updatepassword
	 *              method of service
	 * @param :
	 *            HttpServletRequest
	 */
	@RequestMapping(value = RESET_PASSWORD_URL, method = RequestMethod.POST)
	public ModelAndView resetStudentPassword(HttpServletRequest request) {
		log.debug("debug :: reset password controller ");
		String email = request.getParameter("email");
		boolean emailExists = service.validateStudentEmail(email);
		if (emailExists) {
			boolean res = service.resetPassword(email);
			try {
				if (res) {
					return new ModelAndView("/login.jsp", "PasswordResetSuccess", Constants.CHANGE_PASSWORD_SUCCESS);
				}
			} catch (Exception e) {
				log.error("debug :: reset password controller " + e.getMessage());
			}
		}
		return new ModelAndView("/forgotpassword.jsp", "passwordResetError", Constants.CHANGE_PASSWORD_ERROR);
	}

	/**
	 * @author Ravidra Bankapur
	 * @Description : The method provides a service for expiring the session by
	 *              invalidating it through the invalidate method
	 * @param :
	 *            HttpServletRequest, student
	 * 
	 */
	@RequestMapping(value = LOGOUT_URL, method = RequestMethod.GET)
	public ModelAndView logoutStudent(HttpServletRequest request, Student student) {
		log.debug("debug :: logout controller");
		HttpSession session = request.getSession();
		student = (Student) session.getAttribute("student");
		session.removeAttribute("student");
		session.invalidate();
		return new ModelAndView("/index.jsp", "lougoutSuccess", Constants.LOGOUT_STATUS);
	}

	/**
	 * @author Ravidra Bankapur
	 * @Description : The method is used to render the form data to the login
	 *              service method of controller
	 * @param :
	 *            HttpServletRequest
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginForm(HttpServletRequest request) {
		return "login";
	}

	/**
	 * @author Ravidra Bankapur
	 * @Deacription : the method acts as a service to perform login operation which
	 *              internally gives a call to the login methos of service
	 * @param :
	 *            HttpServletRequest, Student
	 */
	@RequestMapping(value = LOGIN_URL, method = RequestMethod.POST)
	public ModelAndView loginStudent(HttpServletRequest request, Student student) {
		log.debug("debug :: login conttroller ");
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(120000);
		String email = request.getParameter("email");
		student = ControllerUtils.hashPassword(request, student);
		String hashedPassword = student.getPassword();
		System.out.println("------------------------->>>>>"+hashedPassword);
			boolean validation = ControllerUtils.isValidLoginCredential(email, hashedPassword);
			if (validation) {
				Student studentDbRecord = service.loginStudent(student);
				if (studentDbRecord != null) {
					int accountStatus = studentDbRecord.getActive();
					if (accountStatus == 0) {
						activateStudent(studentDbRecord, request, session);
						return new ModelAndView("/welcome.jsp", "activated", Constants.ACTIVATION_SUCCESS);

					} else {
						session.setAttribute("student", studentDbRecord);
						return new ModelAndView("/welcome.jsp", "name", studentDbRecord);
					}
				} else {
					log.info("debug :: login error ");
					return new ModelAndView("/login.jsp", "loginError", Constants.LOGIN_ERROR);
				}
			} else {
				log.info("debug :: login error ");
				return new ModelAndView("/login.jsp", "validationFailed", Constants.LOGIN_VALIDATION_ERROR);
			}
		
	}

	/**
	 * @author Ravidra Bankapur
	 * @description : The method acts as a service for delete operation of student
	 *              model which internally gives a call to the delete method of
	 *              service
	 * @param :
	 *            HttpServletRequest
	 */
	@RequestMapping(value = DELETE_STUDENT_URL, method = RequestMethod.POST)
	public ModelAndView deleteStudent(HttpServletRequest request) {

		log.debug(" delete controller ");
		String email = request.getParameter("email");
		boolean deleteStatus = service.deleteStudentByEmail(email);
		try {
			if (deleteStatus)
				return new ModelAndView("/login.jsp", "deleteSuccess", Constants.DELETE_SUCCESS);
			else
				return new ModelAndView("/delete.jsp", "deleteError", Constants.DELETE_ERROR);
		} catch (HibernateException e) {
			log.error("debug login " + e.getMessage());
		}
		return null;
	}

	/**
	 * @author Ravidra Bankapur
	 * @The method is used to find the list of students present in database, it
	 *      returns list of student model if the students are found in the service
	 *      operation else it returns null
	 * @param :
	 *            Student, HttpServletRequest
	 */
	@RequestMapping(value = SEARCH_ALL_URL, method = RequestMethod.GET)
	public ModelAndView findAllStudents(Student student, HttpServletRequest request) {
		log.debug("debug :: search controller ");
		try {
			HttpSession session = null;
			session = request.getSession();
			Student adminSession = (Student) session.getAttribute("student");
			adminSession.getActive();
			adminSession.getStudentID();
			List<Student> studentRecordFromDB = service.findAllStudents(student);

			if (studentRecordFromDB != null)
				return new ModelAndView("/viewList.jsp", "studentList", studentRecordFromDB);
		} catch (HibernateException e) {
			log.error("debug :: search controller " + e.getMessage());

		}
		return new ModelAndView("/welcome.jsp", "noRecord", Constants.FAILED_STUDENT_LIST);
	}

	/**
	 * @author Ravidra Bankapur
	 * @description : the method is used to find the student object by the specified
	 *              branch if the students are found in the specified branch then it
	 *              returns the studcent object else it returns null
	 * @param :
	 *            Student, HttpServletRequest
	 *
	 */
	@RequestMapping(value = SEARCH_BY_BRANCH_URL, method = RequestMethod.POST)
	public ModelAndView findStudentByBranch(Student student, HttpServletRequest request) {
		log.debug("debug :: search student controller");
		String branch = request.getParameter("branch");
		List<Student> studentList = null;
		try {
			request.setAttribute("student", student);
			studentList = service.findStudentByBranch(student, branch);
			if (studentList != null)
				return new ModelAndView("/welcome.jsp", "lists", studentList);

		} catch (HibernateException e) {
			log.error("debug :: search student controller " + e.getMessage());
		}
		return null;
	}

	/**
	 * @author Ravidra Bankapur
	 * @description : The method is used to perform the softdelete operation, i.e
	 *              the method changes the accountStatus of student model to
	 *              inavtice status from active status whenevet studet wants to
	 *              delete the registered account
	 * @param :
	 *            Student, HttpServletRequest
	 *
	 */
	@RequestMapping(value = DEACTIVATE_URL, method = RequestMethod.POST)
	public ModelAndView deactiveStudent(Student student, HttpServletRequest request) {
		log.debug("debug :: deactivate controller ");
		try {
			HttpSession session = null;
			session = request.getSession();
			Student adminSession = (Student) session.getAttribute("student");
			String dbEmail = adminSession.getEmail();
			String dbPassword = adminSession.getPassword();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String hashedPassword=ControllerUtils.hashUpdatePassword(password);
			student.setPassword(hashedPassword);
			if (!dbEmail.equals(email) || !dbPassword.equals(hashedPassword)) {
				return new ModelAndView("/deactivate.jsp", "noMatchCredential", Constants.DEACTIVATION_FAILED);
			} else {
				boolean isActive = service.deactivateStudent(student);
				if (isActive) {
					return new ModelAndView("/thanks.jsp", "deactivationSuccess", Constants.DEACTIVATION_SUCCESS);
				}
			}
		} catch (HibernateException e) {
			log.error("deactivate controller " + e.getMessage());
		}
		return new ModelAndView("/login.jsp", "invalidDeactivateAttempt", Constants.DEACTIVATION_FAILED);
	}

	/**
	 * @author Ravidra Bankapur
	 * @param session2
	 * @description : The method is used to activat the student account once after
	 *              successful login, it changes the state of student model from
	 *              inactive state to active state by updating the record
	 * @param :
	 *            Student, HttpServletRequest
	 *
	 */
	// @RequestMapping(value = ACTIVATE_URL, method = RequestMethod.POST)
	public ModelAndView activateStudent(Student student, HttpServletRequest request, HttpSession session) {
		log.debug("activate student controller");
		try {
			Student adminSession = (Student) session.getAttribute("student");
			int studentID = adminSession.getStudentID();
			System.out.println(studentID);
			boolean isActive = service.activateStudent(student);
			if (isActive) {
				return new ModelAndView("/welcome.jsp", "activated", Constants.ACTIVATION_SUCCESS);
			}
		} catch (HibernateException e) {
			log.error("debug :: activate student controller " + e.getMessage());
		}
		return new ModelAndView("/welcome.jsp", "", Constants.DEACTIVATION_FAILED);
	}
}
