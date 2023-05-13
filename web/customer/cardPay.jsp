<%@page import="entity.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<!DOCTYPE html>


<html lang="en">
    <!DOCTYPE html>
    <html lang="en">
        <%@ include file = "header.jsp" %>
        <body>

            <%@ include file = "navbar.jsp" %>
            <div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">			
                            <div class="colored">
                                <h1 class="page-title">Check Out</h1>
                                <div class="breadcum-items">
                                    <span class="item"><a href="index.jsp">Home /</a></span>
                                    <span class="item colored">Check Out</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--site-banner-->

            <section class="padding-large">
                <div class="container">
                    <div class="row">

                        <!--================Card Info Area=================-->

                        <form class="row contact_form" method="POST" action="../CartServlet?action=payCard" onsubmit="return validateCard();">
                            <div class="row">
                                <div style="height: 500px;" class="col-lg-8">
                                    <h3>Your Card Information</h3>
                                    <div class="col-md-12 form-group p_star">
                                        <h6>Card Number: </h6>
                                        <input type="text" class="form-control" id="CardNum" name="CardNum" placeholder=" 16-digit card number" required="required">
                                        <span class="placeholder" placeholder="Card Number"></span>
                                    </div>                                
                                    <div class="col-md-5 form-group p_star">
                                        <h6>Expiration Date: </h6>
                                        <input type="text" class="form-control" id="ExpDate" name="ExpDate" placeholder=" MM/YY" required="required">
                                        <span class="placeholder" placeholder="Expiration Date"></span>
                                    </div>
                                    <div class="col-md-6 form-group p_star">
                                        <h6>CVV security code: </h6>
                                        <input type="text" class="form-control" id="cvv" name="cvv" placeholder=" 3-digit code" required="required">
                                        <span class="placeholder" placeholder="CVV security code"></span>
                                    </div>
                                    <input type="hidden" name="add1" value="${param.add1}">
                                    <input type="hidden" name="add2" value="${param.add2}">
                                    <input type="hidden" name="city" value="${param.city}">
                                    <input type="hidden" name="zip" value="${param.zip}">
                                    <input type="hidden" name="amount" value="${param.amount}">
                                    <button class="primary-btn" type="submit" >Proceed to Pay</button>
                                </div>
                            </div>
                        </form>
                        <!--================End Card Info Area =================-->
                    </div>
                </div>
            </section>


            <footer id="footer">
                <div class="container">
                    <div class="row">

                        <div class="col-md-4">

                            <div class="footer-item">
                                <div class="company-brand">
                                    <img src="images/main-logo.png" alt="logo" class="footer-logo">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sagittis sed ptibus liberolectus nonet psryroin. Amet sed lorem posuere sit iaculis amet, ac urna. Adipiscing fames semper erat ac in suspendisse iaculis.</p>
                                </div>
                            </div>

                        </div>

                        <div class="col-md-2">

                            <div class="footer-menu">
                                <h5>About Us</h5>
                                <ul class="menu-list">
                                    <li class="menu-item">
                                        <a href="#">vision</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">articles </a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">careers</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">service terms</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">donate</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <div class="col-md-2">

                            <div class="footer-menu">
                                <h5>Discover</h5>
                                <ul class="menu-list">
                                    <li class="menu-item">
                                        <a href="#">Home</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Books</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Authors</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Subjects</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Advanced Search</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <div class="col-md-2">

                            <div class="footer-menu">
                                <h5>My account</h5>
                                <ul class="menu-list">
                                    <li class="menu-item">
                                        <a href="#">Sign In</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">View Cart</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">My Wishtlist</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Track My Order</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <div class="col-md-2">

                            <div class="footer-menu">
                                <h5>Help</h5>
                                <ul class="menu-list">
                                    <li class="menu-item">
                                        <a href="#">Help center</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Report a problem</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Suggesting edits</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">Contact us</a>
                                    </li>
                                </ul>
                            </div>

                        </div>

                    </div>
                    <!-- / row -->

                </div>
            </footer>

            <div id="footer-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">

                            <div class="copyright">
                                <div class="row">

                                    <div class="col-md-6">
                                        <p>© 2022 All rights reserved. Free HTML Template by <a href="https://www.templatesjungle.com/" target="_blank">TemplatesJungle</a></p>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="social-links align-right">
                                            <ul>
                                                <li>
                                                    <a href="#"><i class="icon icon-facebook"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="icon icon-twitter"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="icon icon-youtube-play"></i></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="icon icon-behance-square"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                </div>
                            </div><!--grid-->

                        </div><!--footer-bottom-content-->
                    </div>
                </div>
            </div>
  <script>
            function validateCard() {
                var cardNum = document.getElementById("CardNum").value;
                var expDate = document.getElementById("ExpDate").value;
                var cvv = document.getElementById("cvv").value;

                // Validate card number
                if (!/^\d{16}$/.test(cardNum)) {
                    alert("Please enter a valid 16-digit card number.");
                    return false;
                }

                // Validate expiration date
                if (!/^(0[1-9]|1[0-2])\/\d{2}$/.test(expDate)) {
                    alert("Please enter a valid expiration date in MM/YY format.");
                    return false;
                }

                // Validate CVV
                if (!/^\d{3}$/.test(cvv)) {
                    alert("Please enter a valid 3-digit CVV.");
                    return false;
                }

                return true;
            }
        </script>

            <script src="js/jquery-1.11.0.min.js"></script>
            <script src="js/plugins.js"></script>
            <script src="js/script.js"></script>

        </body>
    </html>	