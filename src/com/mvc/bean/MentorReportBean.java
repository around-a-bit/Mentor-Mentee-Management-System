package com.mvc.bean;
import java.util.List;
public class MentorReportBean {
	private String mentee_uid;
	private String date;
	private String mentor_email;
	public String getMentor_email() {
		return mentor_email;
	}
	public void setMentor_email(String mentor_email) {
		this.mentor_email = mentor_email;
	}
	private List<Mentor_int_Details> mentor_int_Details;
	
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

	
	  // Getter method for interactionDetails
	  public List<Mentor_int_Details> getMentor_int_Details() {
	    return mentor_int_Details;
	  }
	    public void setMentor_int_Details(List<Mentor_int_Details> mentor_int_Details) {
	        this.mentor_int_Details = mentor_int_Details;
	    }
}