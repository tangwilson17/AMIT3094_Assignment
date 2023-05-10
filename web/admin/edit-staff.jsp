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
                        Staff staffs = (Staff) session.getAttribute("staff-detail");
                    %>
                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block">
                                        <div class="card col-12">
                                            <div class="card-content">
                                                <form action="UpdateStaff" method="POST">
                                                    <input type="hidden" name="staff-id" value="<%= staffs.getStaffId()%>">
                                                    <div class="card-inner">
                                                        <div class="nk-block">
                                                            <div class="nk-block-head">
                                                                <h5 class="title">Staff Information</h5>
                                                            </div><!-- .nk-block-head -->
                                                        </div><!-- .nk-block -->
                                                        <div class="row mt-3">
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="form-label" for="default-05">Staff Name</label>
                                                                    <div class="form-control-wrap">
                                                                        <input type="text" class="form-control" name="staff-name" value="<%= staffs.getStaffName()%>">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="form-label" for="default-05">Email</label>
                                                                    <div class="form-control-wrap">
                                                                        <input type="text" class="form-control" name="staff-email" value="<%= staffs.getEmail()%>">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="form-label" for="default-05">Password</label>
                                                                    <div class="form-control-wrap">
                                                                        <input type="password" class="form-control" name="staff-password" value="<%= staffs.getPassword()%>">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4 mt-3">
                                                                <div class="form-group">
                                                                    <label class="form-label" for="default-05">Contact Number</label>
                                                                    <div class="form-control-wrap">
                                                                        <input type="tel" pattern="[0][1][0-9][0-9]{10-13}" class="form-control" placeholder="01234567891" name="staff-contact" value="<%= staffs.getStaffContact()%>">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4 mt-3">
                                                                <label class="form-label" for="default-06">Role</label>
                                                                <div class="form-control-wrap ">
                                                                    <div class="form-control-select">
                                                                        <select class="form-control" name="staff-role">
                                                                            <option value='0' <% out.print(staffs.getRole() == 0 ? "selected" : ""); %>>Manager</option>
                                                                            <option value='1' <% out.print(staffs.getRole() == 1 ? "selected" : ""); %>>Staff</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div><!-- .nk-block -->
                                                        <div class="row mt-3">
                                                            <div class="col-sm-6">
                                                                <input type="submit" class="btn btn-success" value="Save">
                                                                <%
                                                                    if (staffs.getStatus() == 1) {
                                                                %>
                                                                <a onclick="disableStaff()" class="btn btn-warning">Disable</a>
                                                                <%
                                                                } else {
                                                                %>
                                                                <a onclick="enableStaff()" class="btn btn-success">Enable</a>
                                                                <%
                                                                    }
                                                                %>
                                                                <a onclick="delStaff()" class="btn btn-danger">Delete</a>
                                                            </div>
                                                        </div>
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
        <script>
            <%
                try {
                    int error = (Integer) session.getAttribute("error");
                    if (error == 1) {
                        out.print("Swal.fire({"
                                + "icon: 'error',"
                                + "title: 'Oops...',"
                                + "text: `" + session.getAttribute("error_msg") + "`"
                                + "})" + "");
                        session.removeAttribute("error");
                    } else {
            %>
                                                                    swal.fire({
                                                                        icon: 'success',
                                                                        title: 'Update Successful!',
                                                                        text: 'Your changes have been saved.',
                                                                        confirmButtonText: 'OK'
                                                                    });
            <%
                        session.removeAttribute("error");
                    }
                } catch (Exception e) {

                }
            %>
        </script>
        <script>
            function delStaff() {
                swal.fire({
                    title: 'Are you sure?',
                    text: 'You won\'t be able to revert this!',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes, delete it!',
                    cancelButtonText: 'Cancel'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "DeleteStaff?id=<%= staffs.getStaffId()%>";
                    }
                });
            }

            function disableStaff() {
                swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you want to disable this account?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes, disable it!',
                    cancelButtonText: 'Cancel'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "DisableStaff?id=<%= staffs.getStaffId()%>";
                    }
                });
            }

            function enableStaff() {
                swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you want to enable this account?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes, enable it!',
                    cancelButtonText: 'Cancel'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "EnableStaff?id=<%= staffs.getStaffId()%>";
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