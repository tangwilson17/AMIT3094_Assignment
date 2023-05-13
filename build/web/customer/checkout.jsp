<%@page import="entity.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    <% 
        Customer cust = (Customer) session.getAttribute("customer");
        session.setAttribute("customer", cust);
    %>
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

                        <!--================Checkout Area =================-->
                        <section class="checkout_area section_gap">
                            <div class="container">
                                <div class="billing_details">
                                    <form class="row contact_form" id="your-form-id" method="POST" action="../CartServlet?action=checkout">
                                        <div class="row">
                                            <div class="col-lg-5">
                                                <h3>Shipping Details</h3>
                                                <div class="col-md-5 form-group p_star">
                                                    <input type="text" class="form-control" id="first" name="first_name" placeholder=" First name" required="required">
                                                    <span class="placeholder" placeholder="First name"></span>
                                                </div>
                                                <div class="col-md-5 form-group p_star">
                                                    <input type="text" class="form-control" id="last" name="last_name" placeholder=" Last name" required="required">
                                                    <span class="placeholder" placeholder="Last name"></span>
                                                </div>
                                                <div class="col-md-5 form-group p_star">
                                                    <input type="text" class="form-control" id="number" name="phone" placeholder=" Phone number" required="required">
                                                    <span class="placeholder" placeholder="Phone number"></span>
                                                </div>
                                                <div class="col-md-5 form-group p_star">
                                                    <input type="text" class="form-control" id="email" name="email" placeholder=" Email Address" required="required">
                                                    <span class="placeholder" placeholder="Email Address"></span>
                                                </div>
                                                <div class="col-md-12 form-group p_star">
                                                    <input type="text" class="form-control" id="add1" name="add1" placeholder=" Address line 01" required="required">
                                                    <span class="placeholder" placeholder="Address line 01"></span>
                                                </div>
                                                <div class="col-md-12 form-group p_star">
                                                    <input type="text" class="form-control" id="add2" name="add2" placeholder=" Address line 02" required="required">
                                                    <span class="placeholder" placeholder="Address line 02"></span>
                                                </div>
                                                <div class="col-md-12 form-group p_star">
                                                    <input type="text" class="form-control" id="city" name="city" placeholder=" Town/City" required="required">
                                                    <span class="placeholder" placeholder="Town/City"></span>
                                                </div>
                                                <div class="col-md-12 form-group">
                                                    <input type="text" class="form-control" id="zip" name="zip" placeholder=" Postcode/ZIP" required="required">
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="order_box">
                                                    <h2>Your Order</h2>
                                                    <c:set var="delivery" value="25.00"></c:set>
                                                    <c:set var="subtotal" value="0"></c:set>
                                                        <ul class="list">
                                                            <li>Product=============<span>Qty</span><span>=====Total&nbsp;&nbsp;&nbsp;</span></li>
                                                            <c:forEach var="cart" items="${sessionScope.cart}" varStatus="i">
                                                                <c:set var="total" value="${cart.product.price * cart.quantity}"></c:set>
                                                                <c:set var="subtotal" value="${subtotal + total}"></c:set>
                                                                <c:set var="tax" value="${subtotal * 0.06}"></c:set>   
                                                            <li>${cart.product.productname} <span class="">x&nbsp;${cart.quantity}</span> <span class="last">RM<fmt:formatNumber value="${total}" type="number" minFractionDigits="2" maxFractionDigits="2"/>&nbsp;&nbsp;&nbsp;</span></li>
                                                            </c:forEach>
                                                    </ul>
                                                    <c:if test="${subtotal > 200}">
                                                        <c:set var="totalAmount" value="${subtotal + tax}"></c:set>
                                                            <ul class="list list_2">
                                                                <li>Subtotal: <span>RM<fmt:formatNumber value="${subtotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></li>
                                                            <li>Tax(6%): <span>RM<fmt:formatNumber value="${tax}" type="number" minFractionDigits="2" maxFractionDigits="2" /></span></li>
                                                            <li>Delivery fee:<span>RM 0.00</span></li>
                                                            <li>Total Amount:<span>RM<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></li>
                                                            <input type="hidden" name="amount" value="<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/>">
                                                        </ul>
                                                    </c:if>
                                                    <c:if test="${subtotal <= 200}">
                                                        <c:set var="totalAmount" value="${subtotal + tax + delivery}"></c:set>
                                                            <ul class="list list_2">
                                                                <li>Subtotal: <span>RM<fmt:formatNumber value="${subtotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></li>
                                                            <li>Tax(6%): <span>RM<fmt:formatNumber value="${tax}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></li>
                                                            <li>Delivery fee:<span>RM<fmt:formatNumber value="${delivery}" type="number" minFractionDigits="2" /></span></li>
                                                            <li>Total Amount:<span>RM<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></li>
                                                            <input type="hidden" name="amount" value="<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/>">
                                                        </ul>
                                                    </c:if>
                                                    <br>
                                                    <h2>Transaction</h2>
                                                    <div class="payment_item">
                                                        <div class="radion_btn">
                                                            <input type="radio" id="f-option5" name="paymentMethod" value="Cash" checked="checked">
                                                            <label for="f-option5">Cash</label>
                                                            <div class="check"></div>
                                                        </div>
                                                    </div>
                                                    <div class="payment_item active">
                                                        <div class="radion_btn">
                                                            <input type="radio" id="f-option6" name="paymentMethod" value="Card">
                                                            <label for="f-option6">Debit/Credit Card</label>
                                                            <img src="img/product/card.jpg" alt="">
                                                        </div>
                                                    </div>
                                                    <button class="primary-btn" type="submit" onclick="event.preventDefault();
                                                            var first = document.getElementById('first').value.trim();
                                                            var last = document.getElementById('last').value.trim();
                                                            var number = document.getElementById('number').value.trim();
                                                            var email = document.getElementById('email').value.trim();
                                                            var add1 = document.getElementById('add1').value.trim();
                                                            var add2 = document.getElementById('add2').value.trim();
                                                            var city = document.getElementById('city').value.trim();
                                                            var zip = document.getElementById('zip').value.trim();

                                                            if (first === '' || last === '' || number === '' || email === '' || add1 === '' || add2 === '' || city === '' || zip === '') {
                                                                alert('Please fill in all required fields.');
                                                            } else {
                                                                Swal.fire({
                                                                    title: 'Are you sure?',
                                                                    icon: 'info',
                                                                    showCancelButton: true,
                                                                    confirmButtonColor: '#3085d6',
                                                                    cancelButtonColor: '#d33',
                                                                    confirmButtonText: 'Yes, Proceed Check out!'
                                                                }).then((result) => {
                                                                    if (result.isConfirmed) {
                                                                        document.getElementById('your-form-id').submit();
                                                                    }
                                                                });
                                                            }">Proceed to Pay</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </section>
                        <!--================End Checkout Area =================-->

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

            <script src="js/jquery-1.11.0.min.js"></script>
            <script src="js/plugins.js"></script>
            <script src="js/script.js"></script>

        </body>
    </html>	