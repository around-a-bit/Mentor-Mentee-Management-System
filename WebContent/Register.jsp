<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Registration</title>
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-up">
        </div>
        <div class="form-container sign-in">
            <form action="RegisterServlet" method="post" name="form">
                <h1>Create Account</h1>
                <select name="school" required>
                    <option selected>School</option>
                    <option value="SAAS">SAAS</option>
                    <option value="SST">SST</option>
                </select>
                <select name="department" required>
                    <option selected>Department</option>
                    <option value="CSE">CSE</option>
                    <option value="BCA">BCA</option>
                    <option value="AGRICULTURE">AGRICULTURE</option>
                </select>
                <input type="text" placeholder="Name" name="name" required>
                <input type="email" placeholder="Email" name="email" required>
                <input type="password" placeholder="Password" name="password" required>
                <input type="text" placeholder="Mobile number" name="mobile" required>
                <input type="text" placeholder="Student UID/Faculty ID" name="uid" required>
                <select name="role" required>
                    <option selected>Role</option>
                    <option value="mentor">Mentor</option>
                    <option value="mentee">Mentee</option>
                </select>

                <div>
                <input style="background-color:#a20c0c; color: #fff; font-size: 12px; padding: 10px 45px; border: 1px solid transparent; border-radius: 8px; font-weight: 600; letter-spacing: 0.5px; text-transform: uppercase; margin-top: 10px; cursor: pointer;" type="submit" value="Register">
                </div>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-right">
                    <h2>Welcome!</h2>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
