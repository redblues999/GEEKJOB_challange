<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="./session2.jsp" method ="get"><!-- クエリストリングの作成 -->
            名前
            <input type ="test" name ="name"><br><br>
            性別
            <input type ="test" name ="gender"><br><br>
            趣味
            <input type ="test" name ="hobby"><br><br>

            <input type="submit" value="更新"><br><!--　クエリを保持したままページを更新 -->
            
        </form>
        
    </body>
</html>

<%
// 受け取るパラメータの文字コード
request.setCharacterEncoding("UTF-8");

String str1 = request.getParameter("name");
String str2 = request.getParameter("gender");
String str3 = request.getParameter("hobby");

//セッションの作成
HttpSession hs = request.getSession();

Object d1 = hs.getAttribute("obj1");
Object d2 = hs.getAttribute("obj2");
Object d3 = hs.getAttribute("obj3");

out.print(d1);
out.print(d2);
out.print(d3);

hs.setAttribute("obj1", str1);
hs.setAttribute("obj2", str2);
hs.setAttribute("obj3", str3);

%>