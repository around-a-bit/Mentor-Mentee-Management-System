
package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.MentorAddMenteeBean;
import com.mvc.bean.MentorMenteeDetails;
import com.mvc.dao.MentorAddMenteeDao;
import com.mvc.seassionUtil.SessionUtil;

public class MentorAddMenteeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MentorAddMenteeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Page: MentorAddMenteeServlet");
        String mentor_email = SessionUtil.getEmailFromSession(request);

        MentorAddMenteeBean mentorAddMenteeBean = new MentorAddMenteeBean();
        mentorAddMenteeBean.setMentor_email(mentor_email);

        MentorAddMenteeDao mentorAddMenteeDao = new MentorAddMenteeDao();
        List<MentorMenteeDetails> mentorDetailsList = mentorAddMenteeDao.mentorMenteeDetails(mentorAddMenteeBean);

        request.setAttribute("mentorDetailsList", mentorDetailsList);
        request.getRequestDispatcher("/AddMentee.jsp").forward(request, response);
    }
}

