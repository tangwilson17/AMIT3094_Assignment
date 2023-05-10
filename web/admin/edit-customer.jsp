<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
                        Customer customer = (Customer) session.getAttribute("customer-detail");
                    %>
                    <jsp:include page="/admin/GetCustomerOrders"></jsp:include>
                    <%
                        List<Orders> ordersList = (List<Orders>) session.getAttribute("customer-orders-list");
                    %>
                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block">
                                        <div class="row">
                                            <div class="card col-6">
                                                <div class="card-content">
                                                    <form action="UpdateCustomer" method="POST">
                                                        <input type="hidden" name="customer-id" value="<%= customer.getCustomerId()%>">
                                                        <div class="card-inner">
                                                            <div class="nk-block">
                                                                <div class="nk-block-head">
                                                                    <h5 class="title">Customer Information</h5>
                                                                </div><!-- .nk-block-head -->
                                                            </div><!-- .nk-block -->
                                                            <div class="row mt-3">
                                                                <div class="col-sm-6">
                                                                    <div class="form-group">
                                                                        <label class="form-label" for="default-05">Customer Name</label>
                                                                        <div class="form-control-wrap">
                                                                            <input type="text" class="form-control" name="customer-name" value="<%= customer.getCustomerName()%>">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <div class="form-group">
                                                                        <label class="form-label" for="default-05">Email</label>
                                                                        <div class="form-control-wrap">
                                                                            <input type="email" class="form-control" name="customer-email" value="<%= customer.getEmail()%>">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-6 mt-3">
                                                                    <div class="form-group">
                                                                        <label class="form-label" for="default-05">Contact Number</label>
                                                                        <div class="form-control-wrap">
                                                                            <input type="tel" pattern="[0][1][0-9][0-9]{10-13}" class="form-control" placeholder="01234567891" name="customer-contact" value="<%= customer.getCustomerContact()%>">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div><!-- .nk-block -->
                                                            <div class="row mt-3">
                                                                <div class="col-sm-6">
                                                                    <input type="submit" class="btn btn-success" value="Save">
                                                                    <a onclick="delCustomer()" class="btn btn-danger">Delete</a>
                                                                </div>
                                                            </div>
                                                        </div><!-- .card-inner -->
                                                    </form>
                                                </div><!-- .card-content -->
                                            </div><!-- .card -->
                                            <div class="card col-5 mt-0 ms-3">
                                                <div class="card-content">
                                                    <form action="UpdateCustomer" method="POST">
                                                        <input type="hidden" name="customer-id" value="<%= customer.getCustomerId()%>">
                                                        <div class="card-inner">
                                                            <div class="nk-block">
                                                                <div class="nk-block-head">
                                                                    <h5 class="title">Order History</h5>
                                                                </div><!-- .nk-block-head -->
                                                            </div><!-- .nk-block -->
                                                            <div class="row mt-3">
                                                                <table class="datatable-init nowrap nk-tb-list is-separate" data-auto-responsive="false">
                                                                    <thead>
                                                                        <tr class="nk-tb-item nk-tb-head">
                                                                            <th class="nk-tb-col tb-col-sm"><span>Order ID</span></th>
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
                                                                            for (Orders order : ordersList) {
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
                                                                        <% } %>
                                                                    </tbody>
                                                                </table><!-- .nk-tb-list -->
                                                            </div><!-- .nk-block -->
                                                        </div><!-- .card-inner -->
                                                    </form>
                                                </div><!-- .card-content -->
                                            </div><!-- .card -->
                                        </div>
                                    </div>
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
        <script>
            <%
                try {
                    int error = (Integer) session.getAttribute("error");
                    if (error == 1) {
            %>
                swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: '<%= session.getAttribute("error_msg")%>',
                    confirmButtonText: 'OK'
                });
            <%
            } else {
            %>
                swal.fire({
                    icon: 'success',
                    title: 'Update Successful!',
                    text: 'Your changes have been saved.',
                    confirmButtonText: 'OK'
                });
            <%
                
                
                    }
session.removeAttribute("error");
                } catch (Exception e) {

                }
            %>
        </script>
    <script>
                                                                        function delCustomer() {
                                                                            swal.fire({
                                                                                title: 'Are you sure?',
                                                                                text: 'You won\'t be able to revert this!',
                                                                                icon: 'warning',
                                                                                showCancelButton: true,
                                                                                confirmButtonText: 'Yes, delete it!',
                                                                                cancelButtonText: 'Cancel'
                                                                            }).then((result) => {
                                                                                if (result.isConfirmed) {
                                                                                    window.location.href = "DeleteCustomer?id=<%= customer.getCustomerId()%>";
                                                                                }
                                                                            });
                                                                        }
    </script>

</body>

</html>

<!--SQL CODE FOR AUTO INCREMENT ID
CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(140) NOT NULL,
product_price DOUBLE,
product_image BLOB);-->