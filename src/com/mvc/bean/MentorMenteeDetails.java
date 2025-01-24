package com.mvc.bean;

public class MentorMenteeDetails {

		private String mentee_id;
		private String mentee_name;
		private String department_name;
		private String school_name;
		private String semester;
		private String email;
		private Long mentee_mobile;
		
		
		public String getMentee_id() {
			return mentee_id;
		}

		public void setMentee_id(String mentee_id) {
			this.mentee_id = mentee_id;
		}

		public String getMentee_name() {
			return mentee_name;
		}

		public void setMentee_name(String mentee_name) {
			this.mentee_name = mentee_name;
		}

		public String getDepartment_name() {
			return department_name;
		}

		public void setDepartment_name(String department_name) {
			this.department_name = department_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSchool_name() {
			return school_name;
		}

		public Long getMentee_mobile() {
			return mentee_mobile;
		}
		
		public void setMentee_mobile(Long mentee_mobile) {
			this.mentee_mobile = mentee_mobile;
		}
		
		public void setSchool_name(String string) {
			// TODO Auto-generated method stub
			
		}

		public String getSemester() {
			return semester;
		}

		public void setSemester(String semester) {
			this.semester = semester;
		}


}
