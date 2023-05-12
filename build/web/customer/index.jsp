<%@page import="java.util.Base64"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <%@ include file = "header.jsp" %>
    <body>

        <%@ include file = "navbar.jsp" %>

        <jsp:include page="../DisplayProductIndex"></jsp:include>
        <%    List<Product> prodList = (List) session.getAttribute("prodList");%>
        <section id="billboard">

            <div class="container">
                <div class="row">
                    <div class="col-md-12">

                        <button class="prev slick-arrow">
                            <i class="icon icon-arrow-left"></i>
                        </button>

                        <div class="main-slider pattern-overlay">
                            <%
                                for (int i = 0; i < 2 && i < prodList.size(); i++) {
                                    Product product = (Product) prodList.get(i);

                            %>
                            <div class="slider-item">
                                <div class="banner-content">
                                    <h2 class="banner-title"><%= product.getProductname() %></h2>
                                    <p><%= product.getDescription() %></p>
                                    <div class="btn-wrap">
                                        <a href="../ProductDetails?prodID=<%= product.getProductid()%>&catID=<%= product.getCategorycode().getCategoryid()%>" class="btn btn-outline-accent btn-accent-arrow">Read More<i class="icon icon-ns-arrow-right"></i></a>
                                    </div>
                                </div><!--banner-content--> 
                                <img src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(product.getImage()))%>" alt="banner" class="banner-image">
                            </div><!--slider-item-->
                            <%}%>

                        </div><!--slider-->

                        <button class="next slick-arrow">
                            <i class="icon icon-arrow-right"></i>
                        </button>

                    </div>
                </div>
            </div>

        </section>

        <section id="client-holder" data-aos="fade-up">
            <div class="container">
                <div class="row">
                    <div class="inner-content">
                        <div class="logo-wrap">
                            <div class="grid">
                                <a href="#"><img src="images/client-image1.png" alt="client"></a>
                                <a href="#"><img src="images/client-image2.png" alt="client"></a>
                                <a href="#"><img src="images/client-image3.png" alt="client"></a>
                                <a href="#"><img src="images/client-image4.png" alt="client"></a>
                                <a href="#"><img src="images/client-image5.png" alt="client"></a>
                            </div>
                        </div><!--image-holder-->
                    </div>
                </div>
            </div>
        </section>

        <section id="featured-books">
            
            <div class="container">
                <div class="row">
                    <div class="col-md-12">

                        <div class="section-header align-center">
                            <div class="title">
                                <span>Some quality items</span>
                            </div>
                            <h2 class="section-title">Featured Books</h2>
                        </div>

                        <div class="product-list" data-aos="fade-up">
                            <div class="row">
                            <%
                                for (int i = 0; i < 4 && i < prodList.size(); i++) {
                                    Product product = (Product) prodList.get(i);

                            %>
                                <div class="col-md-3">
                                    <figure class="product-style">
                                        <img src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(product.getImage()))%>" alt="Books" class="product-item">
                                        <figcaption>
                                            <h3><a href="../ProductDetails?prodID=<%= product.getProductid()%>&catID=<%= product.getCategorycode().getCategoryid()%>"><%= product.getProductname() %></a></h3>
                                            <p><%= product.getCategorycode().getCategoryid() %></p>
                                            <div class="item-price">RM <%= product.getPrice() %></div>
                                        </figcaption>
                                    </figure>
                                </div>
                                <%}%>
                            </div><!--ft-books-slider-->				
                        </div><!--grid-->


                    </div><!--inner-content-->
                </div>

                <div class="row">
                    <div class="col-md-12">

                        <div class="btn-wrap align-right">
                            <a href="../DisplayProduct" class="btn-accent-arrow">View all products <i class="icon icon-ns-arrow-right"></i></a>
                        </div>

                    </div>		
                </div>
            </div>
        </section>

      
        <%@ include file = "footer.jsp" %>

        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/script.js"></script>

    </body>
</html>	