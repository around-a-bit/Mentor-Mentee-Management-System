package com.mvc.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;

public class SendOtpServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");

    // Generate OTP
    Random rand = new Random();
    int otp = rand.nextInt(999999);

    // Send OTP to email
    String host = "**YOUR_SMTP_SERVER_HOSTNAME**"; // Replace with your actual hostname
    String user = "academicmentorship738@gmail.com"; // Replace if needed
    String pass = "AcademicMentorship@123"; // Replace if needed
    String to = email;
    String subject = "OTP for Registration";
    String message = "Your OTP is: " + otp;

    Properties props = System.getProperties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(props, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pass);
      }
    });

    try {
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(user));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Or use CC/BCC
      msg.setSubject(subject);
      msg.setText(message);
      Transport.send(msg);
    } catch (MessagingException e) {
      e.printStackTrace();
    }

    // Store OTP in session
    request.getSession().setAttribute("otp", otp);
    response.getWriter().println("OTP sent successfully!");
  }
}