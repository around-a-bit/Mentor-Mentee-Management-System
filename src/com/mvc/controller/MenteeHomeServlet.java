package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.MenteeHomeBean;
import com.mvc.bean.MenteeDetails;
import com.mvc.dao.MenteeHomeDao;
import com.mvc.seassionUtil.SessionUtil;

public class MenteeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenteeHomeServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("Servlet Page");
		 String mentee_email = SessionUtil.getEmailFromSession(request);

	        System.out.println("Page: MenteeHomeServlet");
		 
		 MenteeHomeBean menteeHomeBean = new MenteeHomeBean();
		 menteeHomeBean.setMentee_email(mentee_email);
		 MenteeHomeDao menteeHomeDao = new MenteeHomeDao();
		 
	        // The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String Details = menteeHomeDao.menteeHomeDetails(menteeHomeBean);

	        if (Details.equals("SUCCESS")) { // On success, you can display a message to user on Home page
	            System.out.println("SUCCESS");

				  List<MenteeDetails> menteeDetailsList = menteeHomeBean.getMenteeDetails();
				  // Store retrieved data in request attribute
				  request.setAttribute("menteeDetailsList", menteeDetailsList);
	            request.getRequestDispatcher("/MenteeHome.jsp").forward(request, response);
	            

	            // to
	        } else { // On Failure, display a meaningful message to the User.
	            request.setAttribute("errMessage", Details);
	            request.getRequestDispatcher("/MenteeHome.jsp").forward(request, response); // from
	        }

	 }
}