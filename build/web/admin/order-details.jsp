<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Base64"%>
<%@page import="entity.OrderList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entity.Orders"%>
<%@page import="entity.Customer"%>
<!DOCTYPE html>
<html lang="zxx" class="js">

    <%@ include file = "header.jsp" %>

    <body class="nk-body bg-lighter npc-default has-sidebar ">
        <div class="nk-app-root">
            <!-- main @s -->
            <div class="nk-main "> 
                <%@ include file = "sidebar.jsp" %>
                <!-- wrap @s -->
                <div class="nk-wrap ">
                    <%@ include file = "navbar.jsp" %>
                    <%
                        Orders order = (Orders) session.getAttribute("orders-detail");
                        Date date = order.getPaymentId().getDate();
                        DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String outputDateStr = outputDateFormat.format(date);
                    %>
                    <jsp:include page="/admin/GetOrdersProduct"></jsp:include>
                    <%
                        List<OrderList> ordersProductList = (List<OrderList>) session.getAttribute("orders-list-detail");
                    %>

                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block">
                                        <div class="card col-12">
                                            <div class="card-content">
                                                <form action="UpdateCustomer" method="POST">
                                                    <input type="hidden" name="order-id" value="<%= order.getOrderId()%>">
                                                    <div class="card-inner">
                                                        <div class="nk-block">
                                                            <div class="nk-block-head d-flex justify-between">
                                                                <h5 class="title">Order Details</h5>
                                                                <%
                                                                    if (order.getStatus() == 0) {
                                                                %>
                                                                <div>
                                                                    <button type="button" onclick="completeOrder()" class="btn btn-success ms-2">Complete</button>
                                                                    <button type="button" onclick="delOrder()" class="btn btn-danger ms-2">Delete</button>
                                                                </div>
                                                                <%}%>
                                                            </div><!-- .nk-block-head -->
                                                            <div class="row mb-5">
                                                                <div class="col-3 d-flex flex-column align-center">
                                                                    <span class="profile-ud-label">Total</span>
                                                                    <span class="profile-ud-value"><%= order.getPaymentId().getAmount()%> MYR</span>
                                                                </div>
                                                                <div class="col-3 d-flex flex-column align-center">
                                                                    <span class="profile-ud-label">Date Ordered</span>
                                                                    <span class="profile-ud-value"><%= outputDateStr%></span>
                                                                </div>
                                                                <div class="col-3 d-flex flex-column align-center">
                                                                    <span class="profile-ud-label">Payment Method</span>
                                                                    <span class="profile-ud-value"><%= order.getPaymentId().getPaymentMethod()%></span>
                                                                </div>
                                                                <div class="col-3 d-flex flex-column align-center">
                                                                    <span class="profile-ud-label">Status</span>
                                                                    <span class="profile-ud-value">
                                                                        <%
                                                                            if (order.getStatus() == 0) {
                                                                                out.print("<span class='dot bg-warning d-sm-none'></span><span class='badge badge-sm badge-dot has-bg bg-warning d-none d-sm-inline-flex'>Delivering</span>");
                                                                            } else {
                                                                                out.print("<span class='dot bg-success d-sm-none'></span><span class='badge badge-sm badge-dot has-bg bg-success d-none d-sm-inline-flex'>Completed</span>");
                                                                            }
                                                                        %>
                                                                    </span>
                                                                </div>
                                                            </div>

                                                            <table class="datatable-init nowrap nk-tb-list is-separate" data-auto-responsive="false">
                                                                <thead>
                                                                    <tr class="nk-tb-item nk-tb-head">
                                                                        <th class="nk-tb-col tb-col-sm"><span>Name</span></th>
                                                                        <th class="nk-tb-col"><span>Category</span></th>
                                                                        <th class="nk-tb-col"><span>Qty</span></th>
                                                                        <th class="nk-tb-col tb-col-md"><span>Price</span></th>

                                                                    </tr><!-- .nk-tb-item -->
                                                                </thead>
                                                                <tbody>
                                                                    <%
                                                                        for (OrderList orderDetails : ordersProductList) {
                                                                            String base64img = Base64.getEncoder().encodeToString(orderDetails.getProductId().getImage());
                                                                    %>
                                                                    <tr class="nk-tb-item">

                                                                        <td class="nk-tb-col tb-col-sm">
                                                                            <span class="tb-product">
                                                                                <img src="data:image/png;base64, <%= base64img%>" alt="" class="thumb">
                                                                                <span class="title"><%= orderDetails.getProductId().getProductname()%></span>
                                                                            </span>
                                                                        </td>
                                                                        <td class="nk-tb-col">
                                                                            <span class="tb-lead"><%= orderDetails.getProductId().getCategorycode().getCategoryname()%></span>
                                                                        </td>
                                                                        <td class="nk-tb-col">
                                                                            <span class="tb-sub"><%= orderDetails.getQty()%></span>
                                                                        </td>
                                                                        <td class="nk-tb-col tb-col-md">
                                                                            <span class="tb-sub"><%= orderDetails.getProductId().getPrice()%> MYR</span>
                                                                        </td>
                                                                    </tr><!-- .nk-tb-item -->
                                                                    <%
                                                                        }
                                                                    %>
                                                                </tbody>

                                                            </table><!-- .nk-tb-list -->
                                                        </div><!-- .nk-block -->

                                                    </div><!-- .card-inner -->
                                                </form>
                                            </div><!-- .card-content -->

                                        </div><!-- .card -->
                                    </div><!-- .nk-block -->


                                    <div class="nk-block">
                                        <div class="card col-7">
                                            <div class="card-content">
                                                <form action="UpdateCustomer" method="POST">
                                                    <input type="hidden" name="order-id" value="<%= order.getOrderId()%>">
                                                    <div class="card-inner">
                                                        <div class="nk-block">
                                                            <div class="nk-block-head">
                                                                <h5 class="title">Customer Information</h5>
                                                            </div><!-- .nk-block-head -->
                                                            <div class="profile-ud-list">
                                                                <div class="profile-ud-item">
                                                                    <div class="profile-ud wider">
                                                                        <span class="profile-ud-label">Name</span>
                                                                        <span class="profile-ud-value"><%= order.getCustomerId().getCustomerName()%></span>
                                                                    </div>
                                                                </div>
                                                                <div class="profile-ud-item">
                                                                    <div class="profile-ud wider">
                                                                        <span class="profile-ud-label">Email</span>
                                                                        <span class="profile-ud-value"><%= order.getCustomerId().getEmail()%></span>
                                                                    </div>
                                                                </div>
                                                                <div class="profile-ud-item">
                                                                    <div class="profile-ud wider">
                                                                        <span class="profile-ud-label">Contact</span>
                                                                        <span class="profile-ud-value"><%= order.getCustomerId().getCustomerContact()%></span>
                                                                    </div>
                                                                </div>
                                                                <div class="profile-ud-item">
                                                                    <div class="profile-ud wider">
                                                                        <span class="profile-ud-label">Contact</span>
                                                                        <span class="profile-ud-value"><%= order.getAddressLineOne() + order.getAddressLineTwo()%></span>
                                                                    </div>
                                                                </div>

                                                            </div><!-- .profile-ud-list -->
                                                        </div><!-- .nk-block -->

                                                    </div><!-- .card-inner -->
                                                </form>
                                            </div><!-- .card-content -->

                                        </div><!-- .card -->
                                    </div><!-- .nk-block -->
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- content @e -->
                    <%@ include file = "footer.jsp" %>
                </div>
                <!-- wrap @e -->
            </div>
            <!-- main @e -->
        </div>
        <!-- app-root @e -->
        <!-- JavaScript -->
        <script src="./assets/js/bundle.js?ver=3.1.0"></script>
        <script src="./assets/js/scripts.js?ver=3.1.0"></script>
        <script src="./assets/js/charts/chart-ecommerce.js?ver=3.1.0"></script>
        <%
            try {
                int error = (Integer) session.getAttribute("error");
                if (error == 1) {
                    out.print("<script>Swal.fire({"
                            + "icon: 'error',"
                            + "title: 'Oops...',"
                            + "text: `" + session.getAttribute("error_msg") + "`"
                            + "})" + "</script>");
                    session.setAttribute("error", 0);
                }
            } catch (Exception e) {

            }
        %>

        <%
            if (order.getStatus() == 0) {
        %>
        <script>
                                                                        function delOrder() {
                                                                            swal.fire({
                                                                                title: 'Are you sure?',
                                                                                text: 'You won\'t be able to revert this!',
                                                                                icon: 'warning',
                                                                                showCancelButton: true,
                                                                                confirmButtonText: 'Yes, delete it!',
                                                                                cancelButtonText: 'Cancel'
                                                                            }).then((result) => {
                                                                                if (result.isConfirmed) {
                                                                                    window.location.href = "DeleteOrder?id=<%= order.getOrderId()%>";
                                                                                }
                                                                            });
                                                                        }
                                                                        function completeOrder() {
                                                                            swal.fire({
                                                                                title: 'Are you sure?',
                                                                                text: 'You won\'t be able to revert this!',
                                                                                icon: 'warning',
                                                                                showCancelButton: true,
                                                                                confirmButtonText: 'Complete',
                                                                                cancelButtonText: 'Cancel'
                                                                            }).then((result) => {
                                                                                if (result.isConfirmed) {
                                                                                    window.location.href = "CompleteOrder?id=<%= order.getOrderId()%>";
                                                                                }
                                                                            });
                                                                        }

        </script>
        <%
            }
        %>
    </body>

</html>

<!--SQL CODE FOR AUTO INCREMENT ID
CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(140) NOT NULL,
product_price DOUBLE,
product_image BLOB);-->