<!DOCTYPE html>
<html lang="en">
    <%@ include file = "header.jsp" %>
    <body>

<header id="header">
		<div class="container">
			<div class="row">

				<div class="col-md-2">
					<div class="main-logo">
						<a href="index.jsp"><img src="images/main-logo.png" alt="logo"></a>
					</div>

				</div>

				<div class="col-md-10">
					
					<nav id="navbar">
						<div class="main-menu stellarnav">
							<ul class="menu-list">
								<li class="menu-item active"><a href="index.jsp" data-effect="Home">Home</a></li>
								<li class="menu-item"><a href="about.jsp" class="nav-link" data-effect="About">About</a></li>
								
                                                         
								<li class="menu-item"><a href="../DisplayProduct" class="nav-link" data-effect="Shop">Shop</a></li>
								<li class="menu-item"><a href="contact.jsp" class="nav-link" data-effect="Contact">Contact</a></li>
                                                                       <li class="menu-item has-sub">
									<a href="#pages" class="nav-link" data-effect="Pages">Pages</a>

									<ul>
								        <li class="active"><a href="index.jsp">Home</a></li>
								        <li><a href="about.jsp">About</a></li>
								        <li><a href="styles.jsp">Styles</a></li>
								        <li><a href="shop.jsp">Our Store</a></li>
								        <li><a href="single-product.jsp">Product Single</a></li>
								        <li><a href="contact.jsp">Contact</a></li>
								     </ul>

								</li>
							</ul>

							<div class="hamburger">
				                <span class="bar"></span>
				                <span class="bar"></span>
				                <span class="bar"></span>
				            </div>

						</div>
					</nav>

				</div>

			</div>
		</div>
	</header>
	
        <div class="container">
            <div class="row">
                <div class="col-lg-12 justify-center align-center" style="margin-top:20%">
                    <h3>Log in to enter</h3>
                    <form class="row login_form" action="../LoginCustomerController" method="post" id="contactForm" novalidate="novalidate">
                        <div class="col-md-12 form-group">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'">
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                            <br>
                        </div>

                        <div class="col-md-12 form-group">
                            <button type="submit" value="submit" class="primary-btn">Log In</button>
                        </div>
                        <a href="register.jsp">Register</a>
                    </form>
                </div>
            </div>
        </div>

        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="js/plugins.js"></script>
        <script src="js/script.js"></script>

    </body>
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
</html>	