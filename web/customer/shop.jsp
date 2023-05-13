<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<!DOCTYPE html>

<%
    List<Product> prodList = (List) session.getAttribute("prodList");
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
                                <h1 class="page-title">Shop</h1>
                                <div class="breadcum-items">
                                    <span class="item"><a href="index.html">Home /</a></span>
                                    <span class="item colored">Shop</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--site-banner-->

            <section class="padding-large">
                <div class="container">
                    <div class="row">

                        <div class="products-grid grid">
                            <% for (Product prod : prodList) {%>
                            <figure class="product-style">
                                <a href="../ProductDetails?prodID=<%= prod.getProductid()%>&catID=<%= prod.getCategorycode().getCategoryid()%>">
                                <img src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(prod.getImage()))%>" alt="Books" class="product-item"></a>

                                <!--new button-->
                                <a href="../CartServlet?id=<%= prod.getProductid()%>&action=addtocart"  style="display: flex; justify-content: center;"><button type="submit" name="add-to-cart" value="27545" class="button" >Add to cart</button>
                                </a>



                                <figcaption>
                                    <a href="../ProductDetails?prodID=<%= prod.getProductid()%>&catID=<%= prod.getCategorycode().getCategoryid()%>"><%= prod.getProductname()%></a>
                                    <div class="item-price">RM<%= String.format("%.2f", prod.getPrice())%></div>
                                </figcaption>
                            </figure>
                            <% }%>    
                        </div>

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