<% 
final int Base = 20;//final int: intで指定した値を変更できないようにする
                    //指定できるのは1回のみ
int num = 10;
  
//足し算
int wa = Base + num;
out.print(Base +"+"+num+"=" + wa + " ");

//引き算
int sa = Base - num;
out.print(Base +"-"+num+"=" + sa + " ");

//掛け算
int seki = Base * num;
out.print(Base +"×"+ num + "=" + seki + " ");

//割り算
int show = Base / num;
out.print(Base +"÷"+num+"=" + show + " ");

//余剰(余りの計算)
int amari = Base % num;
out.print(Base +"を"+num+"で割ったときの余りは" + amari);
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
