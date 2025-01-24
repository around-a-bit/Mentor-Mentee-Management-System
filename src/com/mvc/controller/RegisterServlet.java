package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;


public class RegisterServlet extends HttpServlet {
 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Copying all the input parameters in to local variables
		 String school = request.getParameter("school");
		 String department = request.getParameter("department");
		 String name = request.getParameter("name");
		 String uid = request.getParameter("uid");
		 String email = request.getParameter("email");
		 long mobile = Long.parseLong(request.getParameter("mobile"));
		 String password = request.getParameter("password");
		 String role = request.getParameter("role");
		 System.out.println("Servlet role: "+role);
		 String remarks = request.getParameter("remarks");
		 String date_of_joining = request.getParameter("date_of_joining");
		 System.out.println("Servlet Page");
		 PrintWriter out = response.getWriter();

	
		 RegisterBean registerBean = new RegisterBean();
		 
		//Using Java Beans - An easiest way to play with group of related data
		 registerBean.setSchool(school);
		 registerBean.setDepartment(department);
		 registerBean.setName(name);
		 registerBean.setUid(uid);
		 registerBean.setEmail(email);
		 registerBean.setMobile(mobile);
		 registerBean.setPassword(password);
		 registerBean.setRole(role);
		 registerBean.setRemarks(remarks);
		 registerBean.setDate_of_joining(date_of_joining);
		 RegisterDao registerDao = new RegisterDao();
		 
		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String details = null;
		try {
			details = registerDao.registerDetails(registerBean);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(details.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			request.getRequestDispatcher("/Successful.jsp").forward(request, response); //to
		 }
		 else if(details.equals("UID Already Exist"))   //On Failure, display a meaningful message to the User.
		 {
			 
				response.setContentType("text/html");
				out.print("<h1>User with this UID already exist</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
				RequestDispatcher rd1 = request.getRequestDispatcher("/adminRegister.jsp");
				rd.include(request, response);
				rd1.include(request, response);
		 }
	 }
}