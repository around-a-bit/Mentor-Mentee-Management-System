package com.mvc.bean;

import java.util.List;

public class MentorHomeBean {
    private String mentor_email;
    private String joining_date;
    private String remarks;
    private String check;
	private List<MentorDetails> mentorDetails;

	public List<MentorDetails> getMentorDetails() {
		return mentorDetails;
	}
	public void setMentorDetails(List<MentorDetails> mentorDetails) {
		this.mentorDetails = mentorDetails;
	}
	public String getMentor_email() {
		System.out.println("Page: MentorHome Bean");
		return mentor_email;
	}
	public void setMentor_email(String mentor_email) {
		System.out.println("Page: MentorHome bean: "+mentor_email);
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
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
}