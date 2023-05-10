<%-- 
    Document   : CardInfo
    Created on : May 2, 2023, 3:22:43 AM
    Author     : Kyan
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <h1>Checkout</h1>
                        <nav class="d-flex align-items-center">
                            <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="single-product.html">Card Information</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Card Info Area=================-->
        <section class="checkout_area section_gap">
            <div class="container">
                <div class="billing_details">
                    <form class="row contact_form" method="POST" action="CartServlet?action=payCard" onsubmit="return validateCard();">
                        <div class="row">
                            <div class="col-lg-8">
                                <h3>Your Card Information</h3>
                                <div class="col-md-12 form-group p_star">
                                    <h6>Card Number: </h6>
                                    <input type="text" class="form-control" id="CardNum" name="CardNum" placeholder=" 16-digit card number" required="required">
                                    <span class="placeholder" placeholder="Card Number"></span>
                                </div>                                
                                <div class="col-md-5 form-group p_star">
                                    <h6>Expiration Date: </h6>
                                    <input type="text" class="form-control" id="ExpDate" name="ExpDate" placeholder=" MM/YY" required="required">
                                    <span class="placeholder" placeholder="Expiration Date"></span>
                                </div>
                                <div class="col-md-6 form-group p_star">
                                    <h6>CVV security code: </h6>
                                    <input type="text" class="form-control" id="cvv" name="cvv" placeholder=" 3-digit code" required="required">
                                    <span class="placeholder" placeholder="CVV security code"></span>
                                </div>
                                <input type="hidden" name="add1" value="${param.add1}">
                                <input type="hidden" name="add2" value="${param.add2}">
                                <input type="hidden" name="city" value="${param.city}">
                                <input type="hidden" name="zip" value="${param.zip}">
                                <input type="hidden" name="amount" value="${param.amount}">
                                <button class="primary-btn" type="submit" >Proceed to Pay</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!--================End Card Info Area =================-->

        <script>
            function validateCard() {
                var cardNum = document.getElementById("CardNum").value;
                var expDate = document.getElementById("ExpDate").value;
                var cvv = document.getElementById("cvv").value;

                // Validate card number
                if (!/^\d{16}$/.test(cardNum)) {
                    alert("Please enter a valid 16-digit card number.");
                    return false;
                }

                // Validate expiration date
                if (!/^(0[1-9]|1[0-2])\/\d{2}$/.test(expDate)) {
                    alert("Please enter a valid expiration date in MM/YY format.");
                    return false;
                }

                // Validate CVV
                if (!/^\d{3}$/.test(cvv)) {
                    alert("Please enter a valid 3-digit CVV.");
                    return false;
                }

                return true;
            }
        </script>

        <%@ include file = "footer.jsp" %>
    </body>

</html>