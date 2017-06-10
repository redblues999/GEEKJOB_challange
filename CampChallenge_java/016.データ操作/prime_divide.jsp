<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./prime_divide.jsp" method ="get"><!-- クエリストリングの作成 -->
        素因数分解用の数字
            <input type ="test" name ="prime"><br><br>

            <input type="submit" value="更新"><br><!--　クエリを保持したままページを更新 -->
            
        </form>
            
    </body>
</html>
<%
String str1 = request.getParameter("prime");
if(str1 != null){
    int prime = Integer.parseInt(str1);
    out.print("元の数字："+prime+"<br><br>");
    
    //2で割った余りが0のとき
    //2で割り続けて、結果を表示
    while(prime % 2 == 0){
        prime = prime/2;
    out.print("2<br>");
    }
    
    while(prime % 3 == 0){
        prime = prime/3;
    out.print("3<br>");
    }
    
    while(prime % 5 == 0){
        prime = prime/5;
    out.print("5<br>");
    }
    
    while(prime % 7 == 0){
        prime = prime/7;
    out.print("7<br>");
    }
    if(prime >= 10){
    out.print("余った値："+prime);
}
}

%>