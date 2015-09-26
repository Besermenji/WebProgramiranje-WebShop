/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.62
 * Generated at: 2015-07-06 02:43:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class izborUloga_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Izaberite vasu ulogu!</title>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <meta name=\"description\" content=\"stranica u kojoj se bira uloga korisnika\">\n");
      out.write("  <meta name=\"author\" content=\"Besermenji\">\n");
      out.write("\n");
      out.write("\t<!--link rel=\"stylesheet/less\" href=\"less/bootstrap.less\" type=\"text/css\" /-->\n");
      out.write("\t<!--link rel=\"stylesheet/less\" href=\"less/responsive.less\" type=\"text/css\" /-->\n");
      out.write("\t<!--script src=\"js/less-1.3.3.min.js\"></script-->\n");
      out.write("\t<!--append Ã¢ÂÂ#!watchÃ¢ÂÂ to the browser URL, then refresh the page. -->\n");
      out.write("\t\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/izborUlogaStyle.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("  <!--[if lt IE 9]>\n");
      out.write("    <script src=\"js/html5shiv.js\"></script>\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("  <!-- Fav and touch icons -->\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"img/apple-touch-icon-144-precomposed.png\">\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"img/apple-touch-icon-114-precomposed.png\">\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"img/apple-touch-icon-72-precomposed.png\">\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" href=\"img/apple-touch-icon-57-precomposed.png\">\n");
      out.write("  <link rel=\"shortcut icon\" href=\"img/favicon.png\">\n");
      out.write("  \n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/izborUlogaScripts.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<div class=\"row clearfix\">\n");
      out.write("\t\t<div class=\"col-md-12 column\">\n");
      out.write("\t\t\t<h3>\n");
      out.write("\t\t\t\tIzaberite ulogu za logovanje:\n");
      out.write("\t\t\t</h3>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<div class=\"row clearfix\">\n");
      out.write("\t\t\t\t<form  method=\"post\" action=\"loginPageRedirectServlet\">\n");
      out.write("\t\t\t\t<div class=\"col-md-4 column\">\n");
      out.write("\t\t\t\t\t <button name=\"user\" type=\"submit\" class=\"btn btn-lg\">Korisnik</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-4 column\">\n");
      out.write("\t\t\t\t\t <button name=\"manager\" type=\"submit\" class=\"btn btn-lg\">Menadzer</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-4 column\">\n");
      out.write("\t\t\t\t\t <button name=\"admin\" type=\"submit\" class=\"btn btn-lg\">Administrator</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"InitServlet\">\n");
      out.write("\t\t\t\t\t<button type=\"submit\">Inicijalizuj</button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
