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
        <form action="./composite_search.jsp" method ="get">
                 <p>名前<input type="text" name="name"></p>
                 <p>年齢<input type="text" name="age"></p>
                 <p>誕生日<input type="text" name="birthday"></p>
            <input type="submit" value="複合検索"><br>
    </body>
    </body>
</html>

<%
request.setCharacterEncoding("UTF-8");
String str1 = request.getParameter("name");
String str2 = request.getParameter("age");
String str3 = request.getParameter("birthday");

//論理演算子 && は、「または」を示す
if(str1 != null && str2 != null && str3 != null){
        try{
            
        Connection db_con       = null;
        PreparedStatement db_st = null;
        ResultSet db_data       = null;
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
            
            db_st = db_con.prepareStatement("select * from profiles where name=? or age=? or birthday=?");
            db_st.setString(1, str1);
            db_st.setString(2, str2);
            db_st.setString(3, str3);       
            db_data = db_st.executeQuery();
            
            boolean check = true;
              
            while(db_data.next()){
                out.print(db_data.getString("profilesID")+"<br>");
                out.print(db_data.getString("name")+"<br>");
                out.print(db_data.getString("tell")+"<br>");
                out.print(db_data.getString("age")+"<br>");
                out.print(db_data.getString("birthday")+"<br>");
                check = false;
            }
            
          
            if(check){
                out.print("該当するデータはありませんでした。");
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