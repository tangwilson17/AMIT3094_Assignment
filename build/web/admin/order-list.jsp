<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.Orders"%>
<%@page import="javax.persistence.criteria.Order"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="zxx" class="js">

    <%@ include file = "header.jsp" %>
    <%@page import="entity.Customer, java.util.*" %>
    <body class="nk-body bg-lighter npc-default has-sidebar ">
        <div class="nk-app-root">
            <!-- main @s -->
            <div class="nk-main ">
                <%@ include file = "sidebar.jsp" %>
                <!-- wrap @s -->
                <div class="nk-wrap ">
                    <%@ include file = "navbar.jsp" %>
                    <jsp:include page="/admin/GetOrdersList"></jsp:include>
                    <%
                        List<Orders> ordersList = (List<Orders>) session.getAttribute("orders-list");
                    %>

                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block-head nk-block-head-sm">
                                        <div class="nk-block-between">
                                            <div class="nk-block-head-content">
                                                <h3 class="nk-block-title page-title">Orders Listing</h3>
                                            </div><!-- .nk-block-head-content -->
                                            <div class="nk-block-head-content">
                                                <div class="toggle-wrap nk-block-tools-toggle">
                                                    <div class="form-group">
                                                        <div class="form-control-wrap">
                                                            <select class="form-select js-select2" onchange="filterOrder()" id="filter">
                                                                <%
                                                                    String filterSelect = "";
                                                                    if (request.getParameter("filter") != null) {
                                                                        filterSelect = request.getParameter("filter");
                                                                    }
                                                                %>
                                                                <option value="day" <%= filterSelect.equals("day") ? "selected" : ""%>>Day</option>
                                                                <option value="month" <%= filterSelect.equals("month") ? "selected" : ""%>>Month</option>
                                                                <option value="year" <%= filterSelect.equals("year") ? "selected" : ""%>> Year</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div><!-- .nk-block-head-content -->
                                        </div><!-- .nk-block-between -->
                                    </div><!-- .nk-block-head -->
                                    <table class="datatable-init nowrap nk-tb-list is-separate" data-auto-responsive="false" id="ordertable" data-order='[[3, "desc"]]'>

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
                                            <%                                                for (Orders order : ordersList) {
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
                            + "text: `Adding new customer failed!`"
                            + "})" + "</script>");
                    session.setAttribute("error", 0);
                }
            } catch (Exception e) {

            }
        %>

        <script>
                                                                function filterOrder() {
                                                                    window.location.href = "order-list.jsp?filter=" + $("#filter").val();
                                                                }

                                                    
        </script>
    </body>

</html>