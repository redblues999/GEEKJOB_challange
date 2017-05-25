<%@ page import="java.util.HashMap" %>
<%
//連想配列の作成
HashMap<String, String> str = 
        new HashMap<String, String>();

//要素の追加
str.put("1", "AAA");
str.put("hello", "world");
str.put("soeda", "33");
str.put("20", "20");

//要素の取得(出力確認用)
out.print(str.get("1")+" ");
out.print(str.get("hello")+" ");
out.print(str.get("soeda")+" ");
out.print(str.get("20")+" ");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
