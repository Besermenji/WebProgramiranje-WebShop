/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.62
 * Generated at: 2015-07-06 03:02:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class managerStartPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE jsp:useBean PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<!-- iz dbPlay apdejtujemo kombo boxeve -->\r\n");
      beans.dbPlay db = null;
      db = (beans.dbPlay) _jspx_page_context.getAttribute("db", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (db == null){
        db = new beans.dbPlay();
        _jspx_page_context.setAttribute("db", db, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    <title>Pocetna - manager</title>\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"description\" content=\"Source code generated using layoutit.com\">\r\n");
      out.write("    <meta name=\"author\" content=\"LayoutIt!\">\r\n");
      out.write("\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/smoke.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/adminStartStyle.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/smoke.min.js\"></script>\r\n");
      out.write("    <script src=\"js/managerStartScripts.js\"></script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/loginCheckScript.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\t<input type=\"hidden\" id=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t<h2 class=\"text-info\">\r\n");
      out.write("\t\t\tBlack Magic Woman - PRODAVNICA NAMESTAJA\r\n");
      out.write("\t\t\t</h2>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t<form id=\"izvestaj_form\" action=\"ReportStartServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<form id=\"namestaj_form\" action=\"ProductActionStartServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<form id=\"kategorija_akcija_form\" action=\"ActionServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"manag\" value=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<button id=\"rad_kategorije\"  class=\"btn btn-default\" type=\"submit\" form=\"izvestaj_form\">\r\n");
      out.write("\t\t\t\t\t\t\t Pregled izvestaja\r\n");
      out.write("\t\t\t\t\t\t</button> \r\n");
      out.write("\t\t\t\t\t\t<button id=\"rad_namestaj\" class=\"btn btn-default\" type=\"submit\" form=\"namestaj_form\">\r\n");
      out.write("\t\t\t\t\t\t\t Dodavanje akcija namestaju\r\n");
      out.write("\t\t\t\t\t\t</button> \r\n");
      out.write("\t\t\t\t\t\t<button id=\"akcija_kategorija\" class=\"btn btn-default\" type=\"submit\" form=\"kategorija_akcija_form\">\r\n");
      out.write("\t\t\t\t\t\t\t Dodavanje akcije kategoriji\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t<button id=\"logout_dugme\" type=\"button\" class=\"btn btn-default pull-right\">\r\n");
      out.write("\t\t\t\t\t\tOdjava sa sistema\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<h4 class=\"text-info\">Pretraga namestaja</h4>\r\n");
      out.write("\t\t\t<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"namestaj_name\" class=\"form-control\"  placeholder=\"Unesite naziv namestaja\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opseg cene<strong class=\"caret\"></strong></a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form action=\"[YOUR ACTION]\" method=\"post\" accept-charset=\"UTF-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input smk-type=\"number\" id=\"min_cena\" style=\"margin-bottom: 15px;\" type=\"text\" placeholder=\"Min cena\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input smk-type=\"number\" id=\"max_cena\" style=\"margin-bottom: 15px;\" type=\"text\" placeholder=\"Max cena\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <label class=\"col-md-4 control-label\" for=\"button_cena\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button id=\"button_cena\" type=\"button\" name=\"button_cena\" class=\"btn btn-default\">Postavi</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opseg kolicine<strong class=\"caret\"></strong></a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form action=\"[YOUR ACTION]\" method=\"post\" accept-charset=\"UTF-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input smk-type=\"number\" id=\"min_kolicina\" style=\"margin-bottom: 15px;\" type=\"text\" placeholder=\"Min kolicina\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input smk-type=\"number\" id=\"max_kolicina\" style=\"margin-bottom: 15px;\" type=\"text\" placeholder=\"Max kolicina\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <label class=\"col-md-4 control-label\" for=\"button_kolicina\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button id=\"button_kolicina\" type=\"button\" name=\"button_cena\" class=\"btn btn-default\">Postavi</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t <form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">  \r\n");
      out.write("\t\t\t\t  \t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t          \t\t\t\t<select id=\"kategorijeDD\" name=\"kategorijeDD\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Sve kategorije</option>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t\t \t\t\t\t </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li >\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">  \r\n");
      out.write("\t\t\t\t  \t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t          \t\t\t\t<select id=\"zemljeDD\" name=\"zemljeDD\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Sve zemlje</option>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t\t \t\t\t\t </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Godina proizvodnje<strong class=\"caret\"></strong></a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form action=\"[YOUR ACTION]\" method=\"post\" accept-charset=\"UTF-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input smk-type=\"number\" id=\"min_godina\" style=\"margin-bottom: 15px;\" type=\"text\" placeholder=\"Min godina\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input smk-type=\"number\" id=\"max_godina\" style=\"margin-bottom: 15px;\" type=\"text\" placeholder=\"Max godina\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <label class=\"col-md-4 control-label\" for=\"button_cena\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button id=\"button_godina\" type=\"button\" name=\"button_cena\" class=\"btn btn-default\">Postavi</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t <form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">  \r\n");
      out.write("\t\t\t\t  \t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t          \t\t\t\t<select id=\"bojeDD\" name=\"bojeDD\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Sve boje</option>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t\t \t\t\t\t </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t <form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">  \r\n");
      out.write("\t\t\t\t  \t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t          \t\t\t\t<select id=\"producersDD\" name=\"producersDD\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Svi proizvodjaci</option>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t\t \t\t\t\t </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"pretraga_namestaj\" type=\"button\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tPretraga\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</li>\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<h4 class=\"text-info\">Pretraga dodatnih usluga</h4>\r\n");
      out.write("\t\t\t<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- UNOS IMENA DODATNOG SERVISA -->\r\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"serviceName\" class=\"form-control\"  placeholder=\"Naziv usluge\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"serviceDescription\" class=\"form-control\"  placeholder=\"Opis usluge\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"navbar-form navbar-left\" role=\"search\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"pretraga_usluga\" type=\"button\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tPretraga\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</li>\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table id=\"prikaz_namestaj\" class=\"table table-hover\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tSifra\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tSlika\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tNaziv\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tBoja\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tZemlja proizvodnje\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tNaziv proizvodjaca\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tAkcija\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tPocetak akcije\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tKraj akcije\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tPopust u procentima\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tCena\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tKolicina na lageru\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tBesplatna usluga\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tKategorija namestaja\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tGodina proizvodnje\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tProdajni salon\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tYoutube Video\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"namestaj_bodi\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<table id=\"prikaz_usluga\" class=\"table table-hover\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tIme\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tOpis\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\tCena\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"usluge_bodi\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
