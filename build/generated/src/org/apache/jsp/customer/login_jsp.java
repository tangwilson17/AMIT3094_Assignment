package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/customer/header.jsp");
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    ");
      out.write("<head>\r\n");
      out.write("    <title>Book Store</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <meta name=\"keywords\" content=\"\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"icomoon/icomoon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/vendor.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- script\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <script src=\"js/modernizr.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("<header id=\"header\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t<div class=\"main-logo\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"index.jsp\"><img src=\"images/main-logo.png\" alt=\"logo\"></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-md-10\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<nav id=\"navbar\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-menu stellarnav\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"menu-list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item active\"><a href=\"index.jsp\" data-effect=\"Home\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"about.jsp\" class=\"nav-link\" data-effect=\"About\">About</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("                                                         \r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"../DisplayProduct\" class=\"nav-link\" data-effect=\"Shop\">Shop</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"contact.jsp\" class=\"nav-link\" data-effect=\"Contact\">Contact</a></li>\r\n");
      out.write("                                                                       <li class=\"menu-item has-sub\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#pages\" class=\"nav-link\" data-effect=\"Pages\">Pages</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"about.jsp\">About</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"styles.jsp\">Styles</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"shop.jsp\">Our Store</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"single-product.jsp\">Product Single</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t     </ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"hamburger\">\r\n");
      out.write("\t\t\t\t                <span class=\"bar\"></span>\r\n");
      out.write("\t\t\t\t                <span class=\"bar\"></span>\r\n");
      out.write("\t\t\t\t                <span class=\"bar\"></span>\r\n");
      out.write("\t\t\t\t            </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12 justify-center align-center\" style=\"margin-top:20%\">\r\n");
      out.write("                    <h3>Log in to enter</h3>\r\n");
      out.write("                    <form class=\"row login_form\" action=\"../LoginCustomerController\" method=\"post\" id=\"contactForm\" novalidate=\"novalidate\">\r\n");
      out.write("                        <div class=\"col-md-12 form-group\">\r\n");
      out.write("                            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Email\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Email'\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-12 form-group\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Password\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Password'\">\r\n");
      out.write("                            <br>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-md-12 form-group\">\r\n");
      out.write("                            <button type=\"submit\" value=\"submit\" class=\"primary-btn\">Log In</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <a href=\"register.jsp\">Register</a>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("        <script src=\"js/plugins.js\"></script>\r\n");
      out.write("        <script src=\"js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("            var status = document.getElementById(\"status\").value;            \r\n");
      out.write("            if(status === \"loginError\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Incorrect email or password\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyEmail\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Email\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyPass\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Password\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("</html>\t");
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
