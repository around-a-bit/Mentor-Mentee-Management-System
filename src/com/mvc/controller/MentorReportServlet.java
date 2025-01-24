package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import com.mvc.bean.MentorReportBean;
import com.mvc.bean.Mentor_int_Details;
import com.mvc.dao.MentorReportDao;
import com.mvc.seassionUtil.SessionUtil;

/**
 * 
 */
public class MentorReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MentorReportServlet() {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mentor_email = SessionUtil.getEmailFromSession(request);
		String mentee_uid = request.getParameter("mentee_uid");
		String date = request.getParameter("date");
		MentorReportBean mentorReportBean = new MentorReportBean();
		 
		//Using Java Beans - An easiest way to play with group of related data
		mentorReportBean.setMentee_uid(mentee_uid);
		mentorReportBean.setDate(date);
		mentorReportBean.setMentor_email(mentor_email);
		
		
		MentorReportDao mentorReportDao = new MentorReportDao();
		HttpSession session = request.getSession();
		 
			//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String details = mentorReportDao.mentorReportDetails(mentorReportBean,session);
		 System.out.println("details: "+details);
		 if ("SUCCESS".equals(details)) { 

			  // Access interaction details from MentorReportBean
			  List<Mentor_int_Details> mentor_int_DetailsList = mentorReportBean.getMentor_int_Details();
			  // Store retrieved data in request attribute
			  request.setAttribute("mentor_int_DetailsList", mentor_int_DetailsList); 
			  // Forward to JSP page
			  RequestDispatcher rd = request.getRequestDispatcher("MentorReport.jsp");
			  rd.forward(request, response);
			  
			} else {
				request.getRequestDispatcher("/NoDataFoundMentor.jsp").forward(request, response); // from
			}

	}

}