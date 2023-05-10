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
                    <jsp:include page="/admin/GetCustomerList"></jsp:include>
                    <%
                        List<Customer> customerList = (List<Customer>) session.getAttribute("customer-list");
                    %>

                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">   
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block-head nk-block-head-sm">
                                        <div class="nk-block-between">
                                            <div class="nk-block-head-content">
                                                <h3 class="nk-block-title page-title">Customer Listing</h3>
                                            </div><!-- .nk-block-head-content -->
                                            <div class="nk-block-head-content">
                                                <div class="toggle-wrap nk-block-tools-toggle">
                                                    <a href="#" class="btn btn-icon btn-trigger toggle-expand me-n1" data-target="pageMenu"><em class="icon ni ni-more-v"></em></a>
                                                    <div class="toggle-expand-content" data-content="pageMenu">
                                                        <ul class="nk-block-tools g-3">
                                                            <li class="nk-block-tools-opt">
                                                                <a href="#" class="btn btn-icon btn-primary d-md-none"><em class="icon ni ni-plus"></em></a>
                                                                <a data-bs-toggle="modal" data-bs-target="#profile-edit" class="btn btn-primary d-none d-md-inline-flex"><em class="icon ni ni-plus"></em><span>Add Customers</span></a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div><!-- .nk-block-head-content -->
                                        </div><!-- .nk-block-between -->
                                    </div><!-- .nk-block-head -->
                                    <table class="datatable-init nowrap nk-tb-list is-separate" data-auto-responsive="false">
                                        <thead>
                                            <tr class="nk-tb-item nk-tb-head">
                                                <th class="nk-tb-col tb-col-sm"><span>Name</span></th>
                                                <th class="nk-tb-col"><span>Email</span></th>
                                                <th class="nk-tb-col"><span>Contact Number</span></th>
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
                                                for (Customer cust : customerList) {
                                            %>
                                            <tr class="nk-tb-item">

                                                <td class="nk-tb-col tb-col-sm">
                                                    <span class="tb-product">

                                                        <span class="title"><%= cust.getCustomerName()%></span>
                                                    </span>
                                                </td>
                                                <td class="nk-tb-col">
                                                    <span class="tb-lead"><%= cust.getEmail()%></span>
                                                </td>
                                                <td class="nk-tb-col">
                                                    <span class="tb-sub"><%= cust.getCustomerContact()%></span>
                                                </td>

                                                <td class="nk-tb-col nk-tb-col-tools">
                                                    <ul class="nk-tb-actions gx-1 my-n1">
                                                        <li class="me-n1">
                                                            <div class="dropdown">
                                                                <a href="#" class="dropdown-toggle btn btn-icon btn-trigger" data-bs-toggle="dropdown"><em class="icon ni ni-more-h"></em></a>
                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                    <ul class="link-list-opt no-bdr">
                                                                        <li><a href="GetCustomerDetails?customerId=<%= cust.getCustomerId()%>"><em class="icon ni ni-edit"></em><span>View Details</span></a></li>
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
                    <div class="modal fade addform" role="dialog" id="profile-edit">
                        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                            <div class="modal-content">
                                <a href="#" class="close" data-bs-dismiss="modal"><em class="icon ni ni-cross-sm"></em></a>
                                <div class="modal-body modal-body-lg">
                                    <h5 class="title">Create New Customer</h5>
                                    <ul class="nk-nav nav nav-tabs">
                                    </ul><!-- .nav-tabs -->
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="personal">
                                            <form action="AddCustomer" method="POST">
                                                <div class="row gy-4">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="form-label" for="full-name">Full Name</label>
                                                            <input type="text" class="form-control form-control-lg pt-0 pb-0" name="customer-name" value="" placeholder="">
                                                            <span class="text-danger">
                                                                <%
                                                                    if (session.getAttribute("nameError") != null && session.getAttribute("nameError") != "") {
                                                                        out.print(session.getAttribute("nameError"));
                                                                        session.setAttribute("nameError", null);
                                                                    }
                                                                %>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="form-label" for="display-name">Email</label>
                                                            <input type="email" class="form-control form-control-lg pt-0 pb-0" name="customer-email" value="" placeholder="">
                                                            <span class="text-danger">
                                                                <%
                                                                    if (session.getAttribute("emailError") != null && session.getAttribute("emailError") != "") {
                                                                        out.print(session.getAttribute("emailError"));
                                                                        session.setAttribute("emailError", null);
                                                                    }
                                                                %>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="form-label" for="phone-no">Password</label>
                                                            <input type="password" class="form-control form-control-lg pt-0 pb-0 ps-2 pe-2" name="customer-password" value="" placeholder="">
                                                            <span class="text-danger">
                                                                <%
                                                                    if (session.getAttribute("passwordError") != null && session.getAttribute("passwordError") != "") {
                                                                        out.print(session.getAttribute("passwordError"));
                                                                        session.setAttribute("passwordError", null);
                                                                    }
                                                                %>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="form-label" for="phone-no">Confirm Password</label>
                                                            <input type="password" class="form-control form-control-lg pt-0 pb-0 ps-2 pe-2" name="customer-confirm-password" value="" placeholder="">
                                                            <span class="text-danger">
                                                                <%
                                                                    if (session.getAttribute("confirmPasswordError") != null && session.getAttribute("confirmPasswordError") != "") {
                                                                        out.print(session.getAttribute("confirmPasswordError"));
                                                                        session.setAttribute("confirmPasswordError", null);
                                                                    }
                                                                %>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="form-label" for="birth-day">Contact Number</label>
                                                            <input type="tel" pattern="[0][1][0-9][0-9]{10-13}" class="form-control" placeholder="01234567891" name="customer-contact" value="">
                                                            <span class="text-danger">
                                                                <%
                                                                    if (session.getAttribute("contactError") != null && session.getAttribute("contactError") != "") {
                                                                        out.print(session.getAttribute("contactError"));
                                                                        session.setAttribute("contactError", null);
                                                                    }
                                                                %>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <ul class="align-center flex-wrap flex-sm-nowrap gx-4 gy-2">
                                                            <li>
                                                                <input type="submit" data-bs-dismiss="modal" class="btn btn-lg btn-primary" value="Add Customer">
                                                            </li>
                                                            <li>
                                                                <a href="#" data-bs-dismiss="modal" class="link link-light">Cancel</a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </form>
                                        </div><!-- .tab-pane -->

                                    </div><!-- .tab-content -->
                                </div><!-- .modal-body -->
                            </div><!-- .modal-content -->
                        </div><!-- .modal-dialog -->
                    </div><!-- .modal -->


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
        %>

        <script>
            $(document).ready(function () {
                $('#profile-edit').modal('show');
            });
        </script>

        <%
                    session.setAttribute("error", 0);
                }
            } catch (Exception e) {

            }
        %>
    </body>

</html>