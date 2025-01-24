package com.mvc.controller;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.mvc.bean.AddMenteeBean;
import com.mvc.dao.AddMenteeDao;
import com.mvc.seassionUtil.SessionUtil;


public class AddMenteeServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	public AddMenteeServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("\n\n servlet page");
		 String mentor_email = SessionUtil.getEmailFromSession(request);
		 String mentee_school = "";
		 String mentee_department = "";
		 String mentee_uid = "";
		 String mentee_email = "";
		 String semester = "";
		 
		 mentee_school = request.getParameter("mentee_school");
		 mentee_department = request.getParameter("mentee_department");
		 mentee_uid = request.getParameter("mentee_uid");
		 mentee_email = request.getParameter("mentee_email");
		 semester = request.getParameter("semester");
	
		 AddMenteeBean addMenteeBean = new AddMenteeBean();
		 
		 addMenteeBean.setMentee_school(mentee_school);
		 addMenteeBean.setMentee_department(mentee_department);
		 addMenteeBean.setMentee_uid(mentee_uid);
		 addMenteeBean.setMentee_email(mentee_email);
		 addMenteeBean.setMentor_email(mentor_email);
		 addMenteeBean.setSemester(semester);

		 
		 AddMenteeDao addMenteeDao = new AddMenteeDao();
		 String details = addMenteeDao.menteeDetails(addMenteeBean);
//		 PrintWriter out = response.getWriter();
		 if(details.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			 System.out.println("Success");
				response.setContentType("text/html");
				response.getWriter().print("<script>alert('Entry Successfull!');</script>");

			request.getRequestDispatcher("/AddMentee.jsp"); //to
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			request.setAttribute("errMessage", details);
			request.getRequestDispatcher("/SomethingWentWrong.jsp").forward(request, response); // from
		 }
	 }
}