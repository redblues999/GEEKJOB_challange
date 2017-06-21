<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./form_make_search.jsp" method ="get"><!-- クエリストリングの作成 -->
            名前を検索
            <input type ="test" name ="search"><br><br>
            <input type="submit" value="更新"><br><!--　クエリを保持したままページを更新 -->
    </body>
</html>

<%
request.setCharacterEncoding("UTF-8");
String str1 = request.getParameter("search");
if(str1 != null){

        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        int db = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
            db_st = db_con.prepareStatement("select * from profiles where name like ?");
            /*両方を%で囲む>部分一致
              前方を%で囲む>前方一致
              後方を%で囲む>後方一致*/
            db_st.setString(1, "%"+ str1+"%");
            db_data = db_st.executeQuery();
            while(db_data.next()){
                out.print(db_data.getString("profilesID")+"<br>");
                out.print(db_data.getString("name")+"<br>");
                out.print(db_data.getString("tell")+"<br>");
                out.print(db_data.getString("age")+"<br>");
                out.print(db_data.getString("birthday")+"<br>");
            }
            
            db_data.close();
            db_st.close();
            db_con.close();
            
 } catch (SQLException e_sql) {
            out.println("接続時にSQLエラーが発生しました:"+e_sql.toString());
            
        } catch (Exception e ) {
            out.println("接続時に例外エラーが発生しました:"+e.toString());
        } finally {
            if (db_con != null) {
                try{
                    db_con.close();
                } catch (Exception e_con){
                    out.println(e_con.getMessage());
                }
            }
        }
}
        
%>