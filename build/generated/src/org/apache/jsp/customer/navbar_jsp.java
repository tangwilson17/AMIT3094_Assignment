package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class navbar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("<div id=\"header-wrap\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"top-content\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"social-links\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\"><i class=\"icon icon-facebook\"></i></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\"><i class=\"icon icon-twitter\"></i></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\"><i class=\"icon icon-youtube-play\"></i></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\"><i class=\"icon icon-behance-square\"></i></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div><!--social-links-->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"right-element\">\r\n");
      out.write("\r\n");
      out.write("                        ");

                            if (session.getAttribute("customer") != null) {
                        
      out.write("\r\n");
      out.write("                        <a href=\"../LogoutCustomerController\" style=\"padding-right:30px\">Logout</a>\r\n");
      out.write("                            ");
 } else {
      out.write("\r\n");
      out.write("                        <a class=\"me-3\" href=\"login.jsp\" style=\"padding-right:30px\">Login</a>\r\n");
      out.write("                                ");
 }
      out.write("\r\n");
      out.write("                        <a href=\"CartServlet\" class=\"cart for-buy\"><i class=\"icon icon-clipboard\"></i><span>Cart:(0 $)</span></a>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"action-menu\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"search-bar\">\r\n");
      out.write("                                <a href=\"#\" class=\"search-button search-toggle\" data-selector=\"#header-wrap\">\r\n");
      out.write("                                    <i class=\"icon icon-search\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <form role=\"search\" method=\"get\" class=\"search-box\">\r\n");
      out.write("                                    <input class=\"search-field text search-input\" placeholder=\"Search\" type=\"search\">\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div><!--top-right-->\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div><!--top-content-->\r\n");
      out.write("\r\n");
      out.write("    <header id=\"header\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-2\">\r\n");
      out.write("                    <div class=\"main-logo\">\r\n");
      out.write("                        <a href=\"index.jsp\"><img src=\"images/main-logo.png\" alt=\"logo\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-10\">\r\n");
      out.write("\r\n");
      out.write("                    <nav id=\"navbar\">\r\n");
      out.write("                        <div class=\"main-menu stellarnav\">\r\n");
      out.write("                            <ul class=\"menu-list\">\r\n");
      out.write("                                <li class=\"menu-item active\"><a href=\"index.jsp\" data-effect=\"Home\">Home</a></li>\r\n");
      out.write("                                <li class=\"menu-item\"><a href=\"about.jsp\" class=\"nav-link\" data-effect=\"About\">About</a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <li class=\"menu-item\"><a href=\"../DisplayProduct\" class=\"nav-link\" data-effect=\"Shop\">Shop</a></li>\r\n");
      out.write("                                <li class=\"menu-item\"><a href=\"contact.jsp\" class=\"nav-link\" data-effect=\"Contact\">Contact</a></li>\r\n");
      out.write("                                <li class=\"menu-item has-sub\">\r\n");
      out.write("                                    <a href=\"#pages\" class=\"nav-link\" data-effect=\"Pages\">Pages</a>\r\n");
      out.write("\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                                        <li><a href=\"about.jsp\">About</a></li>\r\n");
      out.write("                                        <li><a href=\"styles.jsp\">Styles</a></li>\r\n");
      out.write("                                        <li><a href=\"shop.jsp\">Our Store</a></li>\r\n");
      out.write("                                        <li><a href=\"single-product.jsp\">Product Single</a></li>\r\n");
      out.write("                                        <li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"hamburger\">\r\n");
      out.write("                                <span class=\"bar\"></span>\r\n");
      out.write("                                <span class=\"bar\"></span>\r\n");
      out.write("                                <span class=\"bar\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("</div><!--header-wrap-->");
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
