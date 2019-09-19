package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Insert title here</title>\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"923881149215-eqacititaiolmnug083n3g59o5qsn6i6.apps.googleusercontent.com\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function onSignIn(googleUser) {\n");
      out.write("                // window.location.href='success.jsp';\n");
      out.write("                var profile = googleUser.getBasicProfile();\n");
      out.write("                var email = profile.getEmail();\n");
      out.write("                console.log(\"correo: \" + email);\n");
      out.write("                document.getElementById(\"emaill\").value = email;\n");
      out.write("                document.getElementById(\"formulario\").submit();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <div class=\"user_type\">\n");
      out.write("            <div class=\"select_type\">\n");
      out.write("                <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" id=\"myP\"></div>\n");
      out.write("                <form name=\"data\" action=\"./loginGoogle.do\" method=\"POST\" style=\"display:none\" id=\"formulario\">\n");
      out.write("                    <input type=\"hidden\" name=\"email\" id=\"emaill\"/>\n");
      out.write("                    <input type=\"submit\" value=\"submit\" id=\"subas\"/>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"google_login\"></div>\n");
      out.write("        <div class=\"workspace\">\n");
      out.write("            <h1 class=\"uscore\">UScore</h1>\n");
      out.write("        </div>\n");
      out.write("    <footer>\n");
      out.write("        UFPS Cúcuta <br> 2019 © All Rights Reserved. <br> Visualización de calificaciones en la Universidad\n");
      out.write("\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>");
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
