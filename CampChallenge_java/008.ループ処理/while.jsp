<%
    int num = 1000;
    while(num % 2 == 0){//1000が2で割り切れるとき
         num /= 2;
        if(num <= 100){
           
        }
        out.print(num+"<br>");//確認用
    }
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
