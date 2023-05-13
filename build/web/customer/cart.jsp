<%@page import="entity.Cart"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64"%>
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
                                <h1 class="page-title">Shopping Cart</h1>
                                <div class="breadcum-items">
                                    <span class="item"><a href="index.jsp">Home /</a></span>
                                    <span class="item colored">Shopping Cart</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--site-banner-->

            <section class="padding-large">
                <div class="container">
                    <div class="row">

                        <%
                            List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cart");

                            if (cartList == null) {
                        %>
                        <!--================Cart Area =================-->
                        <div class="table-responsive">
                            <table width="1500px" class="table">
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
                                                <li>RM 25.00</li>
                                            </ul>
                                        </td>
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
                                        <td>
                                            <h5>RM0.00</h5>
                                        </td>
                                    </tr>
                                    <tr class="out_button_area">
                                        <td>
                                            <div class="checkout_btn_inner d-flex align-items-center">
                                                <a class="gray_btn" href="../DisplayProduct">Continue Shop</a>
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
                                                                window.location.href = '../CartServlet?action=checkout';
                                                            }
                                                        })">Proceed checkout</a>                                        
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!--================End Cart Area =================-->


                        <% } else { %>

                        <!--================Cart Area =================-->
                        <div class="table-responsive">
                            <table width="1500px" class="table">
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
                                                <form method="POST" action="../CartServlet?action=update&index=<%= i%>">
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
                                            <a class="primary-btn" href="../CartServlet?action=cancel&index=<%= i%>" onclick="event.preventDefault();
                                                    Swal.fire({
                                                        title: 'Are you sure?',
                                                        icon: 'info',
                                                        showCancelButton: true,
                                                        confirmButtonColor: '#3085d6',
                                                        cancelButtonColor: '#d33',
                                                        confirmButtonText: 'Yes, cancel it'
                                                    }).then((result) => {
                                                        if (result.isConfirmed) {
                                                            window.location.href = '../CartServlet?action=cancel&index=<%= i%>';
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
                                            <div class="checkout_btn_inner d-flex align-items-center">
                                                <a class="gray_btn" href="../DisplayProduct">
                                                    <button type="submit">
                                                        <i>Continue Shop</i>
                                                    </button></a>


                                                <a class="gray_btn" href="javascript:void(0);" onclick="event.preventDefault();
                                                            Swal.fire({
                                                                title: 'Are you sure?',
                                                                icon: 'info',
                                                                showCancelButton: true,
                                                                confirmButtonColor: '#3085d6',
                                                                cancelButtonColor: '#d33',
                                                                confirmButtonText: 'Yes, proceed to checkout'
                                                            }).then((result) => {
                                                                if (result.isConfirmed) {
                                                                    window.location.href = '../CartServlet?action=checkout';
                                                                }
                                                            })"><button type="submit">
                                                    <i>Proceed Checkout</i>
                                                    
                                                  </button>  </a>                                  
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!--================End Cart Area =================-->
                        <% }%>
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