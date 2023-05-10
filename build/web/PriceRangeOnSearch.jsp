<%-- 
    Document   : PriceRangeResult
    Created on : Apr 25, 2023, 8:49:52 PM
    Author     : mayte
--%>
<%@page import="java.util.Base64"%>
<%@page import="entity.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>

<!DOCTYPE html>

<html lang="zxx" class="no-js">

    <%@ include file = "header.jsp" %>

    <%
        List<Product> prodList = (List) session.getAttribute("prodList");
    %> 
    <%
        List<Category> category = (List) session.getAttribute("catList");
    %>
    <%
        Double minPrice = (Double) session.getAttribute("minPrice");
        Double maxPrice = (Double) session.getAttribute("maxPrice");
    %>
    <%
        String searchProd = (String) session.getAttribute("searchProd");
    %>

    <body id="category">

        <%@ include file = "navbar.jsp" %>


        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h2 style="color:white; font-weight: bold; margin-right: -25px;">Products between RM<%= String.format("%.2f", minPrice)%> - RM<%= String.format("%.2f", maxPrice)%> </h2>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!-- Browse Categories -->
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-4 col-md-5">
                    <div class="sidebar-categories">
                        <div class="head">Browse Categories</div>
                        <ul class="main-categories">
                            <li class="main-nav-list"><a href="DisplayProduct">All</a></li>
                                <% for (Category c : category) {%>
                            <li class="main-nav-list">
                                <a href="BrowseCategory?categoryID=<%=c.getCategoryid()%>&categoryName=<%=c.getCategoryname()%>">
                                    <%=c.getCategoryname()%></a>

                                <%}%>
                            </li>
                        </ul>
                    </div>
                    <!-- End Browse Categories 
            
                    <!-- Filter price range -->
                    <div class="sidebar-filter mt-50">
                        <div class="top-filter-head">Price Range</div>              
                        <form action="PriceRangeOnSearch" method="post">
                            <div class="common-filter">
                                <div style="margin-left: 15px" >
                                    <div class="head">Price</div>                                    
                                    <input type="hidden" name="searchProd" value="<%= searchProd%>">
                                    <input type="text" id="minNum" name="minNum" size="5" required> to 
                                    <input type="text" id="maxNum" name="maxNum" size="5" required><button type="submit" class="btn btn-outline-dark" style="margin-left: 12px; font-size: 11px;">Apply</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- End Filter price range -->

                <div class="col-xl-9 col-lg-8 col-md-7">
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                        <div class="sorting">
                            <select onchange="location.href = 'FilterOnSearchPriceRange?searchProd=<%=searchProd%>&minNum=<%= minPrice%>&maxNum=<%= maxPrice%>&filter=' + this.value;">
                                <option value="1">Price Low to High</option>
                                <option value="2">Price High to Low</option>
                                <option value="3">Product Name A-Z</option>
                                <option value="4">Product Name Z-A</option>
                            </select>
                        </div>
                    </div>
                    <!-- End Filter Bar -->

                    <!-- Start Display Product -->
                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row">
                            <!-- single product -->
                            <% for (Product prod : prodList) {%>
                            <div class="col-lg-4 col-md-6">
                                <div class="single-product">
                                    <form method="POST" action="ProductDetails">
                                        <img class="img-fluid" src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(prod.getImage()))%>" alt="<%= prod.getProductname()%>">
                                        <!-- show product name -->
                                        <div class="product-details">
                                            <h6><%= prod.getProductname()%></h6>

                                            <!-- show product price -->
                                            <div class="price">
                                                <h6>RM<%= String.format("%.2f", prod.getPrice())%></h6>
                                            </div>

                                            <!-- click for add to cart -->
                                            <div class="prd-bottom">
                                                <a href="CartServlet?id=<%= prod.getProductid()%>&action=addtocart" class="social-info">
                                                    <span class="ti-shopping-cart"></span>
                                                    <p class="hover-text">Add Cart</p>
                                                </a>

                                                <a href="CartServlet?id=<%= prod.getProductid()%>&action=buynow" class="social-info">
                                                    <span class="ti-bag"></span>
                                                    <p class="hover-text">Buy Now</p>
                                                </a>

                                                <!-- click to view more (navigate to ProductDetails) -->
                                                <a href="ProductDetails?prodID=<%= prod.getProductid()%>&catID=<%= prod.getCategorycode().getCategoryid()%>" class="social-info">
                                                    <span class="lnr lnr-move"></span>
                                                    <p class="hover-text">view more</p>
                                                </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <% }%>
                        </div>
                    </section>
                </div>
            </div>
        </div>

        <%@ include file = "footer.jsp" %>

    </body>
</html>


