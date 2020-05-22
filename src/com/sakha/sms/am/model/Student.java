package com.sakha.sms.am.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "SAKHA_STUDENTS")
public class Student implements Serializable {
	@Id
	@GenericGenerator(name = "stud_id", strategy = "sequence")
	@GeneratedValue(generator = "stud_id")
	@Column(name = "student_id")
	private int studentID;
	@Column(name = "email")
	private String email;
	@Column(name = "name")	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_number")
	private String number;
	@Column(name = "dob")
	private String dob;
	@Column(name = "branch")
	private String branch;
	@Column(name = "gender")
	private String gender;
	@Column(name = "password")
	private String password;
	@Column(name = "confirmPassword")
	private String confirmPassword;
	@Column(name = "accountStatus")
	private int active=1;

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	@Column(name = "file_name")
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_data")
	private byte[] data;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return number;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.number = phoneNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", email=" + email + ", name=" + name + ", address=" + address
				+ ", number=" + number + ", dob=" + dob + ", branch=" + branch + ", gender=" + gender + "]";
	}
}
