/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.62
 * Generated at: 2015-07-05 21:46:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <title>Administrator Login</title>\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <meta name=\"description\" content=\"\">\r\n");
      out.write("  <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("\t<!--link rel=\"stylesheet/less\" href=\"less/bootstrap.less\" type=\"text/css\" /-->\r\n");
      out.write("\t<!--link rel=\"stylesheet/less\" href=\"less/responsive.less\" type=\"text/css\" /-->\r\n");
      out.write("\t<!--script src=\"js/less-1.3.3.min.js\"></script-->\r\n");
      out.write("\t<!--append ÃÂ¢ÃÂÃÂ#!watchÃÂ¢ÃÂÃÂ to the browser URL, then refresh the page. -->\r\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/smoke.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/addCategoryStyle.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("  <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"js/html5shiv.js\"></script>\r\n");
      out.write("  <![endif]-->\r\n");
      out.write("\r\n");
      out.write("  <!-- Fav and touch icons -->\r\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"img/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"img/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"img/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\" href=\"img/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("  <link rel=\"shortcut icon\" href=\"img/favicon.png\">\r\n");
      out.write("  \r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/smoke.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/addCategoryScripts.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/loginCheckScript.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div class=\"row clearfix\">\r\n");
      out.write("\t\t<div class=\"col-md-12 column\">\r\n");
      out.write("\t\t\t<h2 class=\"text-info\">\r\n");
      out.write("\t\t\tBlack Magic Woman - PRODAVNICA NAMESTAJA\r\n");
      out.write("\t\t\t</h2>\r\n");
      out.write("\t\t\t<h4 class=\"text-info\"> Rad sa kategorijama - dodavanje kategorije</h4>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<form id=\"back_form\" action=\"CategoryStartServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<button id=\"rad_saloni\" class=\"btn btn-default\" type=\"submit\" form=\"back_form\">\r\n");
      out.write("\t\t\t\t\t\t\t Povratak\r\n");
      out.write("\t\t\t</button> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br>\t\t\t\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<form  id=\"coki\" role=\"form\" method=\"post\" action=\"CategoryStartServlet\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- NAZIV input-->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Naziv kategorije</label>  \r\n");
      out.write("\t\t\t\t  <div>\r\n");
      out.write("\t\t\t\t  <input id=\"name\" name=\"name\" placeholder=\"Unesite naziv kategorije\" class=\"form-control input-md\" type=\"text\" required>  \r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- OPIS input-->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Opis kategorije</label>  \r\n");
      out.write("\t\t\t\t  <div>\r\n");
      out.write("\t\t\t\t  <input id=\"description\" name=\"description\" placeholder=\"Unesite opis kategorije\" class=\"form-control input-md\" type=\"text\" required>  \r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- NAZIV input-->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t  <label  for=\"textinput\">Naziv parent kategorije</label>  \r\n");
      out.write("\t\t\t\t  <div>\r\n");
      out.write("\t\t\t\t          <select id=\"inWhatCategory\" name=\"inWhatCategory\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">Nema parent</option>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <button  name=\"salonButton\"  id=\"dugme\" type=\"submit\" class=\"btn btn-default\">Unesi salon</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /addCategory.jsp(88,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/addCategory.jsp(88,7) '${category}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${category}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /addCategory.jsp(88,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("k");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${k.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${k.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
