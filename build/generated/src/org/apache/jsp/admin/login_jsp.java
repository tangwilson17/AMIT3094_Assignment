package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/admin/header.jsp");
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
      out.write("                <!-- wrap @s -->\r\n");
      out.write("                <div class=\"nk-wrap nk-wrap-nosidebar\">\r\n");
      out.write("                    <!-- content @s -->\r\n");
      out.write("                    <div class=\"nk-content \">\r\n");
      out.write("                        <div class=\"nk-block nk-block-middle nk-auth-body  wide-xs\">\r\n");
      out.write("                            <div class=\"brand-logo pb-4 text-center\">\r\n");
      out.write("                                <a href=\"html/index.html\" class=\"logo-link\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    <img class=\"logo-dark logo-img logo-img-lg\" src=\"");
      out.print( getServletContext().getInitParameter("webLogo") );
      out.write("\" srcset=\"./images/logo-dark2x.png 2x\" alt=\"logo-dark\">\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <div class=\"card-inner card-inner-lg\">\r\n");
      out.write("                                    <div class=\"nk-block-head\">\r\n");
      out.write("                                        <div class=\"nk-block-head-content\">\r\n");
      out.write("                                            <h4 class=\"nk-block-title\">Sign-In</h4>\r\n");
      out.write("                                            <div class=\"nk-block-des\">\r\n");
      out.write("                                                <p>Access the Dostyle admin panel using your email and passcode.</p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <form action=\"LoginOperation\" method=\"POST\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-label-group\">\r\n");
      out.write("                                                <label class=\"form-label\" for=\"default-01\">Email</label>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-control-wrap\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control form-control-lg\" name=\"email\" id=\"default-01\" placeholder=\"Enter your email address\">\r\n");
      out.write("                                                <span class=\"text-danger\">\r\n");
      out.write("                                                    ");

                                                        if (session.getAttribute("emailError") != null && session.getAttribute("emailError") != "") {
                                                            out.print(session.getAttribute("emailError"));
                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-label-group\">\r\n");
      out.write("                                                <label class=\"form-label\" for=\"password\">Passcode</label>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-control-wrap\">\r\n");
      out.write("                                                <a href=\"#\" class=\"form-icon form-icon-right passcode-switch lg\" data-target=\"password\">\r\n");
      out.write("                                                    <em class=\"passcode-icon icon-show icon ni ni-eye\"></em>\r\n");
      out.write("                                                    <em class=\"passcode-icon icon-hide icon ni ni-eye-off\"></em>\r\n");
      out.write("                                                </a>\r\n");
      out.write("                                                <input type=\"password\" class=\"form-control form-control-lg\" name=\"password\" id=\"password\" placeholder=\"Enter your passcode\">\r\n");
      out.write("                                                <span class=\"text-danger\">\r\n");
      out.write("                                                    ");

                                                        if (session.getAttribute("passwordError") != null && session.getAttribute("emailError") != "") {
                                                            out.print(session.getAttribute("passwordError"));
                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <button class=\"btn btn-lg btn-primary btn-block\">Sign in</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
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
      out.write("                    </div>\r\n");
      out.write("                    <!-- wrap @e -->\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- main @e -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- app-root @e -->\r\n");
      out.write("        <!-- JavaScript -->\r\n");
      out.write("        <script src=\"./assets/js/bundle.js?ver=3.1.0\"></script>\r\n");
      out.write("        <script src=\"./assets/js/scripts.js?ver=3.1.0\"></script>\r\n");
      out.write("        <script src=\"./assets/js/charts/chart-ecommerce.js?ver=3.1.0\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<!--SQL CODE FOR AUTO INCREMENT ID\r\n");
      out.write("CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,\r\n");
      out.write("product_name VARCHAR(140) NOT NULL,\r\n");
      out.write("product_price DOUBLE,\r\n");
      out.write("product_image BLOB);-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
