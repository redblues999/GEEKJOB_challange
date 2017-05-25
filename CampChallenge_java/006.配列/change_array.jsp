<%@ page import = "java.util.ArrayList" %>
<%
//一つの配列で作る
ArrayList<String> data = new ArrayList<String>();
//「変数」としてではなく、「定数」として数字取り扱う
data.add("10");
data.add("100");
data.add("soeda");
data.add("hayashi");
data.add("-20");
data.add("118");
data.add("END");

//soedaを33に変更
data.set(2,"33");

//確認用出力
out.print(data.get(0)+"、");
out.print(data.get(1)+"、");
out.print(data.get(2)+"、");
out.print(data.get(3)+"、");
out.print(data.get(4)+"、");
out.print(data.get(5)+"、");
out.print(data.get(6)+"、");

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
