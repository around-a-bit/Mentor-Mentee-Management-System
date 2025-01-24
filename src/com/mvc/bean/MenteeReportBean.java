package com.mvc.bean;

import java.util.List;

public class MenteeReportBean {
	private String int_date_mentee;
	private List<MenteeIntDetails> menteeIntDetails;

public String getInt_date_mentee() {
	return int_date_mentee;
}

public void setInt_date_mentee(String int_date_mentee) {
	this.int_date_mentee = int_date_mentee;
}

// Getter method for interactionDetails
public List<MenteeIntDetails> getMenteeIntDetails() {
  return menteeIntDetails;
}
  public void setMenteeIntDetails(List<MenteeIntDetails> menteeIntDetails) {
      this.menteeIntDetails = menteeIntDetails;
  }

}