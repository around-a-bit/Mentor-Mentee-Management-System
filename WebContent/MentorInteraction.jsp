<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<link rel="stylesheet" href="mentor_home.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Interaction</title>
<style>
#but {
	text-decoration: none;
	color: #EEE;
}
</style>
</head>
<body>
	<!-- ASIDE BER END-->
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
	<!-- NAV BER END -->
	<section id="wrapper">
		<nav class="navbar navbar-expand-md">
			<!-- <div class="container-fluid mx-2"> -->
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
		</nav>
		<!-- NAV BER END -->
		<form action="MentorInteractionServlet" method="post">
			<div class="p-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Choose Mentee</h5>
						<div class="container ">
							<div class="row">

								<div class="col-lg-6">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">School</label>
										<div class="col-4">
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

								<div class="col-lg-6">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">Department</label>
										<div class="col-4">
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

								<br>
								<br>

								<div class="col-lg-6">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">Mentee
											UID</label>
										<div class="col-4">
											<input name="uid" type="text" class="form-control"
												id="colFormLabel" placeholder="Mentee UID" required>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="p-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Interaction</h5>
						<div class="container ">

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Mentor
											id</label>
										<div class="col-10">
											<input name="id" type="text" class="form-control"
												id="colFormLabel" placeholder="Mentor ID" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Select
											Date</label>
										<div class="col-12">
											<input name="date" type="date" class="form-control"
												id="colFormLabel" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-6 col-form-label">Attendance</label>
										<div class="col-12">
											<input name="attendance" type="text" class="form-control"
												id="colFormLabel" placeholder="Attendance" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-6 col-form-label">CGPA</label>
										<div class="col-12">
											<input name="cgpa" type="text" class="form-control"
												id="colFormLabel" placeholder="CGPA" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-6 col-form-label">Interaction</label>
										<div class="col-12">
											<input name="interaction" type="text" class="form-control"
												id="colFormLabel" placeholder="Interaction data" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-6 col-form-label">Problem
											Understood</label>
										<div class="col-12">
											<input name="problem" type="text" class="form-control"
												id="colFormLabel" placeholder="Problem Understood" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-6 col-form-label">Remedial
											Action taken</label>
										<div class="col-12">
											<input name="remedy" type="text" class="form-control"
												id="colFormLabel" placeholder="Remedy" required>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-6 col-form-label">Changes
											Observed</label>
										<div class="col-12">
											<input name="changes" type="text" class="form-control"
												id="colFormLabel" placeholder="Changes Observed" required>
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="container">
								<div class="row">
									<div class="col-lg-6"></div>
									<div class="col-lg-4">
										<button type="submit" class="btn btn-outline-secondary">Submit</button>
									</div>
									<div class="col-lg-4"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>