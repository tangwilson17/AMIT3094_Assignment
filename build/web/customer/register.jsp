<%-- 
    Document   : registration
    Created on : Apr 29, 2023, 9:32:13 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<%@ include file = "header.jsp" %>

<body>
    <input type="hidden" id="status" value="<% if (session.getAttribute("status") != "") {out.print(session.getAttribute("status")); session.setAttribute("status", "");} %>">

  

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Login/Register</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Login<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Register</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Registration Box Area =================-->
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				
				<div class="col-lg-12">
					<div class="login_form_inner">
						<h3>Register account</h3>
						<form class="row login_form" action="../RegistrationCustomerController" method="post" id="contactForm">
							<div class="col-md-12 form-group">
                                                            <input type="text" class="form-control" id="name" name="name" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="email" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'">
							</div>
                                                        <div class="col-md-12 form-group">
								<input type="text" class="form-control" id="phoneNo" name="phoneNo" placeholder="Contact Number" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Contact Number'">
							</div>
                                                        <div class="col-md-12 form-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
							</div>
                                                        <div class="col-md-12 form-group">
								<input type="password" class="form-control" id="cpassword" name="cpassword" placeholder="Confirm Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Confirm Password'">
							</div>
							
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">Register</button>
                                                                <a href="login.jsp">Go Back to Login</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Registration Box Area =================-->


        
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link rel="stylesheet" href="">
        
        <script type="text/javascript">
            var status = document.getElementById("status").value;
           
            if(status === "success"){              
                swal.fire("Congrats", "Account Created Succesfully", "success");               
            }
            if(status === "EmptyName"){              
                swal.fire("Sorry", "Please Enter Name", "error");               
            }
            if(status === "EmptyEmail"){              
                swal.fire("Sorry", "Please Enter Email", "error");               
            }
            if(status === "EmptyPhoneNo"){              
                swal.fire("Sorry", "Please Enter Contact Number", "error");               
            }
            if(status === "EmptyPass"){              
                swal.fire("Sorry", "Please Enter Password", "error");               
            }
            if(status === "EmptyConfirmPass"){              
                swal.fire("Sorry", "Please Enter Confirmation Password", "error");               
            }
            if (status === "invalidEmail"){              
                swal.fire("Sorry", "This Email is already registered", "error");               
            }
            if (status === "invalidConfirmPassword"){
                swal.fire("Sorry", "Password do not match with Confirmation Password", "error");
            }
            
        </script>
        
</body>

</html>
