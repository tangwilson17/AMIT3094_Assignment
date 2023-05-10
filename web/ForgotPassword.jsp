<%-- 
    Document   : ForgotPassword
    Created on : Apr 29, 2023, 4:58:42 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <%@ include file = "header.jsp" %>

    <body>
        <input type="hidden" id="status" value="<% if (session.getAttribute("status") != "") {
            out.print(session.getAttribute("status"));
            session.setAttribute("status", "");
        }%>">

        <%@ include file = "navbar.jsp" %>

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Change Password</h1>
                        <nav class="d-flex align-items-center">
                            <a href="login.jsp">Login/Register<span class="lnr lnr-arrow-right"></span></a>
                            <a href="ForgotPassword.jsp">Change Password</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Forgot Password Box Area =================-->
        <section class="login_box_area section_gap">
            <div class="container">
                <div class="row">

                    <div class="col-lg-6 mx-auto">
                        <div class="login_form_inner">
                            <h3>Change Password</h3>
                            <form class="row login_form" action="ForgotPasswordCustomerController" method="post" id="contactForm" novalidate="novalidate">
                                <div class="col-md-12 form-group">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="New Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'New Password'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="password" class="form-control" id="cpassword" name="cpassword" placeholder="Confirm Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Confirm Password'">
                                    <br>
                                </div>
                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit" class="primary-btn">Change Password</button>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Forgot Password Box Area =================-->

        <%@ include file = "footer.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link rel="stylesheet" href="">

        <script type="text/javascript">
                                        var status = document.getElementById("status").value;

                                        if (status === "success") {
                                            swal.fire("Congrats", "Change Password Succesfully", "success");
                                        }
                                        if (status === "EmptyEmail") {
                                            swal.fire("Sorry", "Please Enter Email", "error");
                                        }
                                        if (status === "EmptyPass") {
                                            swal.fire("Sorry", "Please Enter Password", "error");
                                        }
                                        if (status === "EmptyConfirmPass") {
                                            swal.fire("Sorry", "Please Enter Confirmation Password", "error");
                                        }
                                        if (status === "invalidConfirmPassword") {
                                            swal.fire("Sorry", "Password do not match with Confirmation Password", "error");
                                        }

        </script>
    </body>

</html>
