<%-- 
   Document   : ProductDetails
   Created on : Apr 23, 2023, 8:11:51 PM
   Author     : Kyan
--%>

<%@page import="entity.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <%@ include file = "header.jsp" %>

    <% 
        Customer cust = (Customer) session.getAttribute("customer");
        session.setAttribute("customer", cust);
    %>
    <body>

        <%@ include file = "navbar.jsp" %>

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Checkout</h1>

                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Checkout Area =================-->
        <section class="checkout_area section_gap">
            <div class="container">
                <div class="billing_details">
                    <form class="row contact_form" id="your-form-id" method="POST" action="CartServlet?action=checkout">
                        <div class="row">
                            <div class="col-lg-8">
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
                            <div class="col-lg-4">
                                <div class="order_box">
                                    <h2>Your Order</h2>
                                    <c:set var="delivery" value="25.00"></c:set>
                                    <c:set var="subtotal" value="0"></c:set>
                                        <ul class="list">
                                            <li><a href="#">Product <span>Qty</span><span>Total&nbsp;&nbsp;&nbsp;</span></a></li>
                                            <c:forEach var="cart" items="${sessionScope.cart}" varStatus="i">
                                                <c:set var="total" value="${cart.product.price * cart.quantity}"></c:set>
                                                <c:set var="subtotal" value="${subtotal + total}"></c:set>
                                                <c:set var="tax" value="${subtotal * 0.06}"></c:set>   
                                            <li><a href="CartServlet">${cart.product.productname} <span class="">x&nbsp;${cart.quantity}</span> <span class="last">RM<fmt:formatNumber value="${total}" type="number" minFractionDigits="2" maxFractionDigits="2"/>&nbsp;&nbsp;&nbsp;</span></a></li>
                                            </c:forEach>
                                    </ul>
                                    <c:if test="${subtotal > 200}">
                                        <c:set var="totalAmount" value="${subtotal + tax}"></c:set>
                                            <ul class="list list_2">
                                                <li><a href="#">Subtotal <span>RM<fmt:formatNumber value="${subtotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                            <li><a href="#">Tax(6%) <span>RM<fmt:formatNumber value="${tax}" type="number" minFractionDigits="2" maxFractionDigits="2" /></span></a></li>
                                            <li><a href="#">Delivery fee<span>RM 0.00</span></a></li>
                                            <li><a href="#">Total Amount<span>RM<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                            <input type="hidden" name="amount" value="<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/>">
                                        </ul>
                                    </c:if>
                                    <c:if test="${subtotal <= 200}">
                                        <c:set var="totalAmount" value="${subtotal + tax + delivery}"></c:set>
                                            <ul class="list list_2">
                                                <li><a href="#">Subtotal <span>RM<fmt:formatNumber value="${subtotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                            <li><a href="#">Tax(6%) <span>RM<fmt:formatNumber value="${tax}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                            <li><a href="#">Delivery fee<span>RM<fmt:formatNumber value="${delivery}" type="number" minFractionDigits="2" /></span></a></li>
                                            <li><a href="#">Total Amount<span>RM<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
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
                                        <p>Pay via cash.</p>
                                    </div>
                                    <div class="payment_item active">
                                        <div class="radion_btn">
                                            <input type="radio" id="f-option6" name="paymentMethod" value="Card">
                                            <label for="f-option6">Debit/Credit Card</label>
                                            <img src="img/product/card.jpg" alt="">
                                            <div class="check"></div>
                                        </div>
                                        <p>Pay via Visa or Master card.</p>
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


        <%@ include file = "footer.jsp" %>


    </body>

</html>