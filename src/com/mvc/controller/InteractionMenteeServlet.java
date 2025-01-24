package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.IntDateDetails;
import com.mvc.bean.InteractionMenteeServletBean;
import com.mvc.bean.MentorDetails;
import com.mvc.dao.InteractionMenteeServletDao;
import com.mvc.seassionUtil.SessionUtil;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InteractionMenteeServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	public InteractionMenteeServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("\n\n servlet page");
		 String mentor_email = SessionUtil.getEmailFromSession(request);
		 String mentee_uid = request.getParameter("mentee_uid");
		 
		 InteractionMenteeServletBean interactionMenteeServletBean = new InteractionMenteeServletBean();
		 interactionMenteeServletBean.setMentee_uid(mentee_uid);
		 interactionMenteeServletBean.setMentor_email(mentor_email);
		 
		 InteractionMenteeServletDao interactionMenteeServletDao = new InteractionMenteeServletDao();
		 String details = interactionMenteeServletDao.dateDetails(interactionMenteeServletBean);

		 if(details.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			 System.out.println("SUCCESS");
			  
			  List<IntDateDetails> intDateDetailsList = interactionMenteeServletBean.getIntDateDetails();
			 
			  request.setAttribute("intDateDetailsList", intDateDetailsList);
           
           
           
           request.getRequestDispatcher("/MentorReport.jsp").forward(request, response);
			
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			request.setAttribute("errMessage", details);
			request.getRequestDispatcher("/SomethingWentWrong.jsp").forward(request, response); // from
		 }
	 }
}
