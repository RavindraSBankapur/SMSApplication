package com.sakha.sms.am.dao;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sakha.sms.am.model.*;
import com.sakha.sms.am.service.StudentServiceImpl;
import com.sakha.sms.am.utils.Constants;
import com.sakha.sms.am.utils.HibernateUtils;

/**
 * @author Ravindra S Bankapur
 * @description : class StudentDaoImpl is child class of AbstractDao gives
 *              implements all the unimplemented methods of StudentDao which are
 *              used to perform the crud operations related to the student model
 * @creation date : 23-feb-2018
 * @modified date : 05-feb-2018
 * 
 */
@Repository
@Transactional
public class StudentDaoImpl extends AbstractDao implements StudentDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(StudentDaoImpl.class);
	
	public StudentDaoImpl() {
	}

	public boolean saveStudent(Student student) {
		log.debug("save dao");
		//Session session = HibernateUtils.getSession();
		if(student.getEmail()!=null) {
		Session session = sessionFactory.openSession();
		Object query = session.createQuery(Constants.EMAIL_QUERY).setParameter("email", student.getEmail())
				.uniqueResult();
		if (query == null) {
			Transaction txn = session.beginTransaction();
			session.save(student);
			txn.commit();
			return true;
		}}
		return false;
	}

	public int deactivateStudent(Student student) {
		student.setActive(0);
		log.debug("deactivate dao");
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = (Query) session.createQuery(Constants.DEACTIVATION_QUERY);
			query.setParameter("email", student.getEmail());
			query.setParameter("password", student.getPassword());
			query.setParameter("active", student.getActive());
			System.out.println("Query" + query);
			int rowAffect = query.executeUpdate();
			transaction.commit();
			return rowAffect;
		} catch (HibernateException e) {
		log.error("deactivate dao "+e.getMessage());
		}
		return 0;
	}

	public int activateStudent(Student studentDto) {
		log.debug("activate dao");
		studentDto.setActive(1);
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = (Query) session.createQuery(Constants.DEACTIVATION_QUERY);
			query.setParameter("email", studentDto.getEmail());
			query.setParameter("number", studentDto.getPhoneNumber());
			query.setParameter("active", studentDto.getActive());
			System.out.println("Query" + query);
			int rowAffect = query.executeUpdate();
			transaction.commit();
			return rowAffect;
		} catch (HibernateException e) {
			log.error("activate dao "+e.getMessage());
		}
		return 0;
	}

	public boolean deleteStudentByEmail(String email) {
		Session session = null;
		log.debug("delete dao");
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(Constants.DELETE_QUERY);
			query.setParameter("email", email);
			Object id1 = query.uniqueResult();
			if (id1 != null) {
				int id = Integer.parseInt(id1.toString());
				Transaction transaction = session.beginTransaction();
				Student DtoFromDB = session.get(Student.class, id);
				if (Objects.nonNull(DtoFromDB)) {
					session.delete(DtoFromDB);
				}
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (HibernateException e) {
			log.error("delete dao "+e.getMessage());
		}
		return false;
	}

	public List<Student> findStudentByBranch(Student studentDto, String branch) {
		log.debug("search dao");
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(Constants.SEARCH_QUERY);
			query.setParameter("branch", branch);
			@SuppressWarnings("unchecked")
			List<Student> list = query.list();
			return list;
		} catch (HibernateException e) {
			log.error("search dao "+e.getMessage());
		}
		return Collections.emptyList();
	}

	public Student loginStudent(Student student) {
		log.debug("login dao");
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(Constants.LOGIN_QUERY);
			query.setParameter("email", student.getEmail());
			query.setParameter("password", student.getPassword());
			Student dtofromDB = (Student) query.uniqueResult();
			return dtofromDB;
		} catch (HibernateException e) {
			log.debug("login dao "+e.getMessage());
			return null;
		}
	}

	public boolean validateEmailDao(String email) {
		log.debug("validate email dao"); 
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query qry = session.createQuery(Constants.PASSWORD_RESET_QUERY);
		qry.setParameter("email", email);
		String emailID = (String) qry.uniqueResult();
		if (emailID != null)
			return true;
		else
			return false;
	}

	public boolean resetStudentPassword(String email, String password) {
		/* String hql = "select r.email from Student r where r.email=:em"; */
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
		log.debug("passwordreset dao");
			Query query = session.createQuery(Constants.PASSWORD_RESET_QUERY);
			query.setParameter("email", email);
			String student = (String) query.uniqueResult();
			if (student != null) {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				Query query1 = session.createQuery(Constants.PASSWORD_RESET_UPDATE_QUERY);
				query1.setParameter("password", password);
				query1.setParameter("email", email);
				query1.executeUpdate();
				transaction.commit();
				return true;
			} else {
				return false;
			}

		} catch (HibernateException e) {
			log.error("reset password dao"+e.getMessage());
			transaction.rollback();
		}
		return false;
	}

	public int updateStudentPassword(Student student) {
		log.debug("update password dao");
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = (Query) session.createQuery(Constants.CHANGE_PASSWORD_QUERY);
			query.setParameter("email", student.getEmail());
			query.setParameter("password", student.getPassword());
			query.setParameter("confirmPassword", student.getConfirmPassword());
			int rowsAffected = query.executeUpdate();
			transaction.commit();
			System.err.println(rowsAffected);
			if (rowsAffected > 0)
				return rowsAffected;
		} catch (HibernateException e) {
			log.error("update password dao"+e.getMessage());
		}
		return 0;
	}

	public int updateStudentProfile(Student student) {
		log.debug("update profile dao");
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = (Query) session.createQuery(Constants.UPDATE_QUERY);
			query.setParameter("name", student.getName());
			query.setParameter("branch", student.getBranch());
			query.setParameter("email", student.getEmail());
			query.setParameter("phone_number", student.getPhoneNumber());
			query.setParameter("gender", student.getGender());
			query.setParameter("dob", student.getDob());
			query.setParameter("address", student.getAddress());
			int rowAffect = query.executeUpdate();
			transaction.commit();
			return rowAffect;
		} catch (HibernateException e) {
			log.error("update profile dao "+e.getMessage());
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents(Student student) {
		log.debug("search all dao");
		try {
			Session session = sessionFactory.openSession();
			// Transaction transaction = session.beginTransaction();
			Query query = (Query) session.createQuery(Constants.SELECT_STUDENTS_QUERY);
			query.setParameter("active", student.getActive());
			List<Student> recordFromDB = query.list();
			System.out.println(recordFromDB);
			return recordFromDB;
		} catch (HibernateException e) {
			log.error("search all dao "+e.getMessage());
		}
		return null;
	}

}
