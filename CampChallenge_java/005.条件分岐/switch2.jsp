<%
    char str = 'A';
    switch(str){
        //値が「A」なら「英語」を表示
        case 'A':
        out.print("英語");
        break;
        
        //値が「あ」なら「日本語」を表示
        case 'あ':
        out.print("日本語");
        break;
        
        //それ以外はなにもしない
        default:
        //何も表示しない
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
