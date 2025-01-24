
package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.MentorAddMenteeBean;
import com.mvc.bean.MentorMenteeDetails;
import com.mvc.util.DBConnection;

public class MentorAddMenteeDao {

    public List<MentorMenteeDetails> mentorMenteeDetails(MentorAddMenteeBean mentorAddMenteeBean) {
        System.out.println("Page: MentorAddMenteeDao");
        System.out.println("0");
        String mentor_email = mentorAddMenteeBean.getMentor_email();
        ResultSet resultSet = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        List<MentorMenteeDetails> mentorMenteeDetailsList = new ArrayList<>();

        try {
            
            con = DBConnection.createConnection();
            String query = "SELECT m.mentee_id, m.email, m.mentor_email, m.school_name, " +
                    "m.department_name, m.semester, me.name, me.mobile " +
                    "FROM mentee m " +
                    "INNER JOIN mentereg me ON m.email = me.email " +
                    "WHERE m.mentor_email = ?";

            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, mentor_email);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MentorMenteeDetails mentorMenteeDetails = new MentorMenteeDetails();
                mentorMenteeDetails.setDepartment_name(resultSet.getString("department_name"));
                mentorMenteeDetails.setSchool_name(resultSet.getString("school_name"));
                mentorMenteeDetails.setSemester(resultSet.getString("semester"));
                mentorMenteeDetails.setMentee_id(resultSet.getString("mentee_id"));
                mentorMenteeDetails.setEmail(resultSet.getString("email"));
                mentorMenteeDetails.setMentee_name(resultSet.getString("name"));
                mentorMenteeDetails.setMentee_mobile(resultSet.getLong("mobile"));
                mentorMenteeDetailsList.add(mentorMenteeDetails);
            }

            

            return mentorMenteeDetailsList;

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
