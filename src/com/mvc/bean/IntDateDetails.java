package com.mvc.bean;

import java.util.List;

public class IntDateDetails {
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<IntDateDetails> getIntDateDetails() {
		return IntDateDetails;
	}
	public void setIntDateDetails(List<IntDateDetails> intDateDetails) {
		IntDateDetails = intDateDetails;
	}
	private List<IntDateDetails> IntDateDetails;
}
