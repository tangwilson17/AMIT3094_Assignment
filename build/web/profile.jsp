<%-- 
    Document   : profile
    Created on : May 2, 2023, 4:44:13 PM
    Author     : Kyan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Customer"%>
<%@page import="entity.OrderList"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Orders order = (Orders) session.getAttribute("orderInfo");

    Customer cust = (Customer) session.getAttribute("customer");
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
                        <h1>Hi!&nbsp;<%= cust.getCustomerName()%><br>This is Your Profile</h1>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

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



<%@ include file = "footer.jsp" %>


</body>

</html>
