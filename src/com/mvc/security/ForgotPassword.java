package com.mvc.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mvc.bean.ForgotPasswordBean;
import com.mvc.bean.LoginBean;
import com.mvc.dao.ForgotPasswordDao;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword") 

public class ForgotPassword extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		
		ForgotPasswordBean forgotPasswordBean = new ForgotPasswordBean();
		
		forgotPasswordBean.setEmail(email);
		forgotPasswordBean.setRole(role);
		
		ForgotPasswordDao forgotPasswordDao = new ForgotPasswordDao();
		
		 String details = null;
		try {
			details = forgotPasswordDao.emailDetails(forgotPasswordBean);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		 if(details.equals("SUCCESS") )  //On success, you can display a message to user on Home page
		 {
			 
			 RequestDispatcher dispatcher = null;
				int otpvalue = 0;
				HttpSession mySession = request.getSession();
				
				if(email!=null || !email.equals("")) {
					// sending otp
					Random rand = new Random();
					otpvalue = rand.nextInt(1255650);

					String to = email;// change accordingly
					// Get the session object
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");
					Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("academicmentorship738@gmail.com", "vpcy euyr qggc dcpn");// Put your email
																											// id and
																											// password here
						}
					});
					// compose message
					try {
						MimeMessage message = new MimeMessage(session);
						message.setFrom(new InternetAddress(email));// change accordingly
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						message.setSubject("Hello");
						message.setText("your OTP is: " + otpvalue);
						// send message
						Transport.send(message);
						System.out.println("message sent successfully");
					}

					catch (MessagingException e) {
						throw new RuntimeException(e);
					}
					dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
					request.setAttribute("message","OTP is sent to your email id");
					//request.setAttribute("connection", con);
					mySession.setAttribute("otp",otpvalue); 
					mySession.setAttribute("email",email); 
					mySession.setAttribute("role", role);
					dispatcher.forward(request, response);
					//request.setAttribute("status", "success");
				}

		 }
		 else if(details.equals("Email Not Found")) {
				response.setContentType("text/html");
				out.print("<h1>Email Not Found!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/forgotPassword.jsp");
				rd.include(request, response); 
		 }
		 
		 
		 else   //On Failure, display a meaningful message to the User.
		 {
			response.setContentType("text/html");
			out.print("<script>alert('No record found for this email and role!');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/forgotPassword.jsp");
			rd.include(request, response);
		 }
		
		
		
	}

}
