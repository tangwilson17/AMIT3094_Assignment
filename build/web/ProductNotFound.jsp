<%-- 
    Document   : ProductNotFound
    Created on : Apr 29, 2023, 5:42:36 PM
    Author     : mayte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <%@ include file = "header.jsp" %>

    <style>
        a:hover {
            color: white;
        }
        .hyperlinkText{
            text-align: center;
        }
        a{
            font-size: 15px;
        }
        p{
            text-align: center;
            font-weight: bold;
            font-size: 20px;
        }
    </style>
    <% String searchProd = (String) session.getAttribute("searchProd");%>
    <body>
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <img src="img/product/no-product.png">
                        <p>No product match with "<%= searchProd%>"</p>
                        <br>
                        <div class="hyperlinkText">
                            <a href="DisplayProduct">Back to Product Page</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
