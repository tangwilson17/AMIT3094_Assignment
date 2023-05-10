<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="zxx" class="js">

    <%@ include file = "header.jsp" %>
    <%@page import="entity.Product, java.util.*" %>
    <body class="nk-body bg-lighter npc-default has-sidebar ">
        <div class="nk-app-root">
            <!-- main @s -->
            <div class="nk-main ">
                <%@ include file = "sidebar.jsp" %>
                <!-- wrap @s -->
                <div class="nk-wrap ">
                    <%@ include file = "navbar.jsp" %>
                    <%
                        List<Product> prodList = (List<Product>) session.getAttribute("products");
                    %>

                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block-head nk-block-head-sm">
                                        <div class="nk-block-between">
                                            <div class="nk-block-head-content">
                                                <h3 class="nk-block-title page-title">Product Listing</h3>
                                            </div><!-- .nk-block-head-content -->
                                            <div class="nk-block-head-content">
                                                <div class="toggle-wrap nk-block-tools-toggle">
                                                    <a href="#" class="btn btn-icon btn-trigger toggle-expand me-n1" data-target="pageMenu"><em class="icon ni ni-more-v"></em></a>
                                                    <div class="toggle-expand-content" data-content="pageMenu">
                                                        <ul class="nk-block-tools g-3">
                                                            <li class="nk-block-tools-opt">
                                                                <a href="#" class="btn btn-icon btn-primary d-md-none"><em class="icon ni ni-plus"></em></a>
                                                                <a href="add-product.jsp" class="btn btn-primary d-none d-md-inline-flex"><em class="icon ni ni-plus"></em><span>Add Products</span></a>
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
                                                <th class="nk-tb-col"><span>Category</span></th>
                                                <th class="nk-tb-col"><span>Price</span></th>
                                                <th class="nk-tb-col tb-col-md"><span>Stock</span></th>
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
                                                for (Product prod : prodList) {

                                                    String base64img = Base64.getEncoder().encodeToString(prod.getImage());
                                            %>
                                            <tr class="nk-tb-item">

                                                <td class="nk-tb-col tb-col-sm">
                                                    <span class="tb-product">
                                                        <img src="data:image/png;base64, <%= base64img%>" alt="" class="thumb">
                                                        <span class="title"><%= prod.getProductname()%></span>
                                                    </span>
                                                </td>
                                                <td class="nk-tb-col">
                                                    <span class="tb-lead"><%= prod.getCategorycode().getCategoryname() %></span>
                                                </td>
                                                <td class="nk-tb-col">
                                                    <span class="tb-sub"><%= String.format("%.2f",prod.getPrice())%></span>
                                                </td>
                                                <td class="nk-tb-col tb-col-md">
                                                    <span class="tb-sub"><%= prod.getQty()%></span>
                                                </td>
                                                <td class="nk-tb-col nk-tb-col-tools">
                                                    <ul class="nk-tb-actions gx-1 my-n1">
                                                        <li class="me-n1">
                                                            <div class="dropdown">
                                                                <a href="#" class="dropdown-toggle btn btn-icon btn-trigger" data-bs-toggle="dropdown"><em class="icon ni ni-more-h"></em></a>
                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                    <ul class="link-list-opt no-bdr">
                                                                        <li><a href="EditProduct?productId=<%= prod.getProductid()%>"><em class="icon ni ni-edit"></em><span>Edit Product</span></a></li>
                                                                        
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
    </body>

</html>