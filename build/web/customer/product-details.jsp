
<%@page import="java.util.Base64"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="prod" scope="session" class="entity.Product"/>
<!DOCTYPE html>
        <%
            Category category = (Category) session.getAttribute("category");
        %>
	<html lang="en">
    <%@ include file = "header.jsp" %>

<body>

    <%@ include file = "navbar.jsp" %>

<section class="bg-sand padding-large">
	<div class="container">
		<div class="row">

			<div class="col-md-6">
				<a href="#" class="product-image"><img src="data:image/png;base64,<%= new String(Base64.getEncoder().encode(prod.getImage()))%>"></a>
			</div>

			<div class="col-md-6 pl-5">
				<div class="product-detail">
					<h1>${prod.productname}</h1>
					<p>${category.categoryname}</p>
					<span class="price colored">RM<%= String.format("%.2f", prod.getPrice())%></span>

					<p>
					<%= prod.getDescription().replaceAll("!", "<br>")%>
					</p>

				<a href="../CartServlet?id=3&amp;action=addtocart"><button type="submit" name="add-to-cart" value="27545" class="button">Add to cart</button>
                                </a>
					
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