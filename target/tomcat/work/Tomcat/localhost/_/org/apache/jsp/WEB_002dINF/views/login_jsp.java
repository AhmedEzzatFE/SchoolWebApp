/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-09-06 10:15:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>School</title>\r\n");
      out.write("    <link href=\"webjars/bootstrap/3.3.6/css/bootstrap.min.css\"\r\n");
      out.write("          rel=\"stylesheet\">\r\n");
      out.write("    <style>\r\n");
      out.write("        .container{\r\n");
      out.write("            padding-top: 100px;\r\n");
      out.write("            padding-left: 100px;\r\n");
      out.write("            background-color: darkgray}\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function validateForm() {\r\n");
      out.write("            var x = document.forms[\"myForm\"][\"Username\"].value;\r\n");
      out.write("            var y = document.forms[\"myForm\"][\"password\"].value;\r\n");
      out.write("           if(x === \"\" & y===\"\"){\r\n");
      out.write("               document.getElementById(\"error\").innerHTML = \"Empty Fields, Please enter your Credentials \";\r\n");
      out.write("               return false;\r\n");
      out.write("           }\r\n");
      out.write("            else if (x === \"\") {\r\n");
      out.write("                document.getElementById(\"error\").innerHTML = \"No Username found , Please Enter your Username\";\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("            else if (y===\"\"){\r\n");
      out.write("                document.getElementById(\"error\").innerHTML = \"No Password found , Please Enter your Password    \";\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"container\">\r\n");
      out.write("<div>\r\n");
      out.write("    <form action=\"/login.do\" method=\"post\"  name=\"myForm\" onsubmit=\"return validateForm()\" required>\r\n");
      out.write("        <p id=\"error\">\r\n");
      out.write("            <font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("        </p>\r\n");
      out.write("        Username: <input type=\"text\" name=\"Username\" /> Password:<input\r\n");
      out.write("            type=\"password\" name=\"password\" /> <BR/><br/><input type=\"submit\" value=\"Login\" /> <a href=\"/signup.do\" class=\"btn\">Sign Up</a>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
