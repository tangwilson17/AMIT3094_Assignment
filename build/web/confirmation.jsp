<%-- 
    Document   : confirmation
    Created on : May 1, 2023, 3:52:03 PM
    Author     : Kyan
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="entity.Customer"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Orders"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    Orders orderInfo = (Orders) session.getAttribute("orderInfo");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = sdf.format(orderInfo.getPaymentId().getDate());

// First, convert the date to a Calendar object
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(orderInfo.getPaymentId().getDate());

// Add 3 days to the date
    calendar.add(Calendar.DAY_OF_MONTH, 4);

// Get the new date as a Date object
    Date newDate = calendar.getTime();

// Format the new date as a string using the SimpleDateFormat object
    String formattedNewDate = sdf.format(newDate);

%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <%@ include file = "header.jsp" %>

    <body>

        <%@ include file = "navbar.jsp" %>


       	<!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Confirmation</h1>

                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Order Details Area =================-->
        <section class="order_details section_gap">
            <div class="container">
                <h3 class="title_confirmation">Thank you. Your order has been received.&nbsp;&nbsp;&nbsp;<a class="confirm-switch" href="DisplayProfile">Click here to view your order.</a></h3>

                <div class="row order_d_inner">
                    <div class="col-lg-6">
                        <div class="details_item">
                            <h4>Order Info</h4>
                            <ul class="list">
                                <li><a href="#"><span>Order no.</span> : <%= orderInfo.getOrderId()%></a></li>
                                <li><a href="#"><span>Transaction no.</span> : <%= orderInfo.getPaymentId().getPaymentId() %></a></li>
                                <li><a href="#"><span>Date</span> : <%= formattedDate%></a></li>
                                <li><a href="#"><span>Estimated Date</span> : <%= formattedNewDate%></a></li>
                                <li><a href="#"><span>Payment method</span> : <%= orderInfo.getPaymentId().getPaymentMethod()%></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="details_item">
                            <h4>Shipping Address</h4>
                            <ul class="list">
                                <li><a href="#"><span>Address 01</span> : ${param.add1}</a></li>
                                <li><a href="#"><span>Address 02</span> : ${param.add2}</a></li>
                                <li><a href="#"><span>City</span> : ${param.city}</a></li>
                                <li><a href="#"><span>Postcode </span> : ${param.zip}</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="order_details_table">
                    <h2>Order Details</h2>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="delivery" value="25.00"></c:set>
                                <c:set var="subtotal" value="0"></c:set>
                                <c:forEach var="cart" items="${sessionScope.cart}">
                                    <tr>
                                        <c:set var="total" value="${cart.product.price * cart.quantity}"></c:set>
                                        <c:set var="subtotal" value="${subtotal + total}"></c:set>
                                        <c:set var="tax" value="${subtotal * 0.06}"></c:set>  
                                            <td>
                                                <p>${cart.product.productname}</p>
                                        </td>
                                        <td>
                                            <h5>x ${cart.quantity}</h5>
                                        </td>
                                        <td>
                                            <p>RM<fmt:formatNumber value="${total}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${subtotal > 200}">
                                    <c:set var="totalAmount" value="${subtotal + tax}"></c:set>
                                        <tr>
                                            <td>
                                                <h4>Subtotal</h4>
                                            </td>
                                            <td>
                                                <h5></h5>
                                            </td>
                                            <td>
                                                <p>RM<fmt:formatNumber value="${subtotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h4>Delivery Fee</h4>
                                        </td>
                                        <td>
                                            <h5></h5>
                                        </td>
                                        <td>
                                            <p>RM 0.00</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h4>Tax(6%)</h4>
                                        </td>
                                        <td>
                                            <h5></h5>
                                        </td>
                                        <td>
                                            <p>RM<fmt:formatNumber value="${tax}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>                                
                                    <tr>
                                        <td>
                                            <h4>Total</h4>
                                        </td>
                                        <td>
                                            <h5></h5>
                                        </td>
                                        <td>
                                            <p>RM<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${subtotal <= 200}">
                                    <c:set var="totalAmount" value="${subtotal + tax + delivery}"></c:set>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h4>Subtotal</h4>
                                            </td>
                                            <td>
                                                <h5></h5>
                                            </td>
                                            <td>
                                                <p>RM<fmt:formatNumber value="${subtotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h4>Delivery Fee</h4>
                                        </td>
                                        <td>
                                            <h5></h5>
                                        </td>
                                        <td>
                                            <p>RM<fmt:formatNumber value="${delivery}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h4>Tax(6%)</h4>
                                        </td>
                                        <td>
                                            <h5></h5>
                                        </td>
                                        <td>
                                            <p>RM<fmt:formatNumber value="${tax}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>                                
                                    <tr>
                                        <td>
                                            <h4>Total</h4>
                                        </td>
                                        <td>
                                            <h5></h5>
                                        </td>
                                        <td>
                                            <p>RM<fmt:formatNumber value="${totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                                        </td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Order Details Area =================-->


        <%@ include file = "footer.jsp" %>
    </body>

</html>