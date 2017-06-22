package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <form action=\"./register.jsp\" method =\"post\">\n");
      out.write("            <p>商品コード<input type=\"text\" name=\"code\"></p>\n");
      out.write("            <p>商品名<input type=\"text\" name=\"name\"></p>\n");
      out.write("            <p>メーカー<input type=\"text\" name=\"maker\"></p>\n");
      out.write("            <p>在庫の量<input type=\"text\" name=\"current_amount\"></P>\n");
      out.write("            <input type=\"submit\" value=\"商品登録\"><br>\n");
      out.write("       </form>\n");
      out.write("        \n");
      out.write("        <form action=\"list\" method=\"post\">\n");
      out.write("            <p><input type=\"submit\" value=\"商品一覧\"></p>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
      out.write("\n");

request.setCharacterEncoding("UTF-8");
String str1 = request.getParameter("code");
String str2 = request.getParameter("name");
String str3 = request.getParameter("maker");
String str4 = request.getParameter("current_amount");
        
if(str1 != null){
        try{
            
        Connection db_con       = null;
        PreparedStatement db_st = null;
        //ResultSet db_data       = null;
        int db = 0;
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventry_controle","root","");
            
            db_st = db_con.prepareStatement("insert into production values (?,?,?,?)");
            db_st.setString(1, str1);
            db_st.setString(2, str2);
            db_st.setString(3, str3);
            db_st.setString(4, str4);
            
            db = db_st.executeUpdate();
            
            //db_data.close();
            db_st.close();
            db_con.close();
            
            } catch (SQLException e_sql) {
            out.println("接続時にSQLエラーが発生しました:"+e_sql.toString());
            
        } catch (Exception e ) {
            out.println("接続時に例外エラーが発生しました:"+e.toString());
        } 
            
}

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
