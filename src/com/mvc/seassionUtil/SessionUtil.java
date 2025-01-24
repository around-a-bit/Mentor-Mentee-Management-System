package com.mvc.seassionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession(false);
    }

    public static String getEmailFromSession(HttpServletRequest request) {
        HttpSession session = getSession(request);
        System.out.println("Seassion page.");
        System.out.println((String) session.getAttribute("email"));
        return (String) session.getAttribute("email");
    }
}

