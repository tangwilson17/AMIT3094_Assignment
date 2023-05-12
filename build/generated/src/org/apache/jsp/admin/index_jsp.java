package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import entity.Product;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import entity.Orders;
import entity.Staff;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/admin/header.jsp");
    _jspx_dependants.add("/admin/sidebar.jsp");
    _jspx_dependants.add("/admin/navbar.jsp");
    _jspx_dependants.add("/admin/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zxx\" class=\"js\">\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("<head>\r\n");
      out.write("    <base href=\"\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"author\" content=\"Softnio\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"A powerful and conceptual apps base dashboard template that especially build for developers and programmers.\">\r\n");
      out.write("    <!-- Fav Icon  -->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.print( getServletContext().getInitParameter("webLogo") );
      out.write("\">\r\n");
      out.write("    <!-- Page Title  -->\r\n");
      out.write("    <title>");
      out.print( getServletContext().getInitParameter("webName") );
      out.write("</title>\r\n");
      out.write("    <!-- StyleSheets  -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./assets/css/dashlite.css?ver=3.1.0\">\r\n");
      out.write("    <link id=\"skin-default\" rel=\"stylesheet\" href=\"./assets/css/theme.css?ver=3.1.0\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body class=\"nk-body bg-lighter npc-default has-sidebar \">\r\n");
      out.write("        <div class=\"nk-app-root\">\r\n");
      out.write("            <!-- main @s -->\r\n");
      out.write("            <div class=\"nk-main \">\r\n");
      out.write("                ");
      out.write("<!-- sidebar @s -->\r\n");
      out.write("<div class=\"nk-sidebar nk-sidebar-fixed is-light \" data-content=\"sidebarMenu\">\r\n");
      out.write("    <div class=\"nk-sidebar-element nk-sidebar-head\">\r\n");
      out.write("        <div class=\"nk-sidebar-brand\">\r\n");
      out.write("            <a href=\"index.jsp\" class=\"logo-link nk-sidebar-logo\">\r\n");
      out.write("                <img class=\"logo-dark logo-img\" src=\"");
      out.print( getServletContext().getInitParameter("webLogo"));
      out.write("\" srcset=\"./images/logo-dark2x.png 2x\" alt=\"logo-dark\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"nk-menu-trigger me-n2\">\r\n");
      out.write("            <a href=\"#\" class=\"nk-nav-toggle nk-quick-nav-icon d-xl-none\" data-target=\"sidebarMenu\"><em class=\"icon ni ni-arrow-left\"></em></a>\r\n");
      out.write("            <a href=\"#\" class=\"nk-nav-compact nk-quick-nav-icon d-none d-xl-inline-flex\" data-target=\"sidebarMenu\"><em class=\"icon ni ni-menu\"></em></a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div><!-- .nk-sidebar-element -->\r\n");
      out.write("    <div class=\"nk-sidebar-element\">\r\n");
      out.write("        <div class=\"nk-sidebar-content\">\r\n");
      out.write("            <div class=\"nk-sidebar-menu\" data-simplebar>\r\n");
      out.write("                <ul class=\"nk-menu\">\r\n");
      out.write("                    <li class=\"nk-menu-heading\">\r\n");
      out.write("                        <h6 class=\"overline-title text-primary-alt\">Pages</h6>\r\n");
      out.write("                    </li><!-- .nk-menu-heading -->\r\n");
      out.write("                    <li class=\"nk-menu-item\">\r\n");
      out.write("                        <a href=\"index.jsp\" class=\"nk-menu-link\">\r\n");
      out.write("                            <span class=\"nk-menu-icon\"><em class=\"icon ni ni-home-fill\"></em></span>\r\n");
      out.write("                            <span class=\"nk-menu-text\">Dashboard</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li><!-- .nk-menu-item -->\r\n");
      out.write("                    <li class=\"nk-menu-item has-sub\">\r\n");
      out.write("                        <a href=\"#\" class=\"nk-menu-link nk-menu-toggle\">\r\n");
      out.write("                            <span class=\"nk-menu-icon\"><em class=\"icon ni ni-package-fill\"></em></span>\r\n");
      out.write("                            <span class=\"nk-menu-text\">Products</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul class=\"nk-menu-sub\">\r\n");
      out.write("                            <li class=\"nk-menu-item\">\r\n");
      out.write("                                <a href=\"product-list\" class=\"nk-menu-link\"><span class=\"nk-menu-text\">Product Lists</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"nk-menu-item\">\r\n");
      out.write("                                <a href=\"add-product.jsp\" class=\"nk-menu-link\"><span class=\"nk-menu-text\">Add Product</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul><!-- .nk-menu-sub -->\r\n");
      out.write("                    </li><!-- .nk-menu-item -->\r\n");
      out.write("                    <li class=\"nk-menu-item\">\r\n");
      out.write("                        <a href=\"customer-list.jsp\" class=\"nk-menu-link\">\r\n");
      out.write("                            <span class=\"nk-menu-icon\"><em class=\"icon ni ni-user-alt-fill\"></em></span>\r\n");
      out.write("                            <span class=\"nk-menu-text\">Customer</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li><!-- .nk-menu-item -->\r\n");
      out.write("                    <li class=\"nk-menu-item\">\r\n");
      out.write("                        <a href=\"order-list.jsp\" class=\"nk-menu-link\">\r\n");
      out.write("                            <span class=\"nk-menu-icon\"><em class=\"icon ni ni-cart-fill\"></em></span>\r\n");
      out.write("                            <span class=\"nk-menu-text\">Orders</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li><!-- .nk-menu-item -->\r\n");
      out.write("                    <li class=\"nk-menu-item\">\r\n");
      out.write("                        <a href=\"staff-list.jsp\" class=\"nk-menu-link\">\r\n");
      out.write("                            <span class=\"nk-menu-icon\"><em class=\"icon ni ni-lock-fill\"></em></span>\r\n");
      out.write("                            <span class=\"nk-menu-text\">Staff</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li><!-- .nk-menu-item -->\r\n");
      out.write("                    <li class=\"nk-menu-item\">\r\n");
      out.write("                        <a href=\"report.jsp\" class=\"nk-menu-link\">\r\n");
      out.write("                            <span class=\"nk-menu-icon\"><em class=\"icon ni ni-line-chart-up\"></em></span>\r\n");
      out.write("                            <span class=\"nk-menu-text\">Report</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li><!-- .nk-menu-item -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </ul><!-- .nk-menu -->\r\n");
      out.write("            </div><!-- .nk-sidebar-menu -->\r\n");
      out.write("        </div><!-- .nk-sidebar-content -->\r\n");
      out.write("    </div><!-- .nk-sidebar-element -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- sidebar @e -->");
      out.write("\r\n");
      out.write("                ");

                    session.setAttribute("bypass", 1);
                
      out.write("\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/admin/GetOrdersList", out, false);
      out.write("\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/admin/GetHomepageDetails", out, false);
      out.write("\r\n");
      out.write("                ");

                    List<Orders> ordersList = (List<Orders>) session.getAttribute("orders-list");
                    List<Product> prodList = (List<Product>) session.getAttribute("lowStocks");
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- wrap @s -->\r\n");
      out.write("                <div class=\"nk-wrap \">\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("<!-- main header @s -->\r\n");

    Staff staff = null;
    if (session.getAttribute("staff") == null) {
        response.sendRedirect("/AMIT3094_Assignment/admin/login.jsp");
        return;
    } else {
        staff = (Staff) session.getAttribute("staff");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"nk-header nk-header-fixed is-light\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"nk-header-wrap\">\r\n");
      out.write("            <div class=\"nk-menu-trigger d-xl-none ms-n1\">\r\n");
      out.write("                <a href=\"#\" class=\"nk-nav-toggle nk-quick-nav-icon\" data-target=\"sidebarMenu\"><em class=\"icon ni ni-menu\"></em></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"nk-header-brand d-xl-none\">\r\n");
      out.write("                <a href=\"html/index.html\" class=\"logo-link\">\r\n");
      out.write("                    <img class=\"logo-light logo-img\" src=\"");
      out.print( getServletContext().getInitParameter("webLogo"));
      out.write("\" srcset=\"./images/logo2x.png 2x\" alt=\"logo\">\r\n");
      out.write("                    <img class=\"logo-dark logo-img\" src=\"");
      out.print( getServletContext().getInitParameter("webLogo"));
      out.write("\" srcset=\"./images/logo-dark2x.png 2x\" alt=\"logo-dark\">\r\n");
      out.write("                </a>\r\n");
      out.write("            </div><!-- .nk-header-brand -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"nk-header-tools\">\r\n");
      out.write("                <ul class=\"nk-quick-nav\">\r\n");
      out.write("                    <li class=\"dropdown user-dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle me-n1\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                            <div class=\"user-toggle\">\r\n");
      out.write("                                <div class=\"user-avatar sm\">\r\n");
      out.write("                                    <em class=\"icon ni ni-user-alt\"></em>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"user-info d-none d-xl-block\">\r\n");
      out.write("                                    <div class=\"user-name dropdown-indicator\">");
  out.print(staff != null ? staff.getStaffName() : "" ); 
      out.write("</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-md dropdown-menu-end\">\r\n");
      out.write("                            <div class=\"dropdown-inner user-card-wrap bg-lighter d-none d-md-block\">\r\n");
      out.write("                                <div class=\"user-card\">\r\n");
      out.write("                                    <div class=\"user-info\">\r\n");
      out.write("                                        <span class=\"lead-text\">");
  out.print(staff != null ? staff.getStaffName() : "" ); 
      out.write("</span>\r\n");
      out.write("                                        <span class=\"sub-text\">");
 out.print(staff != null ? staff.getEmail() : "" );
      out.write("</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"dropdown-inner\">\r\n");
      out.write("                                <ul class=\"link-list\">\r\n");
      out.write("                                    <li><a class=\"dark-switch\" href=\"#\"><em class=\"icon ni ni-moon\"></em><span>Dark Mode</span></a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"dropdown-inner\">\r\n");
      out.write("                                <ul class=\"link-list\">\r\n");
      out.write("                                    <li><a href=\"LogoutOperation\"><em class=\"icon ni ni-signout\"></em><span>Sign out</span></a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- .nk-header-wrap -->\r\n");
      out.write("    </div><!-- .container-fliud -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- main header @e -->");
      out.write("\r\n");
      out.write("                    <!-- content @s -->\r\n");
      out.write("                    <div class=\"nk-content \">\r\n");
      out.write("                        <div class=\"container-fluid\">\r\n");
      out.write("                            <div class=\"nk-content-inner\">\r\n");
      out.write("                                <div class=\"nk-content-body\">\r\n");
      out.write("                                    <div class=\"col-xxl-12\">\r\n");
      out.write("                                        <div class=\"nk-block-head-content mb-2\">\r\n");
      out.write("                                            <h3 class=\"nk-block-title page-title\">Recent Orders</h3>\r\n");
      out.write("                                        </div><!-- .nk-block-head-content -->\r\n");
      out.write("                                        <div class=\"card card-full\">\r\n");
      out.write("                                            <table class=\"datatable-init nowrap nk-tb-list is-separate\" data-auto-responsive=\"false\" id=\"ordertable\" data-order='[[3, \"desc\"]]' data-searching=\"false\" data-paging=\"false\" data-info=\"false\">\r\n");
      out.write("                                                <thead>\r\n");
      out.write("                                                    <tr class=\"nk-tb-item nk-tb-head\">\r\n");
      out.write("                                                        <th class=\"nk-tb-col tb-col-sm\"><span>Order ID</span></th>\r\n");
      out.write("                                                        <th class=\"nk-tb-col\"><span>Customer Name</span></th>\r\n");
      out.write("                                                        <th class=\"nk-tb-col\"><span>Total</span></th>\r\n");
      out.write("                                                        <th class=\"nk-tb-col\"><span>Date Ordered</span></th>\r\n");
      out.write("                                                        <th class=\"nk-tb-col\"><span>Status</span></th>\r\n");
      out.write("                                                        <th class=\"nk-tb-col nk-tb-col-tools\">\r\n");
      out.write("                                                            <ul class=\"nk-tb-actions gx-1 my-n1\">\r\n");
      out.write("                                                                <li class=\"me-n1\">\r\n");
      out.write("                                                                </li>\r\n");
      out.write("                                                            </ul>\r\n");
      out.write("                                                        </th>\r\n");
      out.write("                                                    </tr><!-- .nk-tb-item -->\r\n");
      out.write("                                                </thead>\r\n");
      out.write("                                                <tbody>\r\n");
      out.write("                                                    ");

                                                        for (int i = 0; i < ordersList.size() && i < 5; i++) {
                                                            Orders order = ordersList.get(i);
                                                            Date date = order.getPaymentId().getDate();
                                                            DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                            String outputDateStr = outputDateFormat.format(date);
                                                    
      out.write("\r\n");
      out.write("                                                    <tr class=\"nk-tb-item\">\r\n");
      out.write("\r\n");
      out.write("                                                        <td class=\"nk-tb-col tb-col-sm\">\r\n");
      out.write("                                                            <span class=\"tb-product\">\r\n");
      out.write("\r\n");
      out.write("                                                                <span class=\"title\">");
      out.print( order.getOrderId());
      out.write("</span>\r\n");
      out.write("                                                            </span>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"nk-tb-col\">\r\n");
      out.write("                                                            <span class=\"tb-lead\">");
      out.print( order.getCustomerId().getCustomerName());
      out.write("</span>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"nk-tb-col\">\r\n");
      out.write("                                                            <span class=\"tb-sub\">");
      out.print( String.format("%.2f", order.getPaymentId().getAmount()));
      out.write(" MYR</span>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"nk-tb-col\">\r\n");
      out.write("                                                            <span class=\"tb-sub\">");
      out.print( outputDateStr);
      out.write("</span>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"nk-tb-col\">\r\n");
      out.write("                                                            ");

                                                                if (order.getStatus() == 0) {
                                                                    out.print("<span class='dot bg-warning d-sm-none'></span><span class='badge badge-sm badge-dot has-bg bg-warning d-none d-sm-inline-flex'>Delivering</span>");
                                                                } else {
                                                                    out.print("<span class='dot bg-success d-sm-none'></span><span class='badge badge-sm badge-dot has-bg bg-success d-none d-sm-inline-flex'>Completed</span>");
                                                                }
                                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                        </td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                        <td class=\"nk-tb-col nk-tb-col-tools\">\r\n");
      out.write("                                                            <ul class=\"nk-tb-actions gx-1 my-n1\">\r\n");
      out.write("                                                                <li class=\"me-n1\">\r\n");
      out.write("                                                                    <div class=\"dropdown\">\r\n");
      out.write("                                                                        <a href=\"#\" class=\"dropdown-toggle btn btn-icon btn-trigger\" data-bs-toggle=\"dropdown\"><em class=\"icon ni ni-more-h\"></em></a>\r\n");
      out.write("                                                                        <div class=\"dropdown-menu dropdown-menu-end\">\r\n");
      out.write("                                                                            <ul class=\"link-list-opt no-bdr\">\r\n");
      out.write("                                                                                <li><a href=\"GetOrderDetails?orderId=");
      out.print( order.getOrderId());
      out.write("\"><em class=\"icon ni ni-edit\"></em><span>View Details</span></a></li>\r\n");
      out.write("                                                                            </ul>\r\n");
      out.write("                                                                        </div>\r\n");
      out.write("                                                                    </div>\r\n");
      out.write("                                                                </li>\r\n");
      out.write("                                                            </ul>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr><!-- .nk-tb-item -->\r\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </tbody>\r\n");
      out.write("                                            </table><!-- .nk-tb-list -->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><!-- .card -->\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-xxl-6 mt-5\">\r\n");
      out.write("                                    <div class=\"card card-full\">\r\n");
      out.write("                                        <div class=\"card-inner\">\r\n");
      out.write("                                            <div class=\"card-title-group\">\r\n");
      out.write("                                                <div class=\"card-title\">\r\n");
      out.write("                                                    <h6 class=\"title\">Low Stock Products</h6>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"nk-tb-list mt-n2\">\r\n");
      out.write("                                            <div class=\"nk-tb-item nk-tb-head\">\r\n");
      out.write("                                                <div class=\"nk-tb-col\"><span>Image</span></div>\r\n");
      out.write("                                                <div class=\"nk-tb-col tb-col-sm\"><span>Name</span></div>\r\n");
      out.write("                                                <div class=\"nk-tb-col tb-col-md\"><span>Price</span></div>\r\n");
      out.write("                                                <div class=\"nk-tb-col\"><span>Stock</span></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");

                                                for (Product prod : prodList) {
                                                    String base64img = Base64.getEncoder().encodeToString(prod.getImage());
                                            
      out.write("\r\n");
      out.write("                                            <div class=\"nk-tb-item\">\r\n");
      out.write("                                                <div class=\"nk-tb-col\">\r\n");
      out.write("                                                    <span class=\"tb-product\">\r\n");
      out.write("                                                        <img src=\"data:image/png;base64, ");
      out.print( base64img);
      out.write("\" class=\"thumb\">\r\n");
      out.write("                                                    </span>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"nk-tb-col tb-col-sm\">\r\n");
      out.write("                                                    <span class=\"title\">");
      out.print( prod.getProductname());
      out.write("</span>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"nk-tb-col tb-col-md\">\r\n");
      out.write("                                                    <span class=\"tb-sub\">");
      out.print( String.format("%.2f", prod.getPrice()));
      out.write(" MYR</span>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"nk-tb-col\">\r\n");
      out.write("                                                    <span class=\"tb-sub tb-amount\">");
      out.print( prod.getQty());
      out.write("</span>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><!-- .card -->\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- content @e -->\r\n");
      out.write("                ");
      out.write("<!-- footer @s -->\r\n");
      out.write("<div class=\"nk-footer\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"nk-footer-wrap\">\r\n");
      out.write("            <div class=\"nk-footer-copyright\"> &copy; 2023 ");
      out.print( getServletContext().getInitParameter("webName") );
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<!-- footer @e -->");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- wrap @e -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- main @e -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- app-root @e -->\r\n");
      out.write("    <!-- JavaScript -->\r\n");
      out.write("    <script src=\"./assets/js/bundle.js?ver=3.1.0\"></script>\r\n");
      out.write("    <script src=\"./assets/js/scripts.js?ver=3.1.0\"></script>\r\n");
      out.write("    <script src=\"./assets/js/charts/chart-ecommerce.js?ver=3.1.0\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<!--SQL CODE FOR AUTO INCREMENT ID\r\n");
      out.write("CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,\r\n");
      out.write("product_name VARCHAR(140) NOT NULL,\r\n");
      out.write("product_price DOUBLE,\r\n");
      out.write("product_image BLOB);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("fix list\r\n");
      out.write("1) product edit spinner\r\n");
      out.write("2) product edit success message\r\n");
      out.write("-->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
