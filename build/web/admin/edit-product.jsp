<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="entity.Product"%>
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
                        Product product = (Product) session.getAttribute("product-edit-detail");
                        String base64img = Base64.getEncoder().encodeToString(product.getImage());
                        List<Category> categoryList = (List<Category>) session.getAttribute("category-list");
                    %>
                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block-head nk-block-head-sm">
                                        <div class="nk-block-between g-3">
                                            <div class="nk-block-head-content">
                                                <h3 class="nk-block-title page-title">Product Details</h3>
                                            </div>
                                        </div>
                                    </div><!-- .nk-block-head -->
                                    <div class="nk-block">
                                        <div class="card">
                                            <form action="UpdateProduct" method="POST" enctype="multipart/form-data">
                                                <input type="hidden" value="<%= product.getProductid()%>" name="productid">
                                                <div class="card-inner">
                                                    <div class="row">
                                                        <div class="col-lg-6">
                                                            <div class="slider-init" id="sliderFor" data-slick='{"arrows": false, "fade": true, "asNavFor":"#sliderNav", "slidesToShow": 1, "slidesToScroll": 1}'>
                                                                <div class="slider-item rounded">
                                                                    <img src="data:image/png;base64,<%= base64img%>" id="preview" class="rounded w-100" alt="">
                                                                </div>
                                                            </div><!-- .slider-init -->
                                                            <div class="form-group mt-2">
                                                                <div class="form-control-wrap">
                                                                    <div class="form-file">
                                                                        <input type="file" multiple class="form-file-input" name="img" onchange="previewImg(event)">
                                                                        <label class="form-file-label" for="customFile">Choose file</label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div><!-- .col -->

                                                        <div class="col-lg-6">
                                                            <div class="product-info mt-5 me-xxl-5">
                                                                <div class="col-sm-12">
                                                                    <div class="form-group">
                                                                        <label class="form-label" for="default-05">Product Name</label>
                                                                        <div class="form-control-wrap">
                                                                            <input type="text" class="form-control" name="product-name" value="<%= product.getProductname()%>">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-12">
                                                                    <div class="form-group">
                                                                        <label class="form-label" for="default-textarea">Description</label>
                                                                        <div class="form-control-wrap">
                                                                            <textarea class="form-control no-resize" name="product-description"><%= product.getDescription()%></textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="row">
                                                                    <div class="col-sm-6">
                                                                        <div class="form-group">
                                                                            <label class="form-label" for="default-05">Price</label>
                                                                            <div class="form-control-wrap">
                                                                                <div class="form-text-hint">
                                                                                    <span class="overline-title">MYR</span>
                                                                                </div>
                                                                                <input type="number" class="form-control" name="product-price" value="<%= product.getPrice()%>">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-6">
                                                                        <label class="form-label" for="default-06">Category</label>
                                                                        <div class="form-control-wrap ">
                                                                            <div class="form-control-select">
                                                                                <select class="form-control" name="product-category">

                                                                                    <%
                                                                                        for (Category cate : categoryList) {
                                                                                            if (cate.getCategoryid() == product.getCategorycode().getCategoryid()) {
                                                                                                out.print("<option value='" + cate.getCategoryid() + "'  selected>" + cate.getCategoryname() + "</option>");
                                                                                            } else {
                                                                                                out.print("<option value='" + cate.getCategoryid() + "'>" + cate.getCategoryname() + "</option>");
                                                                                            }
                                                                                    %>
                                                                                    <% }%>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-4">
                                                                        <label class="form-label">Quantity</label>
                                                                        <div class="form-control-wrap number-spinner-wrap">
                                                                            <button type="button" class="btn btn-icon btn-outline-light number-spinner-btn number-minus" data-number="minus"><em class="icon ni ni-minus"></em></button>
                                                                            <input type="number" class="form-control number-spinner" value="<%= product.getQty()%>" min="0" name="qty">
                                                                            <button type="button" class="btn btn-icon btn-outline-light number-spinner-btn number-plus" data-number="plus"><em class="icon ni ni-plus"></em></button>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-12 mt-2">
                                                                        <input type="submit" class="btn btn-success" value="Save">
                                                                        <button type="button" onclick="delProd()" class="btn btn-danger">Delete</button>
                                                                    </div>
                                                                </div>
                                                            </div><!-- .col -->
                                                        </div>
                                                    </div><!-- .row -->
                                                </div>
                                            </form>
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
            function delProd(e) {
                swal.fire({
                    title: 'Are you sure?',
                    text: 'You won\'t be able to revert this!',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes, delete it!',
                    cancelButtonText: 'Cancel'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "DeleteProduct?id=<%= product.getProductid()%>";
                    }
                });
            }

            function previewImg(event) {
                var reader = new FileReader();
                reader.onload = function () {
                    var output = document.getElementById('preview');
                    output.src = reader.result;
                }
                reader.readAsDataURL(event.target.files[0]);
            }
        </script>
    </body>

</html>

<!--SQL CODE FOR AUTO INCREMENT ID
CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(140) NOT NULL,
product_price DOUBLE,
product_image BLOB);-->