package com.mvc.bean;

public class AddMenteeBean {
	 private String mentee_school;
	 private String mentee_department;
	 private String mentee_name;
	 private String mentee_uid;
	 private String mentee_email;
	 private String mentor_email;
	 private String semester;
	 private long mentee_mobile;
	 private String email;
	 
	public String getMentee_school() {
		return mentee_school;
	}
	public void setMentee_school(String mentee_school) {
		this.mentee_school = mentee_school;
	}
	public String getMentee_department() {
		return mentee_department;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSemester() {
		return semester;
	}
	
	public void setMentee_department(String mentee_department) {
		this.mentee_department = mentee_department;
	}
	public String getMentee_name() {
		return mentee_name;
	}
	public void setMentee_name(String mentee_name) {
		this.mentee_name = mentee_name;
	}
	public String getMentee_uid() {
		return mentee_uid;
	}
	public void setMentee_uid(String mentee_uid) {
		this.mentee_uid = mentee_uid;
	}
	public String getMentee_email() {
		return mentee_email;
	}
	public void setMentee_email(String mentee_email) {
		this.mentee_email = mentee_email;
	}
	public long getMentee_mobile() {
		return mentee_mobile;
	}
	public void setMentee_mobile(long mentee_mobile) {
		this.mentee_mobile = mentee_mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMentor_email() {
		return mentor_email;
	}
	public void setMentor_email(String mentor_email) {
		this.mentor_email = mentor_email;
	}
}