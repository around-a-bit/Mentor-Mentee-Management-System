<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mentor-Mentee Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
		font-family: 'Montserrat', sans-serif;
	}
body {
	
	margin: 0;
	padding: 0;
	background: linear-gradient(to top, #f9ffcb 0%, #ffffff 100%);
}

h1 {
	color: #a20c0c;
	margin-bottom: 20px;
	text-align: center;
}

h4 {
	color: #010101;
	margin-bottom: 20px;
	text-align: center;
}
h5 {
	color: #010101;
	margin-bottom: 20px;
	text-align: center;
}

p {
	color: #a20c0c;
	margin-bottom: 20px;
	text-align: center;
}

.btn {
	background-color: #a20c0c;
	color: #ffffff;
	text-decoration: none;
	border-radius: 20px;
	text-align: center;
}


img {
	display: block;
	margin: 0 auto;
	max-width: 50%;
	height: auto;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ffffff;
	color: rgb(0, 0, 0);
}

th {
	background-color: #a20c0c;
	color: rgb(255, 255, 255);
}
</style>
</head>
<body>
	<div class="p-4">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarTogglerDemo03"
					aria-controls="navbarTogglerDemo03" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
					<div class="col-sm-1">
						<a class="btn" href="Login.jsp">Login</a>
					</div>
					<div class="col-sm-1">
						<a class="btn" href="Register.jsp">Register</a>
					</div>
				</div>
			</nav>
			<div class="row">
				<h1>
					THE <span style="color: rgb(0, 0, 0)">NEOTIA</span> UNIVERSITY
				</h1>
			</div>
			<div class="row">
				<img src="TNU.jpg" hight="600" width="600"
					alt="The Neotia University" />
			</div>
			<div class="row">
				<h1>Academic Mentorship Platform</h1>
			</div>
			<div class="row">
				<h5>Welcome to the platform where mentorship thrives!</h5>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table>
						<tr>
							<th><h4>Name</h4></th>
							<th><h4>UID</h4></th>
							<th><h4>Year</h4></th>
							<th><h4>Department</h4></th>
						</tr>
						<tr>
							<td><h6>Devwanti Chakraborty</h6></td>
							<td><h6>TNU2021020200025</h6></td>
							<td><h6>4th</h6></td>
							<td><h6>B.Tech in Computer Science and Engineering
								Specialization with Cyber Security</h6></td>
						</tr>
						<tr>
							<td><h6>Atanu Sur</h6></td>
							<td><h6>TNU2021020100048</h6></td>
							<td><h6>4th</h6></td>
							<td><h6>B.Tech in Computer Science and Engineering
								Specialization with Cyber Security</h6></td>
						</tr>
						<tr>
							<td><h6>Sankar Rajak</h6></td>
							<td><h6>TNU2021020100055</h6></td>
							<td><h6>4th</h6></td>
							<td>B.Tech in Computer Science and Engineering
								Specialization with Cyber Security</td>
						</tr>
					</table>
				</div>

			</div>
		</div>

	</div>


</body>
</html>
