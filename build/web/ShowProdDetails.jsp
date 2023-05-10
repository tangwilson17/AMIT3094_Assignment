<%-- 
    Document   : ProductDetails
    Created on : Apr 23, 2023, 8:11:51 PM
    Author     : mayte
--%>

<%@page import="java.util.Base64"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="prod" scope="session" class="entity.Product"/>

<!DOCTYPE html>
<html>
    <html lang="zxx" class="no-js">

        <%@ include file = "header.jsp" %>

        <%
            Category category = (Category) session.getAttribute("category");
        %>
        <body>
            <%@ include file = "navbar.jsp" %>


            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Product Details Page</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                                <a href="single-product.html">product-details</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->

            <!--================Single Product Area =================-->
            <div class="product_image_area">
                <div class="container">
                    <div class="row s_product_inner">
                        <div class="col-lg-6">
                            <div class="single-prd-item">
                                <img class="img-fluid" src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(prod.getImage()))%>" alt="<%= prod.getProductname()%>">
                            </div>

                        </div>

                        <div class="col-lg-5 offset-lg-1">
                            <div class="s_product_text">
                                <h3>${prod.productname}</h3>
                                <h2>RM<%= String.format("%.2f", prod.getPrice())%></h2>
                                <ul class="list">
                                    <li><span>Category</span> : ${category.categoryname}</li>
                                    <li><span>Material</span> : ${category.categorydesc}</li>
                                    <li><span>Stock Status</span> : 
                                        <%
                                            int status = prod.getStatus(); // Get the status value from the prod object
                                            if (status == 0) {
                                        %>
                                        Out of Stock
                                        <%
                                        } else if (status == 1) {
                                        %>
                                        In Stock
                                        <%
                                            }
                                        %></li>
                                </ul>

                                <div class="product_count">
                                    <%
                                        if (prod.getQty() > 0) {
                                    %>
                                    <label for="qty">Quantity:</label>
                                    <input type="number" name="qty" min="1" max="${prod.qty}" value="1" class="input-text qty">
                                    <br><br>
                                    <div class="card_area d-flex align-items-center">
                                        <a class="primary-btn" href="CartServlet?id=<%= prod.getProductid()%>&action=addtocart">Add to Cart</a>
                                        <a class="primary-btn" href="CartServlet?id=<%= prod.getProductid()%>&action=buynow" style="margin-left: 10px;">Buy now</a>                                        <%
                                        } else {
                                        %>
                                        <br>
                                        <b style="color: red;">Sold Out</b>
                                        <%
                                            }
                                        %>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--================End Single Product Area =================-->

            <!--================Product Description Area =================-->
            <section class="product_description_area">
                <div class="container">
                    <div class="tab-content" id="myTabContent">
                        <h2>Product Description</h2>
                        <p><%= prod.getDescription().replaceAll("!", "<br>")%></p>
                    </div>
            </section>
            <!--================End Product Description Area =================-->

            <%@ include file = "footer.jsp" %>



        </body>
    </html>
