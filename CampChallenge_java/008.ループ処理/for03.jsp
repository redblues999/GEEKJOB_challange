<%
    int sum = 0;//初期化
    for (int i =1;i<=100;i++){
        out.print(i+"+");//確認用
        sum += i;
    }
    out.print("<br>");
    out.print("="+sum);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>For Page</title>
    </head>
    <body>
    </body>
</html>
