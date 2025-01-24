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
<title>Forgot Password</title>
<style>
*{
    font-family: 'Montserrat', sans-serif;
	
}
.card-body {
    
	box-shadow: 0 1px 20px 0px #a20c0c;
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
	<div>
		<br>
		<br>
		<br>
		<div class="container-sm">
			<div class="p-xxl-5">

				<div class="card" style="border-radius: 25px;">

					<div class="card-body">

						<div class="container ">
							<div class="row">
                                <div class="col-md-2"></div><br>
								<div class="col-md-10" style="align-items:center;">
									<h1>
										<span>Forgot your password or want to change?</span><br><br>
									</h1>
                                    <h6>Change your password in three easy steps. This will help you
                                        to secure your password!</h6><br>
                                        <ol>
                                            <li>Enter your email address below.</li>
                                            <li>Our system will send you an OTP to your email</li>
                                            <li>Enter the OTP on the next page</li>
                                          </ol>  
								</div>

							</div>
                            <form action="ForgotPassword" method="POST" >
                                <div class="row">
                                   
                                <div class="row"></div>
                                <div class="col-md-4"></div>
                                    <div class="col-md-4"><label for="email-for-pass">Enter your email address</label> </div>
                                    <div class="col-md-4"></div>
                                </div><br>
    
                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><input class="form-control" type="text" name="email" id="email-for-pass" placeholder="Your Email" required></div>
                                    <div class="col-md-4"></div>
                                </div> <br>

                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><label for="email-for-pass">Select your role</label></div>
                                    <div class="col-md-4"></div>
                                </div> <br>

                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><select name="role" class="form-control" required>
                                        <option selected>Select Role</option>
                                        <option value="mentor">Mentor</option>
                                        <option value="mentee">Mentee</option>
                                    </select></div>
                                    <div class="col-md-4"></div>
                                </div> <br>

                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><button class="btn" type="submit">Get New Password</button></div>
                                    <div class="col-md-4"></div>
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