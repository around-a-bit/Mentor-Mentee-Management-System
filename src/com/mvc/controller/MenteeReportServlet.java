package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.MenteeIntDetails;
import com.mvc.bean.MenteeReportBean;
import com.mvc.dao.MenteeReportDao;
import com.mvc.seassionUtil.SessionUtil;

public class MenteeReportServlet extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenteeReportServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 String int_date_mentee = request.getParameter("int_date_mentee");
		 System.out.println("Servlet Page");
		 MenteeReportBean menteeReportBean = new MenteeReportBean();
		 
		 menteeReportBean.setInt_date_mentee(int_date_mentee);

		 MenteeReportDao menteeReportDao = new MenteeReportDao();
		 HttpSession session = request.getSession();
		 
		String details = menteeReportDao.menteeReportDetails(menteeReportBean,session);
		 
		 if ("SUCCESS".equals(details)) { 

			  // Access interaction details from MenteeReportBean
			  List<MenteeIntDetails> menteeIntDetailsList = menteeReportBean.getMenteeIntDetails();
			  request.setAttribute("menteeIntDetailsList", menteeIntDetailsList); 
				RequestDispatcher rd = request.getRequestDispatcher("/MenteeReport.jsp");
				rd.include(request, response); 
			  
			} else {
				request.getRequestDispatcher("/NoDataFoundMentor.jsp").forward(request, response); // from
			}
	 }
}