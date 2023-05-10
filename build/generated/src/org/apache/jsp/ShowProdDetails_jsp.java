package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import entity.Product;
import entity.Category;
import java.util.List;

public final class ShowProdDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/navbar.jsp");
    _jspx_dependants.add("/footer.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      entity.Product prod = null;
      synchronized (session) {
        prod = (entity.Product) _jspx_page_context.getAttribute("prod", PageContext.SESSION_SCOPE);
        if (prod == null){
          prod = new entity.Product();
          _jspx_page_context.setAttribute("prod", prod, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <html lang=\"zxx\" class=\"no-js\">\n");
      out.write("\n");
      out.write("        ");
      out.write("<head>\r\n");
      out.write("\t<!-- Mobile Specific Meta -->\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\t<!-- Favicon-->\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"img/fav.png\">\r\n");
      out.write("\t<!-- Author Meta -->\r\n");
      out.write("\t<meta name=\"author\" content=\"CodePixar\">\r\n");
      out.write("\t<!-- Meta Description -->\r\n");
      out.write("\t<meta name=\"description\" content=\"\">\r\n");
      out.write("\t<!-- Meta Keyword -->\r\n");
      out.write("\t<meta name=\"keywords\" content=\"\">\r\n");
      out.write("\t<!-- meta character set -->\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<!-- Site Title -->\r\n");
      out.write("\t<title>Dostyle</title>\r\n");
      out.write("\t<!--\r\n");
      out.write("\t\tCSS\r\n");
      out.write("\t\t============================================= -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/linearicons.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/themify-icons.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/nice-select.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/nouislider.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/ion.rangeSlider.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/ion.rangeSlider.skinFlat.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            Category category = (Category) session.getAttribute("category");
        
      out.write("\n");
      out.write("        <body>\n");
      out.write("            ");
      out.write("<!-- Start Header Area -->\r\n");
      out.write("<header class=\"header_area sticky-header\">\r\n");
      out.write("    <div class=\"main_menu\">\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light main_box\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("                <a class=\"navbar-brand logo_h\" href=\"index.html\"><img src=\"img/logo.png\" alt=\"\"></a>\r\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n");
      out.write("                        aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                <div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav menu_nav ml-auto\">\r\n");
      out.write("                        <li class=\"nav-item active\"><a class=\"nav-link\" href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"background.jsp\">About Us</a></li>\r\n");
      out.write("                        <li class=\"nav-item submenu dropdown\">\r\n");
      out.write("                            <a href=\"DisplayProduct\" class=\"nav-link dropdown-toggle\">Shop</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                        ");

                            if (session.getAttribute("customer") != null) {
                        
      out.write("\r\n");
      out.write("                        <li class=\"nav-item\"><a href=\"DisplayProfile\" class=\"cart\"><span class=\"ti-id-badge\">&nbsp;Profile</span></a></li>\r\n");
      out.write("                                ");
 } else {
      out.write("\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"cart\" href=\"login.jsp\"><span class=\"lnr lnr-user\"></span></a></li>\r\n");
      out.write("                            ");
 }
      out.write("\r\n");
      out.write("                        <li class=\"nav-item\"><a href=\"CartServlet\" class=\"cart\"><span class=\"lnr lnr-cart\"></span></a></li>\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <button class=\"search\"><span class=\"lnr lnr-magnifier\" id=\"search\"></span></button>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"search_input\" id=\"search_input_box\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <form class=\"d-flex justify-content-between\" method=\"POST\" action=\"searchProduct\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"search_input\" placeholder=\"Search Here\" name=\"searchProd\">\r\n");
      out.write("                <button type=\"submit\" class=\"btn\"></button>\r\n");
      out.write("                <span class=\"lnr lnr-cross\" id=\"close_search\" title=\"Close Search\"></span>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("<!-- End Header Area -->");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Start Banner Area -->\n");
      out.write("            <section class=\"banner-area organic-breadcrumb\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end\">\n");
      out.write("                        <div class=\"col-first\">\n");
      out.write("                            <h1>Product Details Page</h1>\n");
      out.write("                            <nav class=\"d-flex align-items-center\">\n");
      out.write("                                <a href=\"index.html\">Home<span class=\"lnr lnr-arrow-right\"></span></a>\n");
      out.write("                                <a href=\"#\">Shop<span class=\"lnr lnr-arrow-right\"></span></a>\n");
      out.write("                                <a href=\"single-product.html\">product-details</a>\n");
      out.write("                            </nav>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!-- End Banner Area -->\n");
      out.write("\n");
      out.write("            <!--================Single Product Area =================-->\n");
      out.write("            <div class=\"product_image_area\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row s_product_inner\">\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <div class=\"single-prd-item\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"data:image/png;base64,");
      out.print( new String(Base64.getEncoder().encode(prod.getImage())));
      out.write("\" alt=\"");
      out.print( prod.getProductname());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-lg-5 offset-lg-1\">\n");
      out.write("                            <div class=\"s_product_text\">\n");
      out.write("                                <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${prod.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                                <h2>RM");
      out.print( String.format("%.2f", prod.getPrice()));
      out.write("</h2>\n");
      out.write("                                <ul class=\"list\">\n");
      out.write("                                    <li><span>Category</span> : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${category.categoryname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                                    <li><span>Material</span> : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${category.categorydesc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                                    <li><span>Stock Status</span> : \n");
      out.write("                                        ");

                                            int status = prod.getStatus(); // Get the status value from the prod object
                                            if (status == 0) {
                                        
      out.write("\n");
      out.write("                                        Out of Stock\n");
      out.write("                                        ");

                                        } else if (status == 1) {
                                        
      out.write("\n");
      out.write("                                        In Stock\n");
      out.write("                                        ");

                                            }
                                        
      out.write("</li>\n");
      out.write("                                </ul>\n");
      out.write("\n");
      out.write("                                <div class=\"product_count\">\n");
      out.write("                                    ");

                                        if (prod.getQty() > 0) {
                                    
      out.write("\n");
      out.write("                                    <label for=\"qty\">Quantity:</label>\n");
      out.write("                                    <input type=\"number\" name=\"qty\" min=\"1\" max=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${prod.qty}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" value=\"1\" class=\"input-text qty\">\n");
      out.write("                                    <br><br>\n");
      out.write("                                    <div class=\"card_area d-flex align-items-center\">\n");
      out.write("                                        <a class=\"primary-btn\" href=\"CartServlet?id=");
      out.print( prod.getProductid());
      out.write("&action=addtocart\">Add to Cart</a>\n");
      out.write("                                        <a class=\"primary-btn\" href=\"CartServlet?id=");
      out.print( prod.getProductid());
      out.write("&action=buynow\" style=\"margin-left: 10px;\">Buy now</a>                                        ");

                                        } else {
                                        
      out.write("\n");
      out.write("                                        <br>\n");
      out.write("                                        <b style=\"color: red;\">Sold Out</b>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--================End Single Product Area =================-->\n");
      out.write("\n");
      out.write("            <!--================Product Description Area =================-->\n");
      out.write("            <section class=\"product_description_area\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("                        <h2>Product Description</h2>\n");
      out.write("                        <p>");
      out.print( prod.getDescription().replaceAll("!", "<br>"));
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("            </section>\n");
      out.write("            <!--================End Product Description Area =================-->\n");
      out.write("\n");
      out.write("            ");
      out.write("<!-- start footer Area -->\r\n");
      out.write("        <footer class=\"footer-area section_gap\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-3  col-md-6 col-sm-6\">\r\n");
      out.write("                        <div class=\"single-footer-widget\">\r\n");
      out.write("                            <h6>Welcome</h6>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                DOStyle is a clothing store where you can trust us with your fashion. Please have a look at our background.\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                <a href=\"background.jsp\">About Us</a>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-4  col-md-6 col-sm-6\">\r\n");
      out.write("                        <div class=\"single-footer-widget\">\r\n");
      out.write("                            <h6>Services</h6>\r\n");
      out.write("                            <p>Our services include styling advice, custom tailoring, and a convenient online shopping experience. Shop with us for the latest trends and style today.</p>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                <a href=\"DisplayProduct\">Product</a>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3  col-md-6 col-sm-6\">\r\n");
      out.write("                        <div class=\"single-footer-widget mail-chimp\">\r\n");
      out.write("                            <h6 class=\"mb-20\">Contact Us</h6>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                <a>Feel free to contact us if any doubt. We will try to answer you as quick as possible</a>\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                <a href=\"contact.jsp\">Contact Us</a>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-2 col-md-6 col-sm-6\">\r\n");
      out.write("                        <div class=\"single-footer-widget\">\r\n");
      out.write("                            <h6>Follow Us</h6>\r\n");
      out.write("                            <p>Let us be social</p>\r\n");
      out.write("                            <div class=\"footer-social d-flex align-items-center\">\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-behance\"></i></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-bottom d-flex justify-content-center align-items-center flex-wrap\">\r\n");
      out.write("                    <p class=\"footer-text m-0\"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This website is made with <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">DoStyle</a>\r\n");
      out.write("                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <!-- End footer Area -->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/vendor/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\"\r\n");
      out.write("        crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.ajaxchimp.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.sticky.js\"></script>\r\n");
      out.write("        <script src=\"js/nouislider.min.js\"></script>\r\n");
      out.write("        <script src=\"js/countdown.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <!--gmaps Js-->\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE\"></script>\r\n");
      out.write("        <script src=\"js/gmaps.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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
