package com.mvc.bean;

public class MenteeDetails {
	private String name;
	private String uid;
	private String school_name;
	private String department_name;
	private Long mobile;
	private String email;
	private String semester;
	private String mentor_name;
	private Long mentor_mobile;
	private String mentor_email;
	
	public String getMentor_email() {
		return mentor_email;
	}
	public void setMentor_email(String mentor_email) {
		this.mentor_email = mentor_email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMentor_name() {
		return mentor_name;
	}
	public void setMentor_name(String mentor_name) {
		this.mentor_name = mentor_name;
	}
	public Long getMentor_mobile() {
		return mentor_mobile;
	}
	public void setMentor_mobile(Long mentor_mobile) {
		this.mentor_mobile = mentor_mobile;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}

}