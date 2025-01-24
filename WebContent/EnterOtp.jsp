<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
    <script
    src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Validate OTP</title>
<style>
*{
    font-family: 'Montserrat', sans-serif;
}
.card-body {
    
	box-shadow: 0 5px 30px 0px #a20c0c;
	transition: 0.3s;
	position: relative;
	align-items: center;
	border-radius: 25px;
    color: black;
}

.btn {
	background-color:#ffff;
	text-decoration: none;
	color: #a20c0c;
    border-color: #a20c0c;
}

.btn:hover {
	background-color:#a20c0c;
	text-decoration: none;
	color:#ffff;
}
</style>
</head>
<body>
	<br>
	<br>
	<div>
		<div class="container-sm">
			<div class="p-xxl-5">

				<div class="card" style="border-radius: 25px;">

					<div class="card-body">

						<div class="container ">
							<div class="row">
                                <div class="col-md-4"></div><br>
								<div class="col-md-8" style="align-items:center;">
									<h1>
										<span>Validate Your OTP</span><br><br>
									</h1>
                                    <%
                                    if(request.getAttribute("message")!=null)
                                    {
                                      out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
                                    }
                                  %> 
								</div>

							</div>
                            <form action="ValidateOtp" role="form" autocomplete="off" class="form" method="post">
                                <div class="row">
                                   
                                <div class="row"></div>
                                <div class="col-md-4"></div>
                                    <div class="col-md-4"><input id="opt" name="otp" placeholder="Enter OTP" class="form-control" type="text" required="required"></div>
                                    <div class="col-md-4"></div>
                                </div><br>
    
                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><input name="recover-submit" class="btn" value="Verify" type="submit"></div>
                                    <div class="col-md-4"></div>
                                </div> <br>

                                <div class="row"> 
                                    <div class="col-md-6"></div><br>
                                    <div class="col-md-4"><input type="hidden" class="hide" name="token" id="token"></div>
                                    <div class="col-md-3"></div>
                                </div>
                                
                            </form>
							
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>