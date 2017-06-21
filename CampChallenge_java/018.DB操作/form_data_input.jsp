<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <form action="./form_data_input.jsp" method ="get"><!-- クエリストリングの作成 -->
            ID<input type="text" name="id"><br><br>
            名前<input type="text" name="name"><br><br>
            電話番号<input type="text" name="tell"><br><br>
            年齢<input type="text" name="age"><br><br>
            誕生年月日<input type="text" name="birthday"><br><br>
            <input type="submit" value="更新"><br><!--　クエリを保持したままページを更新 -->
    </body>
    </body>
</html>

<%
request.setCharacterEncoding("UTF-8");
String str1 = request.getParameter("id");
String str2 = request.getParameter("name");
String str3 = request.getParameter("tell");
String str4 = request.getParameter("age");
String str5 = request.getParameter("birthday");
        
if(str1 != null){
        try{
            
        Connection db_con       = null;
        PreparedStatement db_st = null;
        ResultSet db_data       = null;
        int db = 0;
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
            
            db_st = db_con.prepareStatement("insert into profiles values (?,?,?,?,?)");
            db_st.setString(1, str1);
            db_st.setString(2, str2);
            db_st.setString(3, str3);
            db_st.setString(4, str4);
            db_st.setString(5, str5);
            
            db = db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("select * from profiles");
            
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
        } 
            
}
%>