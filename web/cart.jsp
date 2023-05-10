<%-- 
   Document   : ProductDetails
   Created on : Apr 23, 2023, 8:11:51 PM
   Author     : Kyan
--%>


<%@page import="entity.Cart"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64"%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

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
                        <h1>Shopping Cart</h1>

                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <%
            List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cart");
            if (cartList == null) {
        %>
        <!--================Cart Area =================-->
        <section class="cart_area">
            <div class="container">
                <div class="cart_inner">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Cancel</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>

                                    </td>
                                    <td>
                                    </td>
                                    <td>
                                    </td>
                                    <td>

                                    </td>                                    
                                    <td>

                                    </td>
                                </tr>
                                <tr class="bottom_button">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>      
                                    <td>

                                    </td>    
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>   
                                    <td>
                                        <h5>Subtotal</h5>
                                        <ul class="list">
                                            <li>taxes (SST 6%): </li>
                                            <li class="active">Local Delivery: </li>
                                        </ul>
                                    </td>
                                    <td>
                                        <h5>RM<fmt:formatNumber value="" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>   
                                        <ul class="list">
                                            <li>RM<fmt:formatNumber value="" type="number" minFractionDigits="2" maxFractionDigits="2"/></li>
                                            <li>RM</li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr class="shipping_area">
                                    <td>

                                    </td>
                                    <td>
                                    </td>                                    
                                    <td>
                                        <h5>Total Amount</h5>
                                    </td>
                                    <td>
                                        <h5>RM0.00</h5>
                                    </td>
                                    <td>
                                        <h5>RM<fmt:formatNumber value="" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>
                                    </td>
                                </tr>
                                <tr class="out_button_area">
                                    <td>
                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <div class="checkout_btn_inner d-flex align-items-center">
                                            <a class="gray_btn" href="DisplayProduct">Continue Shop</a>
                                            <a class="primary-btn" href="javascript:void(0);" onclick="event.preventDefault();
                                                    Swal.fire({
                                                        title: 'Are you sure?',
                                                        icon: 'info',
                                                        showCancelButton: true,
                                                        confirmButtonColor: '#3085d6',
                                                        cancelButtonColor: '#d33',
                                                        confirmButtonText: 'Yes, proceed to checkout'
                                                    }).then((result) => {
                                                        if (result.isConfirmed) {
                                                            window.location.href = 'CartServlet?action=checkout';
                                                        }
                                                    })">Proceed checkout</a>                                        
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Cart Area =================-->

        <%
        } else {
        %>

        <!--================Cart Area =================-->
        <section class="cart_area">
            <div class="container">
                <div class="cart_inner">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Cancel</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    double subtotal = 0;
                                    double delivery = 25.00;
                                    double tax = 0;

                                    int i = 0;
                                    for (i = 0; i < cartList.size(); i++) {
                                        Cart cart = cartList.get(i);

                                        double total = cart.getProduct().getPrice() * cart.getQuantity();
                                        subtotal += total;
                                        tax += subtotal * 0.06;
                                %>

                                <tr>
                                    <td>
                                        <div class="media">
                                            <div class="d-flex">
                                                <img width="200px" class="img-fluid" src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(cart.getProduct().getImage()))%>" alt="<%= cart.getProduct().getProductname()%>">
                                            </div>
                                            <div class="media-body">
                                                <p><%= cart.getProduct().getProductname()%></p>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h5>RM<fmt:formatNumber value="<%= cart.getProduct().getPrice()%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>
                                    </td>
                                    <td>
                                        <div class="product_count">
                                            <form method="POST" action="CartServlet?action=update&index=<%= i%>">
                                                <input type="number" name="qty" id="sst" max="<%= cart.getProduct().getQty()%>" min="1" value="<%= cart.getQuantity()%>" title="Quantity:"
                                                       class="input-text qty" required="required">
                                                <button type="submit">
                                                    <i>save</i>
                                                </button>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <h5>RM<fmt:formatNumber value="<%= total%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>
                                    </td>
                                    <td>
                                        <a class="primary-btn" href="CartServlet?action=cancel&index=<%= i%>" onclick="event.preventDefault();
                                                Swal.fire({
                                                    title: 'Are you sure?',
                                                    icon: 'info',
                                                    showCancelButton: true,
                                                    confirmButtonColor: '#3085d6',
                                                    cancelButtonColor: '#d33',
                                                    confirmButtonText: 'Yes, cancel it'
                                                }).then((result) => {
                                                    if (result.isConfirmed) {
                                                        window.location.href = 'CartServlet?action=cancel&index=<%= i%>';
                                                    }
                                                })">Cancel</a>                                        
                                    </td>
                                </tr>
                                <% }%>
                                <tr class="bottom_button">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>                                
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>   
                                    <%
                                        double totalAmount = 0;

                                        if (subtotal > 200) {
                                            totalAmount = subtotal + tax;

                                    %>
                                    <td>
                                        <h5>Subtotal</h5>
                                        <ul class="list">
                                            <li>taxes (SST 6%): </li>
                                            <li>Local Delivery(>RM200 get free): </li>
                                        </ul>
                                    </td>
                                    <td>
                                        <h5>RM<fmt:formatNumber value="<%= subtotal%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>   
                                        <ul class="list">
                                            <li>RM<fmt:formatNumber value="<%= tax%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></li>
                                            <li>RM0.00</li>
                                        </ul>
                                    </td>
                                    <% }%>                                    
                                    <% if (subtotal <= 200) {

                                            totalAmount = subtotal + tax + delivery;

                                    %>
                                    <td>
                                        <h5>Subtotal</h5>
                                        <ul class="list">
                                            <li>taxes (SST 6%): </li>
                                            <li class="active">Local Delivery: </li>
                                        </ul>
                                    </td>
                                    <td>
                                        <h5>RM<fmt:formatNumber value="<%= subtotal%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>   
                                        <ul class="list">
                                            <li>RM<fmt:formatNumber value="<%= tax%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></li>
                                            <li>RM<%= delivery%></li>
                                        </ul>
                                    </td>
                                    <% }%>                                    
                                </tr>
                                <tr class="shipping_area">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                    </td>                                    
                                    <td>
                                        <h5>Total Amount</h5>
                                    </td>
                                    <% if (subtotal == 0) { %>
                                    <td>
                                        <h5>RM0.00</h5>
                                    </td>
                                    <% } %>
                                    <% if (subtotal != 0) {%>

                                    <td>
                                        <h5>RM<fmt:formatNumber value="<%= totalAmount%>" type="number" minFractionDigits="2" maxFractionDigits="2"/></h5>
                                    </td>
                                    <% }%>
                                </tr>
                                <tr class="out_button_area">
                                    <td>
                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <div class="checkout_btn_inner d-flex align-items-center">
                                            <a class="gray_btn" href="DisplayProduct">Continue Shop</a>
                                            <a class="primary-btn" href="javascript:void(0);" onclick="event.preventDefault();
                                                    Swal.fire({
                                                        title: 'Are you sure?',
                                                        icon: 'info',
                                                        showCancelButton: true,
                                                        confirmButtonColor: '#3085d6',
                                                        cancelButtonColor: '#d33',
                                                        confirmButtonText: 'Yes, proceed to checkout'
                                                    }).then((result) => {
                                                        if (result.isConfirmed) {
                                                            window.location.href = 'CartServlet?action=checkout';
                                                        }
                                                    })">Proceed checkout</a>                                        
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Cart Area =================-->

        <% }%>

        <%@ include file = "footer.jsp" %>

    </body>

</html>