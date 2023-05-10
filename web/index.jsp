<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <%@ include file = "header.jsp" %>
    <jsp:include page="DisplayProductIndex"></jsp:include>
    <%    List<Product> prodList = (List) session.getAttribute("prodList"); %>
    <body>

        <%@ include file = "navbar.jsp" %>

        
        <!-- start banner Area -->
        <section class="banner-area">
            <div class="container">
                <div class="row fullscreen align-items-center justify-content-start">
                    <div class="col-lg-12">
                        <div class="active-banner-slider owl-carousel">
                            <!-- single-slide -->
                            <div class="row single-slide align-items-center d-flex">
                                <div class="col-lg-5 col-md-6">
                                    <div class="banner-content">
                                        <h1>Welcome To <br>DoStyle</h1>
                                        <p>Welcome to DoStyle, your one-stop shop for stylish and affordable clothing! We're passionate about helping you look and feel your best, 
                                            no matter the occasion. From casual wear to formal attire, we've got you covered with a wide range of clothing options to suit any taste 
                                            and budget. Our friendly and knowledgeable staff are always here to help you find exactly what you need, so don't hesitate to reach out 
                                            if you have any questions. Thank you for choosing DoStyle - we look forward to helping you create your perfect look!</p>
                                        
                                    </div>
                                </div>
                                <div class="col-lg-7">
                                    <div class="banner-img">
                                        <img class="img-fluid" src="img/banner/index-banner4.jpg" alt="">
                                    </div>
                                </div>
                            </div>
                            <!-- single-slide -->
                            <div class="row single-slide">
                                <div class="col-lg-5">
                                    <div class="banner-content">
                                        <h1>Our Clothing <br>Collection!</h1>
                                        <p>At DoStyle, we're confident that you'll love our clothing just as much as we do. From the quality of our materials to the attention to detail 
                                            in our designs, we're committed to providing you with clothing that not only looks great, but feels great to wear too. Whether you're shopping 
                                            for yourself or for a loved one, we've got a wide range of styles and sizes to choose from, so you're sure to find something that suits your 
                                            unique taste and personality. So why wait? Head over to product section to find your clothing pieces.</p>
                                        <div class="add-bag d-flex align-items-center">
                                            <a class="add-btn" href=""><span class="lnr lnr-arrow-right"></span></a>
                                            <span class="add-text text-uppercase">Go To Product</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-7">
                                    <div class="banner-img">
                                        <img class="img-fluid" src="img/banner/index-banner3.jpg" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End banner Area -->

        <!-- start features Area -->
        <section class="features-area section_gap">
            <div class="container">
                <div class="row features-inner">
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon1.png" alt="">
                            </div>
                            <h6>Delivery</h6>
                            <p>Provide delivery on all order</p>
                        </div>
                    </div>
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon2.png" alt="">
                            </div>
                            <h6>Return Policy</h6>
                            <p>No Return Policy</p>
                        </div>
                    </div>
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon3.png" alt="">
                            </div>
                            <h6>24/7 Support</h6>
                            <p>Handle question all time</p>
                        </div>
                    </div>
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon4.png" alt="">
                            </div>
                            <h6>Secure Payment</h6>
                            <p>Secure and reasonable price</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end features Area -->


        <!-- start product Area -->
        <section >
            <!-- single product slide -->
            
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-6 text-center">
                            <div class="section-title">
                                <h1>Latest Products</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                    dolore
                                    magna aliqua.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- single product -->
                        <% for (int i = 0; i < 4 && i < prodList.size(); i++) { Product product = (Product) prodList.get(i);%>
                            <div class="col-lg-4 col-md-6">
                                <div class="single-product">
                                    <img class="img-fluid" src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(product.getImage())) %>" alt="<%= product.getProductname() %>">
                                    <!-- show product name -->
                                    <div class="product-details">
                                        <h6><%= product.getProductname()%></h6>

                                        <!-- show product price -->
                                        <div class="price">
                                            <h6>RM<%= String.format("%.2f", product.getPrice())%></h6>
                                        </div>

                                        <!-- click for add to cart -->
                                        <div class="prd-bottom">
                                            <a href="CartServlet?id=<%= product.getProductid()%>&action=addtocart" class="social-info">
                                                <span class="ti-shopping-cart"></span>
                                                <p class="hover-text">Add Cart</p>
                                            </a>

                                            <a href="CartServlet?id=<%= product.getProductid()%>&action=buynow" class="social-info">
                                                <span class="ti-bag"></span>
                                                <p class="hover-text">Buy Now</p>
                                            </a>

                                            <!-- click to view more (navigate to ProductDetails) -->
                                            <a href="ProductDetails?prodID=<%= product.getProductid()%>&catID=<%= product.getCategorycode().getCategoryid()%>" class="social-info">
                                                <span class="lnr lnr-move"></span>
                                                <p class="hover-text">view more</p>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <% }%>
                    </div>
                </div>
            
            
        </section>
        <!-- end product Area -->




        <%@ include file = "footer.jsp" %>
    </body>

</html>