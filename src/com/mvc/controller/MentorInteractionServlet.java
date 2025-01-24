package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.mvc.bean.MentorInteractionBean;
import com.mvc.dao.MentorInteractionDao;
import com.mvc.seassionUtil.SessionUtil;


public class MentorInteractionServlet extends HttpServlet {
 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MentorInteractionServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Copying all the input parameters in to local variables
		 String mentor_email = SessionUtil.getEmailFromSession(request);
		 String uid = request.getParameter("uid");
		 String date = request.getParameter("date");
		 String interaction = request.getParameter("interaction");
		 String problem = request.getParameter("problem");
		 String remedy = request.getParameter("remedy");
		 String changes = request.getParameter("changes");
		 String cgpa = request.getParameter("cgpa");
		 String attendence = request.getParameter("attendance");
		 String id = request.getParameter("id");
		 String mentee_school = request.getParameter("mentee_school");
		 String mentee_department = request.getParameter("mentee_department");

	
		 MentorInteractionBean mentorInteractionBean = new MentorInteractionBean();
		 
		//Using Java Beans - An easiest way to play with group of related data
		 mentorInteractionBean.setUid(uid);
		 mentorInteractionBean.setDate(date);
		 mentorInteractionBean.setInteraction(interaction);
		 mentorInteractionBean.setProblem(problem);
		 mentorInteractionBean.setRemedy(remedy);
		 mentorInteractionBean.setChanges(changes);
		 mentorInteractionBean.setCgpa(cgpa);
		 mentorInteractionBean.setAttendance(attendence);
		 mentorInteractionBean.setId(id);
		 mentorInteractionBean.setMentee_school(mentee_school);
		 mentorInteractionBean.setMentee_department(mentee_department);
		 mentorInteractionBean.setMentor_email(mentor_email);
		 
		 
		 
		 MentorInteractionDao mentorInteractionDao = new MentorInteractionDao();
		 
		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String details;
			details = mentorInteractionDao.MentorInteractionDetails(mentorInteractionBean);
			 if(details.equals("SUCCESS"))   //On success, you can display a message to user on Home page
			 {
					response.setContentType("text/html");
					response.getWriter().print("<script>alert('Entry Successfull!');</script>");

				request.getRequestDispatcher("/MentorInteraction.jsp"); //to
			 }
			 else   //On Failure, display a meaningful message to the User.
			 {
				request.setAttribute("errMessage", details);
				request.getRequestDispatcher("/SomethingWentWrong.jsp").forward(request, response); // from
			 }

			 
	 }
}