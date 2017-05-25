<%
    long num = 8;
      //確認用計算
      out.print("8^1" +"=" + num+"<br>");
      for(int i = 2;i <= 20; i++){
        num *= 8;//階乗の計算
        //確認用計算
        out.print("8^"+ i +"="+num+"<br>");//改行はhtml形式で行える
    }
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
