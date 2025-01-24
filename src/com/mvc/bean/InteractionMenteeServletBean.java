package com.mvc.bean;

import java.util.List;

public class InteractionMenteeServletBean {
	private String mentor_email;
	private String mentee_uid;
	private static List<IntDateDetails> IntDateDetails;
	private String date;
	public String getMentor_email() {
		return mentor_email;
	}
	public void setMentor_email(String mentor_email) {
		this.mentor_email = mentor_email;
	}
	public String getMentee_uid() {
		return mentee_uid;
	}
	public void setMentee_uid(String mentee_uid) {
		this.mentee_uid = mentee_uid;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<IntDateDetails> getIntDateDetails() {
		return IntDateDetails;
	}
	public static void setIntDateDetails(List<IntDateDetails> intDateDetails) {
		IntDateDetails = intDateDetails;
	}
	
}
