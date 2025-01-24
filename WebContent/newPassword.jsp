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
<title>New Password</title>
<style>
    *{
        font-family: 'Montserrat', sans-serif;
    }
.card-body {
	box-shadow: 0 5px 40px 0px #a20c0c;
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
								<div class="col-md-4"></div>
								<div class="col-md-4" style="align-items:center;">
									<h1>
										<span>Reset Password</span><br><br>
									</h1>
								</div>
                                <div class="col-md-5"></div>
							</div>
                            <form class="form-horizontal" action="NewPassword" method="POST" >
                                <div class="row"> <br>
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><input type="text" name="password" placeholder=" New Password" class="form-control"></div>
                                    <div class="col-md-4"></div>
                                </div><br>
    
                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><input type="password" name="confPassword" placeholder=" Confirm New Password" class="form-control"></div>
                                    <div class="col-md-4"></div>
                                </div> <br>
    
                                <div class="row"> 
                                    <div class="col-md-4"></div><br>
                                    <div class="col-md-4"><button type="submit" value="Reset" class="btn btn-block btn-info">Reset</button> </div>
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