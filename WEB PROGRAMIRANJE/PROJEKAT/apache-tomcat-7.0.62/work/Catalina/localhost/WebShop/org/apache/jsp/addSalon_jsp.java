/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.62
 * Generated at: 2015-07-05 21:52:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addSalon_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <title>Administrator Login</title>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("\t<!--link rel=\"stylesheet/less\" href=\"less/bootstrap.less\" type=\"text/css\" /-->\n");
      out.write("\t<!--link rel=\"stylesheet/less\" href=\"less/responsive.less\" type=\"text/css\" /-->\n");
      out.write("\t<!--script src=\"js/less-1.3.3.min.js\"></script-->\n");
      out.write("\t<!--append Ã¢ÂÂ#!watchÃ¢ÂÂ to the browser URL, then refresh the page. -->\n");
      out.write("\t\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/smoke.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/addSalonStyle.css\" rel=\"stylesheet\">\n");
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
      out.write("\t<script type=\"text/javascript\" src=\"js/smoke.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/addSalonScripts.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/loginCheckScript.js\"></script>\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t\t<input type=\"hidden\" id=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<div class=\"row clearfix\">\n");
      out.write("\t\t<div class=\"col-md-12 column\">\n");
      out.write("\t\t\t<h2 class=\"text-info\">\n");
      out.write("\t\t\tBlack Magic Woman - PRODAVNICA NAMESTAJA\n");
      out.write("\t\t\t</h2>\n");
      out.write("\t\t\t<h4 class=\"text-info\"> Rad sa salonima - dodavanje salona</h4>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<form id=\"back_form\" action=\"SalonStartServlet\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t<button id=\"rad_saloni\" class=\"btn btn-default\" type=\"submit\" form=\"back_form\">\n");
      out.write("\t\t\t\t\t\t\t Povratak\n");
      out.write("\t\t\t</button> \n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<br>\t\t\t\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<form  id=\"coki\" role=\"form\" method=\"post\" action=\"SalonStartServlet\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- PIB input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">PIB</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"pib\" name=\"pib\" placeholder=\"Unesite pib salona\" class=\"form-control input-md\" smk-type=\"number\" minlength=\"9\" maxlength=\"9\"  type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- NAZIV input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Naziv salona</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"name\" name=\"name\" placeholder=\"Unesite naziv salona\" class=\"form-control input-md\" type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- MB input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Maticni broj</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"mb\" name=\"mb\" placeholder=\"Unesite maticni broj salona\" smk-type=\"number\" minlength=\"13\" maxlength=\"13\" class=\"form-control input-md\" type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- ADRESA input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Adresa salona</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"adress\" name=\"adress\" placeholder=\"Unesite adresu salona\" class=\"form-control input-md\" type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- TELEFON input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Telefon salona</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"phone\" name=\"phone\" placeholder=\"Unesite telefon salona\" class=\"form-control input-md\" type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- EMAIL input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Email salona</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"email\" name=\"email\" placeholder=\"Unesite email salona\" class=\"form-control input-md\" type=\"email\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- WWW input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Web stranica salona</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"www\" name=\"www\" placeholder=\"Unesite web stranicu salona\" class=\"form-control input-md\" type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- BZR input-->\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Ziro racun salona</label>  \n");
      out.write("\t\t\t\t  <div>\n");
      out.write("\t\t\t\t  <input id=\"bzr\" name=\"bzr\" placeholder=\"Unesite ziro racun salona\" class=\"form-control input-md\" type=\"text\" required>  \n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t <button  name=\"salonButton\"  id=\"dugme\" type=\"submit\" class=\"btn btn-default\">Unesi salon</button>\n");
      out.write("\t\t\t</form>\n");
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
