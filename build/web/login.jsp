<%-- 
    Document   : login
    Created on : Apr 29, 2023, 9:31:27 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<%@ include file = "header.jsp" %>

<body>
    <input type="hidden" id="status" value="<%= session.getAttribute("status") %>">

    <%@ include file = "navbar.jsp" %>

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Login/Register</h1>

				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Login Box Area =================-->
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login_box_img">
						<img class="img-fluid" src="img/login.jpg" alt="">
						<div class="hover">
							<h4>Register As Member?</h4>
							<p>Once you registered an account, only you can purchase</p>
							<a class="primary-btn" href="registration.jsp">Create an Account</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<h3>Log in to enter</h3>
						<form class="row login_form" action="LoginCustomerController" method="post" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<input type="email" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                                                <br>
                                                        </div>
                                                    
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">Log In</button>
								<a href="ForgotPassword.jsp">Forgot Password?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->

	<%@ include file = "footer.jsp" %>
        
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link rel="stylesheet" href="">
        
        <script type="text/javascript">
            var status = document.getElementById("status").value;            
            if(status === "loginError"){              
                swal.fire("Sorry", "Incorrect email or password", "error");               
            }
            if(status === "EmptyEmail"){              
                swal.fire("Sorry", "Please Enter Email", "error");               
            }
            if(status === "EmptyPass"){              
                swal.fire("Sorry", "Please Enter Password", "error");               
            }
        </script>
        
</body>

</html>
