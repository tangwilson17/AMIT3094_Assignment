package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zxx\" class=\"no-js\">\r\n");
      out.write("\r\n");
      out.write("<head>\n");
      out.write("    <title>Book Store</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta name=\"format-detection\" content=\"telephone=no\">\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <meta name=\"keywords\" content=\"\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"icomoon/icomoon.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/vendor.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("\n");
      out.write("    <!-- script\n");
      out.write("    ================================================== -->\n");
      out.write("    <script src=\"js/modernizr.js\"></script>\n");
      out.write("\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <input type=\"hidden\" id=\"status\" value=\"");
 if (session.getAttribute("status") != "") {out.print(session.getAttribute("status")); session.setAttribute("status", "");} 
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\t<!-- Start Banner Area -->\r\n");
      out.write("\t<section class=\"banner-area organic-breadcrumb\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end\">\r\n");
      out.write("\t\t\t\t<div class=\"col-first\">\r\n");
      out.write("\t\t\t\t\t<h1>Login/Register</h1>\r\n");
      out.write("\t\t\t\t\t<nav class=\"d-flex align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"index.html\">Login<span class=\"lnr lnr-arrow-right\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"category.html\">Register</a>\r\n");
      out.write("\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- End Banner Area -->\r\n");
      out.write("\r\n");
      out.write("\t<!--================Registration Box Area =================-->\r\n");
      out.write("\t<section class=\"login_box_area section_gap\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"login_form_inner\">\r\n");
      out.write("\t\t\t\t\t\t<h3>Register account</h3>\r\n");
      out.write("\t\t\t\t\t\t<form class=\"row login_form\" action=\"../RegistrationCustomerController\" method=\"post\" id=\"contactForm\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\r\n");
      out.write("                                                            <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"Username\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Username'\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Email\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Email'\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                                        <div class=\"col-md-12 form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"phoneNo\" name=\"phoneNo\" placeholder=\"Contact Number\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Contact Number'\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                                        <div class=\"col-md-12 form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Password\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Password'\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                                        <div class=\"col-md-12 form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"cpassword\" name=\"cpassword\" placeholder=\"Confirm Password\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Confirm Password'\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" value=\"submit\" class=\"primary-btn\">Register</button>\r\n");
      out.write("                                                                <a href=\"login.jsp\">Go Back to Login</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--================End Registration Box Area =================-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"\">\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            var status = document.getElementById(\"status\").value;\r\n");
      out.write("           \r\n");
      out.write("            if(status === \"success\"){              \r\n");
      out.write("                swal.fire(\"Congrats\", \"Account Created Succesfully\", \"success\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyName\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Name\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyEmail\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Email\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyPhoneNo\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Contact Number\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyPass\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Password\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if(status === \"EmptyConfirmPass\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"Please Enter Confirmation Password\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if (status === \"invalidEmail\"){              \r\n");
      out.write("                swal.fire(\"Sorry\", \"This Email is already registered\", \"error\");               \r\n");
      out.write("            }\r\n");
      out.write("            if (status === \"invalidConfirmPassword\"){\r\n");
      out.write("                swal.fire(\"Sorry\", \"Password do not match with Confirmation Password\", \"error\");\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
