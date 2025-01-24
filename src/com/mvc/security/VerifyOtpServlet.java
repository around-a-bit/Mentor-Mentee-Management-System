package com.mvc.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyOtpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String otp = request.getParameter("otp");
        HttpSession session = request.getSession();
        String generatedOtp = (String) session.getAttribute("otp");

        if (otp.equals(generatedOtp)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }
    }
}
