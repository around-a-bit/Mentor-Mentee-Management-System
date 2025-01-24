<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Login_css.css">
    <meta name="description">
    <title>Login</title>
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-in">
            <form action="LoginServlet" method="post" onsubmit="return validate()">
                <h1>Sign In</h1>
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <select name="role" required>
                    <option selected>Select Role</option>
                    <option value="mentor">Mentor</option>
                    <option value="mentee">Mentee</option>
                </select>
                <button type="submit">Sign In</button>
            </form>

            <form >
                <a href= "forgotPassword.jsp">Forgot Password?</a>
            </form>
        </div>

        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-right">
                    <h2>Welcome back!</h2>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>