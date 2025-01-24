<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="mentor_home.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Mentees</title>
<style>
#but {
	text-decoration: none;
	color: #EEE;
}
</style>
</head>
<body>
	<!-- ASIDE BAR START -->
	<aside
		class="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left"
		id="show-side-navigation1">
		<i class="uil-bars close-aside d-md-none d-lg-none"
			data-close="show-side-navigation1"></i>
		<div
			class="sidebar-header d-flex justify-content-center align-items-center px-3 py-5">
			<div class="ms-2">
				<h5 class="fs-6 mb-0">
					<a class="text-decoration-none" href="#"></a>
				</h5>
				<p class="mt-1 mb-0"></p>
			</div>
		</div>
		<ul class="categories list-unstyled">
			<li class=""><i class="uil-folder"></i><a href="MentorHome.jsp">Home</a>
			</li>
			<li class=""><i class="uil-folder"></i><a href="AddMentee.jsp">Mentees</a>
			</li>
			<li class=""><i class="uil-folder"></i><a
				href="MentorInteraction.jsp">Interaction</a></li>
			<li class=""><i class="uil-folder"></i><a
				href="MentorReport.jsp">View Interaction</a></li>
			<li class=""><i class="uil-folder"></i><a
				href="forgotPassword.jsp">Change Password</a></li>
		</ul>
		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="btn">
					<form action="LogoutServlet" method="post">
						<input type="submit" value="Logout" />
					</form>
				</div>
			</div>
		</div>
	</aside>

	<!-- NAVBAR START -->
	<section id="wrapper">
		<nav class="navbar navbar-expand-md">
			<div class="container-fluid mx-2">
				<div class="navbar-header">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#toggle-navbar"
						aria-controls="toggle-navbar" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="uil-bars text-white"></i>
					</button>
					<a class="navbar-brand" href="#">The <span class="main-color">Neotia</span>
						University
					</a>
				</div>
			</div>
		</nav>
		<!-- NAVBAR END -->

		<!-- MAIN CONTENT START -->
		<div class="p-4">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Add Mentee</h5>
					<div class="container">
						<form action="AddMenteeServlet" method="post">
							<br>
							<div class="row">
								<div class="col-lg-3">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">School</label>
										<div class="col-8">
											<select class="form-select"
												aria-label="Default select example" name="mentee_school"
												required>
												<option selected>Select</option>
												<option value="SST">SST</option>
												<option value="SAAS">SAAS</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-lg-3">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-5 col-form-label">Department</label>
										<div class="col-7">
											<select class="form-select"
												aria-label="Default select example" name="mentee_department"
												required>
												<option selected>Select</option>
												<option value="CSE">CSE</option>
												<option value="BCA">BCA</option>
												<option value="AGRICULTURE">AGRICULTURE</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">Mentee
											UID</label>
										<div class="col-6">
											<input type="text" class="form-control" id="colFormLabel"
												placeholder="Mentee UID" name="mentee_uid" required>
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-lg-4">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">Semester</label>
										<div class="col-6">
											<select name="semester" class="form-select"
												aria-label="Default select example" required>
												<option selected>Select</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="row">
									<div class="col-lg-6"></div>
									<div class="col-lg-4">
										<button type="submit" class="btn btn-outline-secondary">Add</button>
									</div>
									<div class="col-lg-4"></div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- CURRENT MENTEES SECTION START -->
		<div class="p-4">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Current Mentees</h5>
					<form action="MentorAddMenteeServlet" method="post">
						<div class="container">
							<div class="row">
								<div class="col-6"></div>
								<div class="col-1">
									<button type="submit" class="btn btn-outline-secondary">Load</button>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th scope="col"></th>
												<th scope="col">Name</th>
												<th scope="col">UID</th>
												<th scope="col">Mobile</th>
												<th scope="col">Email</th>
												<th scope="col">Semester</th>
												<th scope="col">Department</th>
											</tr>
										</thead>


										<tbody>
											<c:forEach items="${mentorDetailsList}" var="details">
												<tr>
													<td>${i}</td>
													<td>${details.mentee_name}</td>
													<td>${details.mentee_id}</td>
													<td>${details.mentee_mobile}</td>
													<td>${details.email}</td>
													<td>${details.semester}</td>
													<td>${details.department_name}</td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
		<!-- CURRENT MENTEES SECTION END -->
	</section>
	<!-- MAIN CONTENT END -->
</body>
</html>
