<!DOCTYPE html>
<html lang="zxx" class="js">

    <%@ include file = "header.jsp" %>

    <body class="nk-body bg-lighter npc-default has-sidebar ">
        <div class="nk-app-root">
            <!-- main @s -->
            <div class="nk-main ">
                <!-- wrap @s -->
                <div class="nk-wrap nk-wrap-nosidebar">
                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="nk-block nk-block-middle nk-auth-body  wide-xs">
                            <div class="brand-logo pb-4 text-center">
                                <a href="html/index.html" class="logo-link">
                                    
                                    <img class="logo-dark logo-img logo-img-lg" src="<%= getServletContext().getInitParameter("webLogo") %>" srcset="./images/logo-dark2x.png 2x" alt="logo-dark">
                                </a>
                            </div>
                            <div class="card">
                                <div class="card-inner card-inner-lg">
                                    <div class="nk-block-head">
                                        <div class="nk-block-head-content">
                                            <h4 class="nk-block-title">Sign-In</h4>
                                            <div class="nk-block-des">
                                                <p>Access the Dostyle admin panel using your email and passcode.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <form action="LoginOperation" method="POST">
                                        <div class="form-group">
                                            <div class="form-label-group">
                                                <label class="form-label" for="default-01">Email</label>
                                            </div>
                                            <div class="form-control-wrap">
                                                <input type="text" class="form-control form-control-lg" name="email" id="default-01" placeholder="Enter your email address">
                                                <span class="text-danger">
                                                    <%
                                                        if (session.getAttribute("emailError") != null && session.getAttribute("emailError") != "") {
                                                            out.print(session.getAttribute("emailError"));
                                                        }
                                                    %>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-label-group">
                                                <label class="form-label" for="password">Passcode</label>
                                            </div>
                                            <div class="form-control-wrap">
                                                <a href="#" class="form-icon form-icon-right passcode-switch lg" data-target="password">
                                                    <em class="passcode-icon icon-show icon ni ni-eye"></em>
                                                    <em class="passcode-icon icon-hide icon ni ni-eye-off"></em>
                                                </a>
                                                <input type="password" class="form-control form-control-lg" name="password" id="password" placeholder="Enter your passcode">
                                                <span class="text-danger">
                                                    <%
                                                        if (session.getAttribute("passwordError") != null && session.getAttribute("emailError") != "") {
                                                            out.print(session.getAttribute("passwordError"));
                                                        }
                                                    %>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-lg btn-primary btn-block">Sign in</button>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <%@ include file = "footer.jsp" %>
                    </div>
                    <!-- wrap @e -->
                </div>
            </div>
            <!-- main @e -->
        </div>
        <!-- app-root @e -->
        <!-- JavaScript -->
        <script src="./assets/js/bundle.js?ver=3.1.0"></script>
        <script src="./assets/js/scripts.js?ver=3.1.0"></script>
        <script src="./assets/js/charts/chart-ecommerce.js?ver=3.1.0"></script>
    </body>

</html>

<!--SQL CODE FOR AUTO INCREMENT ID
CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(140) NOT NULL,
product_price DOUBLE,
product_image BLOB);-->


