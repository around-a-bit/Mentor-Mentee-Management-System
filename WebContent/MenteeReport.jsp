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
<link rel="stylesheet" href="mentee_home.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta http-equiv="Content-Security-Policy"
	content="default-src 'self'; script-src 'self'; object-src 'none';">
<meta http-equiv="X-XSS-Protection" content="1; mode=block">
<title>Mentee Report</title>
<style>
#but {
	text-decoration: none;
	color: #EEE;
}
</style>
</head>
<body>
	<!-- NAV BER START -->
	<section id="wrapper">
		<div class="navbar">
			<div>
				<a href="#">The <span class="main-color">Neotia</span>
					University
				</a>
			</div>
			<div class="viewprof"></div>
			<div class="viewprof"></div>
			<div class="viewprof">
				<a href="MenteeHome.jsp">Profile</a>
			</div>
			<div class="report">
				<a href="MenteeReport.jsp">Reports</a>
			</div>
			<div class="btn btn-outline-light">
				<form action="LogoutServlet" method="post">
					<input type="submit" value="Logout" />
				</form>
			</div>
			<div class="logout">
				<a href="#"></a>
			</div>
		</div>
		<!-- NAV BER END -->
		<div class="p-4">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Reports</h5>
					<div class="container ">
					</div>
				</div>
			</div>
		</div>


		<div class="p-4">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Interaction</h5>
					<div class="container ">
						<form action="MenteeReportServlet" method="post">
							<div class="row">
								<div class="col-lg-12  ">
									<div class="form-group row">
										<label for="colFormLabel" class="col-sm-2 col-form-label">Select
											Date</label>
										<div class="col-lg-6">
											<input name="int_date_mentee" type="date"
												class="form-control" id="colFormLabel"
												placeholder="Select a date from above">
										</div>
										<div class="col-lg-4">
											<button type="submit" class="btn btn-outline-secondary">Submit</button>
										</div>
									</div>
								</div>
							</div>
						</form>

						<div class="row">
							<div class="col-lg-12">
								<div class="form-group row">
									<label for="colFormLabel" class="col-sm-2 col-form-label">Interaction</label>
									<div class="col-12">
										<div class="p-1">
											<div class="card" style="height: 100px">
												<p class="p-4">
													<c:if test="${not empty menteeIntDetailsList}">
														<c:forEach var="interaction"
															items="${menteeIntDetailsList}">
															<c:out value="${interaction.interaction}"
																escapeXml="false" />
															<br>
														</c:forEach>
													</c:if>
													<c:if test="${empty menteeIntDetailsList}">
														<c:out value="No Interaction details found." />
													</c:if>
													<c:if test="${not empty menteeIntDetails}">
														<c:out value="${menteeIntDetails.interaction}"
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
									<label for="colFormLabel" class="col-sm-6 col-form-label">Problem
										Understood by the mentor</label>
									<div class="col-12">
										<div class="p-1">
											<div class="card" style="height: 100px">
												<p class="p-4">
													<c:if test="${not empty menteeIntDetailsList}">
														<c:forEach var="problem" items="${menteeIntDetailsList}">
															<c:out value="${problem.problem}" escapeXml="false" />
															<br>
														</c:forEach>
													</c:if>
													<c:if test="${empty menteeIntDetailsList}">
														<c:out value="No Interaction details found." />
													</c:if>
													<c:if test="${not empty meneeIntDetails}">
														<c:out value="${menteeIntDetails.interaction}"
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
													<c:if test="${not empty menteeIntDetailsList}">
														<c:forEach var="remedy" items="${menteeIntDetailsList}">
															<c:out value="${remedy.remedy}" escapeXml="false" />
															<br>
														</c:forEach>
													</c:if>
													<c:if test="${empty menteeIntDetailsList}">
														<c:out value="No Interaction details found." />
													</c:if>
													<c:if test="${not empty mentor_int_Details}">
														<c:out value="${menteeIntDetailsList.interaction}"
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
													<c:if test="${not empty menteeIntDetailsList}">
														<c:forEach var="changes" items="${menteeIntDetailsList}">
															<c:out value="${changes.changes}" escapeXml="false" />
															<br>
														</c:forEach>
													</c:if>
													<c:if test="${empty menteeIntDetailsList}">
														<c:out value="No Interaction details found." />
													</c:if>
													<c:if test="${not empty menteeIntDetails}">
														<c:out value="${menteeIntDetailsList.interaction}"
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

	</section>
</body>
</html>