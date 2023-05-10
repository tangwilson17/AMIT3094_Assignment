<!-- sidebar @s -->
<div class="nk-sidebar nk-sidebar-fixed is-light " data-content="sidebarMenu">
    <div class="nk-sidebar-element nk-sidebar-head">
        <div class="nk-sidebar-brand">
            <a href="index.jsp" class="logo-link nk-sidebar-logo">
                <img class="logo-dark logo-img" src="<%= getServletContext().getInitParameter("webLogo")%>" srcset="./images/logo-dark2x.png 2x" alt="logo-dark">
            </a>
        </div>
        <div class="nk-menu-trigger me-n2">
            <a href="#" class="nk-nav-toggle nk-quick-nav-icon d-xl-none" data-target="sidebarMenu"><em class="icon ni ni-arrow-left"></em></a>
            <a href="#" class="nk-nav-compact nk-quick-nav-icon d-none d-xl-inline-flex" data-target="sidebarMenu"><em class="icon ni ni-menu"></em></a>
        </div>
    </div><!-- .nk-sidebar-element -->
    <div class="nk-sidebar-element">
        <div class="nk-sidebar-content">
            <div class="nk-sidebar-menu" data-simplebar>
                <ul class="nk-menu">
                    <li class="nk-menu-heading">
                        <h6 class="overline-title text-primary-alt">Pages</h6>
                    </li><!-- .nk-menu-heading -->
                    <li class="nk-menu-item">
                        <a href="index.jsp" class="nk-menu-link">
                            <span class="nk-menu-icon"><em class="icon ni ni-home-fill"></em></span>
                            <span class="nk-menu-text">Dashboard</span>
                        </a>
                    </li><!-- .nk-menu-item -->
                    <li class="nk-menu-item has-sub">
                        <a href="#" class="nk-menu-link nk-menu-toggle">
                            <span class="nk-menu-icon"><em class="icon ni ni-package-fill"></em></span>
                            <span class="nk-menu-text">Products</span>
                        </a>
                        <ul class="nk-menu-sub">
                            <li class="nk-menu-item">
                                <a href="product-list" class="nk-menu-link"><span class="nk-menu-text">Product Lists</span></a>
                            </li>
                            <li class="nk-menu-item">
                                <a href="add-product.jsp" class="nk-menu-link"><span class="nk-menu-text">Add Product</span></a>
                            </li>
                        </ul><!-- .nk-menu-sub -->
                    </li><!-- .nk-menu-item -->
                    <li class="nk-menu-item">
                        <a href="customer-list.jsp" class="nk-menu-link">
                            <span class="nk-menu-icon"><em class="icon ni ni-user-alt-fill"></em></span>
                            <span class="nk-menu-text">Customer</span>
                        </a>
                    </li><!-- .nk-menu-item -->
                    <li class="nk-menu-item">
                        <a href="order-list.jsp" class="nk-menu-link">
                            <span class="nk-menu-icon"><em class="icon ni ni-cart-fill"></em></span>
                            <span class="nk-menu-text">Orders</span>
                        </a>
                    </li><!-- .nk-menu-item -->
                    <li class="nk-menu-item">
                        <a href="staff-list.jsp" class="nk-menu-link">
                            <span class="nk-menu-icon"><em class="icon ni ni-lock-fill"></em></span>
                            <span class="nk-menu-text">Staff</span>
                        </a>
                    </li><!-- .nk-menu-item -->
                    <li class="nk-menu-item">
                        <a href="report.jsp" class="nk-menu-link">
                            <span class="nk-menu-icon"><em class="icon ni ni-line-chart-up"></em></span>
                            <span class="nk-menu-text">Report</span>
                        </a>
                    </li><!-- .nk-menu-item -->



                </ul><!-- .nk-menu -->
            </div><!-- .nk-sidebar-menu -->
        </div><!-- .nk-sidebar-content -->
    </div><!-- .nk-sidebar-element -->
</div>
<!-- sidebar @e -->