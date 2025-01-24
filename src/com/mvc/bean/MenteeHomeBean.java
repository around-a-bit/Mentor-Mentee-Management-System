package com.mvc.bean;

import java.util.List;

public class MenteeHomeBean {
	private String mentee_email;
	private List<MenteeDetails> menteeDetails;

	public List<MenteeDetails> getMenteeDetails() {
		return menteeDetails;
	}
	public void setMenteeDetails(List<MenteeDetails> menteeDetails) {
		this.menteeDetails = menteeDetails;
	}
	public String getMentee_email() {
		return mentee_email;
	}

	public void setMentee_email(String email) {
		this.mentee_email = email;
	}
}