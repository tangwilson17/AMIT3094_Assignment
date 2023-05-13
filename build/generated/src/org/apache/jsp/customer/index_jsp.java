package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import entity.Product;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/customer/header.jsp");
    _jspx_dependants.add("/customer/navbar.jsp");
    _jspx_dependants.add("/customer/footer.jsp");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    ");
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
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<div id=\"header-wrap\">\n");
      out.write("\t\n");
      out.write("\t<div class=\"top-content\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-md-6\">\n");
      out.write("\t\t\t\t\t<div class=\"social-links\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-facebook\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-twitter\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-youtube-play\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-behance-square\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div><!--social-links-->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-6\">\n");
      out.write("\t\t\t\t\t<div class=\"right-element\">\n");
      out.write("\t\t\t\t\t\t<a href=\"../DisplayProfile\" class=\"user-account for-buy\"><i class=\"icon icon-user\"></i><span>Account</span></a>\n");
      out.write("\t\t\t\t\t\t<a href=\"cart.jsp\" class=\"cart for-buy\"><i class=\"icon icon-clipboard\"></i><span>Cart:(0 $)</span></a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"action-menu\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"search-bar\">\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"search-button search-toggle\" data-selector=\"#header-wrap\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon icon-search\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t<form role=\"search\" method=\"get\" class=\"search-box\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"search-field text search-input\" placeholder=\"Search\" type=\"search\">\n");
      out.write("\t\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</div><!--top-right-->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div><!--top-content-->\n");
      out.write("\n");
      out.write("\t<header id=\"header\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"col-md-2\">\n");
      out.write("\t\t\t\t\t<div class=\"main-logo\">\n");
      out.write("\t\t\t\t\t\t<a href=\"index.html\"><img src=\"images/main-logo.png\" alt=\"logo\"></a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"col-md-10\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<nav id=\"navbar\">\n");
      out.write("\t\t\t\t\t\t<div class=\"main-menu stellarnav\">\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"menu-list\">\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item active\"><a href=\"index.jsp\" data-effect=\"Home\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"#about\" class=\"nav-link\" data-effect=\"About\">About</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item has-sub\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#pages\" class=\"nav-link\" data-effect=\"Pages\">Pages</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t        <li class=\"active\"><a href=\"index.html\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"about.html\">About</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"styles.html\">Styles</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"blog.html\">Blog</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"single-post.html\">Post Single</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"shop.html\">Our Store</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"single-product.html\">Product Single</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t        <li><a href=\"thank-you.html\">Thank You</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t     </ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"../DisplayProduct\" class=\"nav-link\" data-effect=\"Shop\">Shop</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"#latest-blog\" class=\"nav-link\" data-effect=\"Articles\">Articles</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"menu-item\"><a href=\"#contact\" class=\"nav-link\" data-effect=\"Contact\">Contact</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"hamburger\">\n");
      out.write("\t\t\t\t                <span class=\"bar\"></span>\n");
      out.write("\t\t\t\t                <span class=\"bar\"></span>\n");
      out.write("\t\t\t\t                <span class=\"bar\"></span>\n");
      out.write("\t\t\t\t            </div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>\n");
      out.write("\t\t\n");
      out.write("</div><!--header-wrap-->");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../DisplayProductIndex", out, false);
      out.write("\r\n");
      out.write("        ");
    List<Product> prodList = (List) session.getAttribute("prodList");
      out.write("\r\n");
      out.write("        <section id=\"billboard\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("\r\n");
      out.write("                        <button class=\"prev slick-arrow\">\r\n");
      out.write("                            <i class=\"icon icon-arrow-left\"></i>\r\n");
      out.write("                        </button>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"main-slider pattern-overlay\">\r\n");
      out.write("                            ");

                                for (int i = 0; i < 2 && i < prodList.size(); i++) {
                                    Product product = (Product) prodList.get(i);

                            
      out.write("\r\n");
      out.write("                            <div class=\"slider-item\">\r\n");
      out.write("                                <div class=\"banner-content\">\r\n");
      out.write("                                    <h2 class=\"banner-title\">");
      out.print( product.getProductname() );
      out.write("</h2>\r\n");
      out.write("                                    <p>");
      out.print( product.getDescription() );
      out.write("</p>\r\n");
      out.write("                                    <div class=\"btn-wrap\">\r\n");
      out.write("                                        <a href=\"../ProductDetails?prodID=");
      out.print( product.getProductid());
      out.write("&catID=");
      out.print( product.getCategorycode().getCategoryid());
      out.write("\" class=\"btn btn-outline-accent btn-accent-arrow\">Read More<i class=\"icon icon-ns-arrow-right\"></i></a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div><!--banner-content--> \r\n");
      out.write("                                <img src=\"data:image/png;base64,");
      out.print( new String(Base64.getEncoder().encode(product.getImage())));
      out.write("\" alt=\"banner\" class=\"banner-image\">\r\n");
      out.write("                            </div><!--slider-item-->\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div><!--slider-->\r\n");
      out.write("\r\n");
      out.write("                        <button class=\"next slick-arrow\">\r\n");
      out.write("                            <i class=\"icon icon-arrow-right\"></i>\r\n");
      out.write("                        </button>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"client-holder\" data-aos=\"fade-up\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"inner-content\">\r\n");
      out.write("                        <div class=\"logo-wrap\">\r\n");
      out.write("                            <div class=\"grid\">\r\n");
      out.write("                                <a href=\"#\"><img src=\"images/client-image1.png\" alt=\"client\"></a>\r\n");
      out.write("                                <a href=\"#\"><img src=\"images/client-image2.png\" alt=\"client\"></a>\r\n");
      out.write("                                <a href=\"#\"><img src=\"images/client-image3.png\" alt=\"client\"></a>\r\n");
      out.write("                                <a href=\"#\"><img src=\"images/client-image4.png\" alt=\"client\"></a>\r\n");
      out.write("                                <a href=\"#\"><img src=\"images/client-image5.png\" alt=\"client\"></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div><!--image-holder-->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"featured-books\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"section-header align-center\">\r\n");
      out.write("                            <div class=\"title\">\r\n");
      out.write("                                <span>Some quality items</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <h2 class=\"section-title\">Featured Books</h2>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"product-list\" data-aos=\"fade-up\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                            ");

                                for (int i = 0; i < 4 && i < prodList.size(); i++) {
                                    Product product = (Product) prodList.get(i);

                            
      out.write("\r\n");
      out.write("                                <div class=\"col-md-3\">\r\n");
      out.write("                                    <figure class=\"product-style\">\r\n");
      out.write("                                        <img src=\"data:image/png;base64,");
      out.print( new String(Base64.getEncoder().encode(product.getImage())));
      out.write("\" alt=\"Books\" class=\"product-item\">\r\n");
      out.write("                                        <figcaption>\r\n");
      out.write("                                            <h3><a href=\"../ProductDetails?prodID=");
      out.print( product.getProductid());
      out.write("&catID=");
      out.print( product.getCategorycode().getCategoryid());
      out.write('"');
      out.write('>');
      out.print( product.getProductname() );
      out.write("</a></h3>\r\n");
      out.write("                                            <p>");
      out.print( product.getCategorycode().getCategoryid() );
      out.write("</p>\r\n");
      out.write("                                            <div class=\"item-price\">RM ");
      out.print( product.getPrice() );
      out.write("</div>\r\n");
      out.write("                                        </figcaption>\r\n");
      out.write("                                    </figure>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                ");
}
      out.write("\r\n");
      out.write("                            </div><!--ft-books-slider-->\t\t\t\t\r\n");
      out.write("                        </div><!--grid-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div><!--inner-content-->\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"btn-wrap align-right\">\r\n");
      out.write("                            <a href=\"../DisplayProduct\" class=\"btn-accent-arrow\">View all products <i class=\"icon icon-ns-arrow-right\"></i></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\t\t\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("        ");
      out.write("<footer id=\"footer\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"col-md-4\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"footer-item\">\n");
      out.write("\t\t\t\t\t<div class=\"company-brand\">\n");
      out.write("\t\t\t\t\t\t<img src=\"images/main-logo.png\" alt=\"logo\" class=\"footer-logo\">\n");
      out.write("\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sagittis sed ptibus liberolectus nonet psryroin. Amet sed lorem posuere sit iaculis amet, ac urna. Adipiscing fames semper erat ac in suspendisse iaculis.</p>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"col-md-2\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"footer-menu\">\n");
      out.write("\t\t\t\t\t<h5>About Us</h5>\n");
      out.write("\t\t\t\t\t<ul class=\"menu-list\">\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">vision</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">articles </a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">careers</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">service terms</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">donate</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-md-2\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"footer-menu\">\n");
      out.write("\t\t\t\t\t<h5>Discover</h5>\n");
      out.write("\t\t\t\t\t<ul class=\"menu-list\">\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Home</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Books</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Authors</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Subjects</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Advanced Search</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-md-2\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"footer-menu\">\n");
      out.write("\t\t\t\t\t<h5>My account</h5>\n");
      out.write("\t\t\t\t\t<ul class=\"menu-list\">\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Sign In</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">View Cart</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">My Wishtlist</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Track My Order</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-md-2\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"footer-menu\">\n");
      out.write("\t\t\t\t\t<h5>Help</h5>\n");
      out.write("\t\t\t\t\t<ul class=\"menu-list\">\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Help center</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Report a problem</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Suggesting edits</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\">Contact us</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- / row -->\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<div id=\"footer-bottom\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"copyright\">\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-6\">\n");
      out.write("\t\t\t\t\t\t\t<p>Â© 2022 All rights reserved. Free HTML Template by <a href=\"https://www.templatesjungle.com/\" target=\"_blank\">TemplatesJungle</a></p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-6\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"social-links align-right\">\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-facebook\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-twitter\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-youtube-play\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><i class=\"icon icon-behance-square\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div><!--grid-->\n");
      out.write("\n");
      out.write("\t\t\t</div><!--footer-bottom-content-->\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("        <script src=\"js/plugins.js\"></script>\r\n");
      out.write("        <script src=\"js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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