package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.mvc.bean.MentorDetails;
import com.mvc.bean.MentorHomeBean;
import com.mvc.dao.MentorHomeDao;
import com.mvc.seassionUtil.SessionUtil;


public class MentorHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MentorHomeServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mentor_email = SessionUtil.getEmailFromSession(request);

        MentorHomeBean mentorHomeBean = new MentorHomeBean();
        String joining_date = "";
        String remarks = "";
        String check = request.getParameter("check");
        if(check != null) {
            joining_date = request.getParameter("joining_date");
    		remarks  = request.getParameter("remarks");
            mentorHomeBean.setRemarks(remarks);
            mentorHomeBean.setJoining_date(joining_date);
            mentorHomeBean.setCheck(check);
            mentorHomeBean.setMentor_email(mentor_email);
        }

        System.out.println("Page: MentorHomeServlet");
        
//        String mentor_email = (String) session.getAttribute("email");
//        System.out.println("Email_seassion: "+mentor_email);
        
        mentorHomeBean.setMentor_email(mentor_email);
     
        MentorHomeDao mentorHomeDao = new MentorHomeDao();


        // The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String Details = mentorHomeDao.mentorHomeDetails(mentorHomeBean, mentor_email);

        if (Details.equals("SUCCESS")) { // On success, you can display a message to user on Home page
            System.out.println("SUCCESS");
			  // Access interaction details from MentorHomeBean
			  List<MentorDetails> mentorDetailsList = mentorHomeBean.getMentorDetails();
			  // Store retrieved data in request attribute
			  request.setAttribute("mentorDetailsList", mentorDetailsList);
            
            
            
            request.getRequestDispatcher("/MentorHome.jsp").forward(request, response); // to
        } else { // On Failure, display a meaningful message to the User.
            request.setAttribute("errMessage", Details);
            request.getRequestDispatcher("/MentorHome.jsp").forward(request, response); // from
        }
    }
    
    
}