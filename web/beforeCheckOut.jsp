<%-- 
    Document   : beforeCheckOut
    Created on : May 3, 2023, 1:20:50 AM
    Author     : Kyan
--%>

<%@page import="entity.Customer"%>
<%@page import="entity.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : confirmation
    Created on : May 1, 2023, 3:52:03 PM
    Author     : Kyan
--%>

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
                        <nav class="d-flex align-items-center">
                            <a href="index.jsp">Cart<span class="lnr lnr-arrow-right"></span></a>
                            <a href="#">Error</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->
        <%
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            Customer cust = (Customer) session.getAttribute("customer");

            if (cart == null || cart.isEmpty()) {
        %>
        <!--================Order Details Area =================-->
        <section class="order_details section_gap">
            <div class="container">
                <h3 class="alert-danger">Sorry... your cart cannot be empty before check out.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="confirm-switch" href="DisplayProduct">Click here to continue shopping.</a></h3>

            </div>
        </section>
        <!--================End Order Details Area =================-->
        <% } else if (cust == null) { %>
        <!--================Order Details Area =================-->
        <section class="order_details section_gap">
            <div class="container">
                <h3 class="alert-danger">Sorry... your must login before check out.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="confirm-switch" href="login.jsp">Click here to Login.</a></h3>

            </div>
        </section>
        <!--================End Order Details Area =================-->
        <% }%>
        <%@ include file = "footer.jsp" %>
    </body>

</html>
