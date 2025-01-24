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
<title>View Interaction</title>
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
		<!-- NAV BER END -->
		<form action="InteractionMenteeServlet" method="post">
			<div class="p-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Enter Mentee UID to see Previous Interaction Dates</h5>
						<div class="container ">
							<div class="row">

								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Mentee UID</label>
										<div class="col-4">
											<input type="text" class="form-control" id="colFormLabel"
												placeholder="Mentee UID" name="mentee_uid" required>
										</div>
										<div class="col-lg-6">
											<button type="submit" class="btn btn-outline-secondary">Submit</button>
										</div>
									</div>
								</div>

							</div>
                            <div class="row">
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th scope="col"></th>
												<th scope="col"></th>
											</tr>
										</thead>


										<tbody>
											<c:forEach items="${intDateDetailsList}" var="details" varStatus="status">
												<tr>
												
													<td>${status.index + 1}</td>
													<td>${details.date}</td>

												</tr>
											</c:forEach>
										</tbody>






									</table>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>


			<div class="p-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Basic Mentee Details</h5>
						<div class="container ">

							<br>
							<div class="row">
								<div class="col-lg-2">Mentee Name</div>
								:
								<div class="col-lg-4">
									<c:if test="${not empty mentor_int_DetailsList}">
										<c:forEach var="name" items="${mentor_int_DetailsList}">
											<c:out value="${name.name}" escapeXml="false" />
											<br>
										</c:forEach>
									</c:if>
									<c:if test="${empty mentor_int_DetailsList}">
										<c:out value="No Interaction details found." />
									</c:if>
									<c:if test="${not empty mentor_int_Details}">
										<c:out value="${mentor_int_Details.interaction}"
											escapeXml="false" />
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">Mentee UID</div>
								:
								<div class="col-lg-4">
									<c:if test="${not empty mentor_int_DetailsList}">
										<c:forEach var="uid_mentee" items="${mentor_int_DetailsList}">
											<c:out value="${uid_mentee.uid_mentee}" escapeXml="false" />
											<br>
										</c:forEach>
									</c:if>
									<c:if test="${empty mentor_int_DetailsList}">
										<c:out value="No Interaction details found." />
									</c:if>
									<c:if test="${not empty mentor_int_Details}">
										<c:out value="${mentor_int_Details.interaction}"
											escapeXml="false" />
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">Semester</div>
								:
								<div class="col-lg-4">
									<c:if test="${not empty mentor_int_DetailsList}">
										<c:forEach var="semester" items="${mentor_int_DetailsList}">
											<c:out value="${semester.semester}" escapeXml="false" />
											<br>
										</c:forEach>
									</c:if>
									<c:if test="${empty mentor_int_DetailsList}">
										<c:out value="No Interaction details found." />
									</c:if>
									<c:if test="${not empty mentor_int_Details}">
										<c:out value="${mentor_int_Details.interaction}"
											escapeXml="false" />
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">Department</div>
								:
								<div class="col-lg-4">
									<c:if test="${not empty mentor_int_DetailsList}">
										<c:forEach var="department" items="${mentor_int_DetailsList}">
											<c:out value="${department.name_department}"
												escapeXml="false" />
											<br>
										</c:forEach>
									</c:if>
									<c:if test="${empty mentor_int_DetailsList}">
										<c:out value="No Interaction details found." />
									</c:if>
									<c:if test="${not empty mentor_int_Details}">
										<c:out value="${mentor_int_Details.interaction}"
											escapeXml="false" />
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">Latest CGPA</div>
								:
								<div class="col-lg-4">
									<c:if test="${not empty mentor_int_DetailsList}">
										<c:forEach var="cgpa" items="${mentor_int_DetailsList}">
											<c:out value="${cgpa.cgpa}" escapeXml="false" />
											<br>
										</c:forEach>
									</c:if>
									<c:if test="${empty mentor_int_DetailsList}">
										<c:out value="No Interaction details found." />
									</c:if>
									<c:if test="${not empty mentor_int_Details}">
										<c:out value="${mentor_int_Details.interaction}"
											escapeXml="false" />
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">Attendance</div>
								:
								<div class="col-lg-4">
									<c:if test="${not empty mentor_int_DetailsList}">
										<c:forEach var="attendance" items="${mentor_int_DetailsList}">
											<c:out value="${attendance.attendance}" escapeXml="false" />
											<br>
										</c:forEach>
									</c:if>
									<c:if test="${empty mentor_int_DetailsList}">
										<c:out value="No Interaction details found." />
									</c:if>
									<c:if test="${not empty mentor_int_Details}">
										<c:out value="${mentor_int_Details.interaction}"
											escapeXml="false" />
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
            </form>

            <form action="MentorReportServlet" method="post">
			<div class="p-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Interaction Report</h5>
						<div class="container ">
							<div class="row">
								<div class="col-lg-12  ">
									<div class="form-group row">
                                        <div class="col-4">
                                            <label for="colFormLabel" class="col-sm-4 col-form-label">Mentee UID</label>
											<input type="text" class="form-control" id="colFormLabel"
												placeholder="Mentee UID" name="mentee_uid" required>
										</div>
										<label for="colFormLabel" class="col-sm-1 col-form-label">Select
											Date</label>
										<div class="col-lg-2">
											<input name="date" type="date" class="form-control"
												id="colFormLabel" placeholder="date" required>
										</div>
										<div class="col-lg-4">
											<button type="submit" class="btn btn-outline-secondary">Submit</button>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Interaction</label>
										<div class="col-12">
											<div class="p-1">
												<div class="card" style="height: 100px">
													<p class="p-4">

														<c:if test="${not empty mentor_int_DetailsList}">
															<c:forEach var="interaction"
																items="${mentor_int_DetailsList}">
																<c:out value="${interaction.interaction}"
																	escapeXml="false" />
																<br>
															</c:forEach>
														</c:if>
														<c:if test="${empty mentor_int_DetailsList}">
															<c:out value="No Interaction details found." />
														</c:if>
														<c:if test="${not empty mentor_int_Details}">
															<c:out value="${mentor_int_Details.interaction}"
																escapeXml="false" />
														</c:if>

													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Problem
											Understood</label>
										<div class="col-12">
											<div class="p-1">
												<div class="card" style="height: 100px">
													<p class="p-4">

														<c:if test="${not empty mentor_int_DetailsList}">
															<c:forEach var="problem"
																items="${mentor_int_DetailsList}">
																<c:out value="${problem.problem}" escapeXml="false" />
																<br>
															</c:forEach>
														</c:if>
														<c:if test="${empty mentor_int_DetailsList}">
															<c:out value="No Interaction details found." />
														</c:if>
														<c:if test="${not empty mentor_int_Details}">
															<c:out value="${mentor_int_Details.problem}"
																escapeXml="false" />
														</c:if>

													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-4 col-form-label">Remedial
											Action taken</label>
										<div class="col-12">
											<div class="p-1">
												<div class="card" style="height: 100px">
													<p class="p-4">

														<c:if test="${not empty mentor_int_DetailsList}">
															<c:forEach var="remedy" items="${mentor_int_DetailsList}">
																<c:out value="${remedy.remedy}" escapeXml="false" />
																<br>
															</c:forEach>
														</c:if>
														<c:if test="${empty mentor_int_DetailsList}">
															<c:out value="No Interaction details found." />
														</c:if>
														<c:if test="${not empty mentor_int_Details}">
															<c:out value="${mentor_int_Details.interaction}"
																escapeXml="false" />
														</c:if>

													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Changes
											Observed</label>
										<div class="col-12">
											<div class="p-1">
												<div class="card" style="height: 100px">
													<p class="p-4">

														<c:if test="${not empty mentor_int_DetailsList}">
															<c:forEach var="changes"
																items="${mentor_int_DetailsList}">
																<c:out value="${changes.changes}" escapeXml="false" />
																<br>
															</c:forEach>
														</c:if>
														<c:if test="${empty mentor_int_DetailsList}">
															<c:out value="No Interaction details found." />
														</c:if>
														<c:if test="${not empty mentor_int_Details}">
															<c:out value="${mentor_int_Details.interaction}"
																escapeXml="false" />
														</c:if>

													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<br>

						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>


