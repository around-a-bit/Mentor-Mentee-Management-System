<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    
    <link rel="stylesheet" href="mentor_home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Mentor home</title>
    <style>
  #but{
    text-decoration: none;
    color: #EEE;
  }
</style>
</head>
<body>
 <!-- ASIDE BER END-->
<aside class="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left" id="show-side-navigation1">
  <i class="uil-bars close-aside d-md-none d-lg-none" data-close="show-side-navigation1"></i>
  <div class="sidebar-header d-flex justify-content-center align-items-center px-3 py-5">
  
    <div class="ms-2">
      <h5 class="fs-6 mb-0">
        <a class="text-decoration-none" href="#"></a>
      </h5>
      <p class="mt-1 mb-0"></p>
    </div>
  </div>
 
  <ul class="categories list-unstyled">
    <li class="">
      <i class="uil-folder"></i><a href="MentorHome.jsp">Home</a>
    </li>
    <li class="">
      <i class="uil-folder"></i><a href="AddMentee.jsp">Mentees</a>
    </li>
    <li class="">
      <i class="uil-folder"></i><a href="MentorInteraction.jsp">Interaction</a>
    </li>
    <li class="">
      <i class="uil-folder"></i><a href="MentorReport.jsp">View Interaction</a>
    </li>
    <li class="">
      <i class="uil-folder"></i><a href="ForgotPassword.jsp">Change Password</a>
    </li>
  </ul>
  <div class="container">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="btn">
          <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout"/>
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
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#toggle-navbar" aria-controls="toggle-navbar" aria-expanded="false" aria-label="Toggle navigation">
          <i class="uil-bars text-white"></i>
        </button>
        <a class="navbar-brand" href="#">The <span class="main-color">Neotia</span> University</a>
      </div>
      </div>
  </nav> <!-- NAV BER END -->


  <div class="p-4">
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">Profile</h5>
      <div class="container ">

        <div class="row">
          <div class="col-lg-2">Mentor Name</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="mentor_name" items="${mentorDetailsList}">
            <c:out value="${mentor_name.mentor_name}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-2">Mentor ID</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="uid" items="${mentorDetailsList}">
            <c:out value="${uid.uid}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-2">School</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="school_name" items="${mentorDetailsList}">
            <c:out value="${school_name.school_name}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-2">Department</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="department" items="${mentorDetailsList}">
            <c:out value="${department.department}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
          <div class="col-lg-4">
            <form action="MentorHomeServlet" method="post">
            <button type="submit" class="btn btn-outline-secondary">Refresh</button>
            </form>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-2">Mobile Number</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="mentor_mobile" items="${mentorDetailsList}">
            <c:out value="${mentor_mobile.mentor_mobile}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-2">Email ID</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="mentor_email" items="${mentorDetailsList}">
            <c:out value="${mentor_email.mentor_email}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-2">Date of Joining</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="joining_date" items="${mentorDetailsList}">
            <c:out value="${joining_date.joining_date}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>
  
        <div class="row">
          <div class="col-lg-2">Remarks</div>:
          <div class="col-lg-4">
          <p>
          	<c:if test="${not empty mentorDetailsList}">  
			<c:forEach var="remarks" items="${mentorDetailsList}">
            <c:out value="${remarks.remarks}" escapeXml="false" />  
            <br>
            </c:forEach>
            </c:if>
            <c:if test="${empty mentorDetailsList}">  
            <c:out value="No details found." />
            </c:if>
            <c:if test="${not empty mentorDetails}">  
            <c:out value="${mentorDetails.interaction}" escapeXml="false" />  
            </c:if>
          </p>
          </div>
        </div>

    </div>
  </div>
</div>
</div>


<form action="MentorHomeServlet" method="post" onclick="return validate()">
<div class="p-4">
<div class="container ">
    <div class="row">
      <div class="col-md-4">
        <p>Click here to update your profile</p>
      </div>
      <div class="col-md-4">
        <div class="form-check form-switch">
          <input  class="form-check-input" name="check" type="checkbox" id="flexSwitchCheckDefault" required>
        </div>
      </div>
    </div>
</div>
</div>



<div class="p-4 ">
  <div class="card ">
    <div class="card-body ">
  <h5 class="card-title">Update Profile</h5>
<br>
  <div class="form-group row">
    <label for="colFormLabel" class="col-sm-2 col-form-label">Date of Joining</label>
    <div class="col-sm-10">

      <input name="joining_date" type="date" class="form-control" id="colFormLabel" placeholder="Your Date of Joining" required>
    
    </div>
  </div>
<br>
  <div class="form-group row">
    <label for="colFormLabel" class="col-sm-2 col-form-label">Remarks</label>
    <div class="col-sm-10">
      
      <input name="remarks" type="text" class="form-control" id="colFormLabel" placeholder="Remarks" required>
    
    </div>
  </div>

<br>
<div class="container">
  <div class="row">
    <div class="col-lg-6"></div>
    <div class="col-lg-4">
      <button type="submit" class="btn btn-outline-secondary">Update</button>
    </div>
    <div class="col-lg-4"></div>
  </div>
</div>

    </div>
  </div>
  
</div>
</form>
</section>
<script src="script_mentor.js"></script>
</body>

</html>



