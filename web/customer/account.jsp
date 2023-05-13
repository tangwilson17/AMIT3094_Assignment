<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Customer"%>
<%@page import="entity.OrderList"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<%
    Orders order = (Orders) session.getAttribute("orderInfo");

    Customer cust = (Customer) session.getAttribute("customer");
%>
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
                                <h1 class="page-title">Account</h1>
                                <div class="breadcum-items">
                                    <span class="item"><a href="index.jsp">Home /</a></span>
                                    <span class="item colored">Account</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--site-banner-->

            <% if (order == null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    List<Orders> existsO = (List) session.getAttribute("order");
                    List<OrderList> existsOL = (List) session.getAttribute("orderList");

            %>
            <!--================Checkout Area =================-->
            <section class="checkout_area section_gap">
                <div class="container">
                    <div class="billing_details">
                        <div class="row"  style="width: 1350px;">
                            <div class="col-lg-2" style="margin-right: 50px;">
                                <br>
                                <h3>Customer Info</h3>
                                <form class="row tracking_form" action="#" method="post" novalidate="novalidate">
                                    <div class="col-md-12 form-group">
                                        <label>Name: <%= cust.getCustomerName()%></label>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label>Email: <%= cust.getEmail()%></label>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label>Contact Number: <%= cust.getCustomerContact()%></label>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <button type="submit" value="submit" class="primary-btn"><a href="LogoutCustomerController">Logout</a></button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-8">
                                <div class="order_box">
                                    <h2>Your Order</h2>
                                    <table class="table" border="1" style="width: 800px;">
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Address</th>
                                            <th>Product Name</th>
                                            <th>Date</th>
                                            <th>Total Amount</th>
                                            <th>Payment Method</th>
                                            <th>Status</th>
                                        </tr>
                                        <% for (Orders exists : existsO) {
                                                if (cust.getCustomerId() == exists.getCustomerId().getCustomerId()) {
                                        %>
                                        <tr>
                                            <td><%= exists.getOrderId()%></td>
                                            <td>
                                                <%= exists.getAddressLineOne()%><br><%= exists.getAddressLineTwo()%>
                                            </td>
                                            <td>
                                                <% for (OrderList OL : existsOL) {
                                                        if (exists.getOrderId() == OL.getOrderId().getOrderId()) {
                                                            out.println("@" + OL.getProductId().getProductname());
                                                            out.println("x" + OL.getQty());
                                                            out.println("<br>");
                                                        }
                                                    }
                                                %>                                        
                                            </td>
                                            <td><%= sdf.format(exists.getPaymentId().getDate())%></td>
                                            <td><%= String.format("%.2f", exists.getPaymentId().getAmount())%></td>
                                            <%
                                                String status = "";
                                                if (exists.getStatus() == 0) {
                                                    status += "Pending";
                                                } else if (exists.getStatus() == 1) {
                                                    status += "Delivered";
                                                }
                                            %>
                                            <td><%= exists.getPaymentId().getPaymentMethod()%></td>
                                            <td><%= status%></td>
                                            <%--<input class="primary-btn" name="id" type="hidden" value="<%= o.getOrderId() %>">
                                            <td><button class="primary-btn" type="submit">remove</button></td>--%>
                                        </tr> 
                                        <%
                                                }
                                            }
                                        %>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Checkout Area =================-->
        <%
    } else {%>

        <%
            List<Orders> allorder = (List) session.getAttribute("order");
            List<Customer> allcust = (List) session.getAttribute("cust");
            List<OrderList> allorderL = (List) session.getAttribute("orderL");

            int customerId = order.getCustomerId().getCustomerId();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        %>
        <!--================Checkout Area =================-->
        <section class="checkout_area section_gap">
            <div class="container">
                <div class="billing_details">
                    <div class="row"  style="width: 1350px;">
                        <div class="col-lg-2" style="margin-right: 50px;">
                            <br>
                            <h3>Customer Info</h3>
                            <form class="row tracking_form" action="#" method="post" novalidate="novalidate">
                                <div class="col-md-12 form-group">
                                    <label>Name: <%= order.getCustomerId().getCustomerName()%></label>
                                </div>
                                <div class="col-md-12 form-group">
                                    <label>Email: <%= order.getCustomerId().getEmail()%> </label>
                                </div>
                                <div class="col-md-12 form-group">
                                    <label>Contact Number: <%= order.getCustomerId().getCustomerContact()%></label>
                                </div>
                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit" class="primary-btn"><a href="LogoutCustomerController">Logout</a></button>
                                </div>
                            </form>
                        </div>
                        <div class="col-lg-8">
                            <div class="order_box">
                                <h2>Your Order</h2>
                                <table class="table" border="1" style="width: 800px;">
                                    <tr>
                                        <th>Order ID</th>
                                        <th>Address</th>
                                        <th>Product Name</th>
                                        <th>Date</th>
                                        <th>Total Amount</th>
                                        <th>Payment Method</th>
                                        <th>Status</th>
                                    </tr>
                                    <% for (Orders o : allorder) {
                                        if (o.getCustomerId().getCustomerId() == customerId) {%>
                                    <tr>
                                        <td><%= o.getOrderId()%></td>
                                        <td><%= o.getAddressLineOne()%><br><%= o.getAddressLineTwo()%></td>
                                        <td>
                                            <% for (OrderList ol : allorderL) {
                                                    if (o.getOrderId() == ol.getOrderId().getOrderId()) {
                                                        out.println("@" + ol.getProductId().getProductname());
                                                        out.println("x" + ol.getQty());
                                                        out.println("<br>");
                                                    }
                                                }
                                            %>
                                        </td>
                                        <td><%= sdf.format(o.getPaymentId().getDate())%></td>
                                        <td><%= String.format("%.2f", o.getPaymentId().getAmount())%></td>
                                        <%
                                            String status = "";
                                            if (o.getStatus() == 0) {
                                                status += "Pending";
                                            } else if (o.getStatus() == 1) {
                                                status += "Delivered";
                                            }
                                        %>
                                        <td><%= o.getPaymentId().getPaymentMethod()%></td>
                                        <td><%= status%></td>
                                        <%--<input class="primary-btn" name="id" type="hidden" value="<%= o.getOrderId() %>">
                                        <td><button class="primary-btn" type="submit">remove</button></td>--%>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>                                    
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Checkout Area =================-->
    <% }%>


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