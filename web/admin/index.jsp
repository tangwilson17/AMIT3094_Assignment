<%@page import="java.util.Base64"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="entity.Orders"%>
<!DOCTYPE html>
<html lang="zxx" class="js">

    <%@ include file = "header.jsp" %>

    <body class="nk-body bg-lighter npc-default has-sidebar ">
        <div class="nk-app-root">
            <!-- main @s -->
            <div class="nk-main ">
                <%@ include file = "sidebar.jsp" %>
                <%
                    session.setAttribute("bypass", 1);
                %>
                <jsp:include page="/admin/GetOrdersList"></jsp:include>
                <jsp:include page="/admin/GetHomepageDetails"></jsp:include>
                <%
                    List<Orders> ordersList = (List<Orders>) session.getAttribute("orders-list");
                    List<Product> prodList = (List<Product>) session.getAttribute("lowStocks");
                %>

                <!-- wrap @s -->
                <div class="nk-wrap ">
                    <%@ include file = "navbar.jsp" %>
                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="col-xxl-12">
                                        <div class="nk-block-head-content mb-2">
                                            <h3 class="nk-block-title page-title">Recent Orders</h3>
                                        </div><!-- .nk-block-head-content -->
                                        <div class="card card-full">
                                            <table class="datatable-init nowrap nk-tb-list is-separate" data-auto-responsive="false" id="ordertable" data-order='[[3, "desc"]]' data-searching="false" data-paging="false" data-info="false">
                                                <thead>
                                                    <tr class="nk-tb-item nk-tb-head">
                                                        <th class="nk-tb-col tb-col-sm"><span>Order ID</span></th>
                                                        <th class="nk-tb-col"><span>Customer Name</span></th>
                                                        <th class="nk-tb-col"><span>Total</span></th>
                                                        <th class="nk-tb-col"><span>Date Ordered</span></th>
                                                        <th class="nk-tb-col"><span>Status</span></th>
                                                        <th class="nk-tb-col nk-tb-col-tools">
                                                            <ul class="nk-tb-actions gx-1 my-n1">
                                                                <li class="me-n1">
                                                                </li>
                                                            </ul>
                                                        </th>
                                                    </tr><!-- .nk-tb-item -->
                                                </thead>
                                                <tbody>
                                                    <%
                                                        for (int i = 0; i < ordersList.size() && i < 5; i++) {
                                                            Orders order = ordersList.get(i);
                                                            Date date = order.getPaymentId().getDate();
                                                            DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                            String outputDateStr = outputDateFormat.format(date);
                                                    %>
                                                    <tr class="nk-tb-item">

                                                        <td class="nk-tb-col tb-col-sm">
                                                            <span class="tb-product">

                                                                <span class="title"><%= order.getOrderId()%></span>
                                                            </span>
                                                        </td>
                                                        <td class="nk-tb-col">
                                                            <span class="tb-lead"><%= order.getCustomerId().getCustomerName()%></span>
                                                        </td>
                                                        <td class="nk-tb-col">
                                                            <span class="tb-sub"><%= String.format("%.2f", order.getPaymentId().getAmount())%> MYR</span>
                                                        </td>
                                                        <td class="nk-tb-col">
                                                            <span class="tb-sub"><%= outputDateStr%></span>
                                                        </td>
                                                        <td class="nk-tb-col">
                                                            <%
                                                                if (order.getStatus() == 0) {
                                                                    out.print("<span class='dot bg-warning d-sm-none'></span><span class='badge badge-sm badge-dot has-bg bg-warning d-none d-sm-inline-flex'>Delivering</span>");
                                                                } else {
                                                                    out.print("<span class='dot bg-success d-sm-none'></span><span class='badge badge-sm badge-dot has-bg bg-success d-none d-sm-inline-flex'>Completed</span>");
                                                                }
                                                            %>

                                                        </td>


                                                        <td class="nk-tb-col nk-tb-col-tools">
                                                            <ul class="nk-tb-actions gx-1 my-n1">
                                                                <li class="me-n1">
                                                                    <div class="dropdown">
                                                                        <a href="#" class="dropdown-toggle btn btn-icon btn-trigger" data-bs-toggle="dropdown"><em class="icon ni ni-more-h"></em></a>
                                                                        <div class="dropdown-menu dropdown-menu-end">
                                                                            <ul class="link-list-opt no-bdr">
                                                                                <li><a href="GetOrderDetails?orderId=<%= order.getOrderId()%>"><em class="icon ni ni-edit"></em><span>View Details</span></a></li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </td>
                                                    </tr><!-- .nk-tb-item -->
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table><!-- .nk-tb-list -->
                                        </div>
                                    </div><!-- .card -->
                                </div>
                                <div class="col-xxl-6 mt-5">
                                    <div class="card card-full">
                                        <div class="card-inner">
                                            <div class="card-title-group">
                                                <div class="card-title">
                                                    <h6 class="title">Low Stock Products</h6>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="nk-tb-list mt-n2">
                                            <div class="nk-tb-item nk-tb-head">
                                                <div class="nk-tb-col"><span>Image</span></div>
                                                <div class="nk-tb-col tb-col-sm"><span>Name</span></div>
                                                <div class="nk-tb-col tb-col-md"><span>Price</span></div>
                                                <div class="nk-tb-col"><span>Stock</span></div>
                                            </div>
                                            <%
                                                for (Product prod : prodList) {
                                                    String base64img = Base64.getEncoder().encodeToString(prod.getImage());
                                            %>
                                            <div class="nk-tb-item">
                                                <div class="nk-tb-col">
                                                    <span class="tb-product">
                                                        <img src="data:image/png;base64, <%= base64img%>" class="thumb">
                                                    </span>
                                                </div>
                                                <div class="nk-tb-col tb-col-sm">
                                                    <span class="title"><%= prod.getProductname()%></span>
                                                </div>
                                                <div class="nk-tb-col tb-col-md">
                                                    <span class="tb-sub"><%= String.format("%.2f", prod.getPrice())%> MYR</span>
                                                </div>
                                                <div class="nk-tb-col">
                                                    <span class="tb-sub tb-amount"><%= prod.getQty()%></span>
                                                </div>
                                            </div>
                                            <%
                                                }
                                            %>
                                        </div>
                                    </div><!-- .card -->
                                </div>
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
</body>

</html>

<!--SQL CODE FOR AUTO INCREMENT ID
CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(140) NOT NULL,
product_price DOUBLE,
product_image BLOB);






fix list
1) product edit spinner
2) product edit success message
-->