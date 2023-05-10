<!-- Start Header Area -->
<header class="header_area sticky-header">
    <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light main_box">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                    <ul class="nav navbar-nav menu_nav ml-auto">
                        <li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="background.jsp">About Us</a></li>
                        <li class="nav-item submenu dropdown">
                            <a href="DisplayProduct" class="nav-link dropdown-toggle">Shop</a>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%
                            if (session.getAttribute("customer") != null) {
                        %>
                        <li class="nav-item"><a href="DisplayProfile" class="cart"><span class="ti-id-badge">&nbsp;Profile</span></a></li>
                                <% } else {%>
                        <li class="nav-item"><a class="cart" href="login.jsp"><span class="lnr lnr-user"></span></a></li>
                            <% }%>
                        <li class="nav-item"><a href="CartServlet" class="cart"><span class="lnr lnr-cart"></span></a></li>
                        <li class="nav-item">
                            <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="search_input" id="search_input_box">
        <div class="container">
            <form class="d-flex justify-content-between" method="POST" action="searchProduct">
                <input type="text" class="form-control" id="search_input" placeholder="Search Here" name="searchProd">
                <button type="submit" class="btn"></button>
                <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
            </form>
        </div>
    </div>
</header>
<!-- End Header Area -->