package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

/**
 * 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Page: LoginServlet");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		 LoginBean loginBean = new LoginBean();
		 
		//Using Java Beans - An easiest way to play with group of related data
		 loginBean.setEmail(email);
		 loginBean.setPassword(password);
		 loginBean.setRole(role);

		 LoginDao loginDao = new LoginDao();
		 
			//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String details = null;
		try {
			details = loginDao.loginDetails(loginBean);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		 PrintWriter out = response.getWriter();
		 
		 if(details.equals("SUCCESS") && ("mentor".equals(request.getParameter("role"))))   //On success, you can display a message to user on Home page
		 {
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("email", email);
			 System.out.println("Email in seassion: "+(String) session.getAttribute("email"));

			 RequestDispatcher rd = request.getRequestDispatcher("/MentorHome.jsp");
			 rd.forward(request, response);

		 }
		 else if(details.equals("SUCCESS") && ("mentee".equals(request.getParameter("role")))) {
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("email", email);
 
			 RequestDispatcher rd = request.getRequestDispatcher("/MenteeHome.jsp");
			 rd.forward(request, response);
		 }
		 else if(details.equals("Invalid Password")) {
				response.setContentType("text/html");
				out.print("<h1>Invalid Password!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response); 
		 }
		 
		 
		 else   //On Failure, display a meaningful message to the User.
		 {
			response.setContentType("text/html");
			out.print("<h1>No record found for this email and role</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
		 }
	}

}