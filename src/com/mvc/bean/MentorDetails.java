package com.mvc.bean;

public class MentorDetails {
	private String mentor_name;
	private long mentor_mobile;
	private String mentor_email;
	private String joining_date;
	private String remarks;
	private String school_name;
	private String uid;
	private String department;
	public String getMentor_name() {
		return mentor_name;
	}
	public void setMentor_name(String mentor_name) {
		this.mentor_name = mentor_name;
	}
	public long getMentor_mobile() {
		return mentor_mobile;
	}
	public void setMentor_mobile(long mentor_mobile) {
		this.mentor_mobile = mentor_mobile;
	}
	public String getMentor_email() {
		return mentor_email;
	}
	public void setMentor_email(String mentor_email) {
		this.mentor_email = mentor_email;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}