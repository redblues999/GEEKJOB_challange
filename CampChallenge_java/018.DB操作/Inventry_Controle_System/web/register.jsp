<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="./register.jsp" method ="post">
            <p>商品コード<input type="text" name="code"></p>
            <p>商品名<input type="text" name="name"></p>
            <p>メーカー<input type="text" name="maker"></p>
            <p>在庫の量<input type="text" name="current_amount"></P>
            <input type="submit" value="この商品を登録する"><br>
       </form>
        <br><br><br><br><br>
        <form action="list" method="post">
            <p><input type="submit" value="商品一覧"></p>
        </form>
    </body>
    
</html>

<%
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
%>