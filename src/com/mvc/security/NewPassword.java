package com.mvc.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mvc.security.Hash;
import com.mvc.util.DBConnection;



public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		String role = (String) session.getAttribute("role");
		Connection con = null;
		String password = "";
		
		RequestDispatcher dispatcher = null;
		
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
			Hash hash = new Hash();
			try {
				password = hash.hashString(newPassword);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			if (role.equals("mentor")){
				try {
					con = DBConnection.createConnection();
					PreparedStatement pst = con.prepareStatement("UPDATE mentoreg SET password_hash = ? WHERE email = ? ");
					pst.setString(1, password);
					pst.setString(2, (String) session.getAttribute("email"));

					int rowCount = pst.executeUpdate();
					if (rowCount > 0) {
						request.setAttribute("status", "resetSuccess");
						response.setContentType("text/html");
						out.print("<script>alert('Password change Successfull!');</script>");
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						rd.include(request, response);
					} else {
						request.setAttribute("status", "resetFailed");
						response.setContentType("text/html");
						out.print("<script>alert('Password change Successfull!');</script>");
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					}
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if (role.equals("mentee")) {
				try {
					con = DBConnection.createConnection();
					PreparedStatement pst = con.prepareStatement("UPDATE mentereg SET password_hash = ? WHERE email = ? ");
					pst.setString(1, password);
					pst.setString(2, (String) session.getAttribute("email"));

					int rowCount = pst.executeUpdate();
					if (rowCount > 0) {
						request.setAttribute("status", "resetSuccess");
						response.setContentType("text/html");
						out.print("<script>alert('Password change Successfull!');</script>");
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						rd.include(request, response);
					} else {
						request.setAttribute("status", "resetFailed");
						response.setContentType("text/html");
						out.print("<script>alert('Password change Successfull!');</script>");
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					}
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
			
		}
	}

}

