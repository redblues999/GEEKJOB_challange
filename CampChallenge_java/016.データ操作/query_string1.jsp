<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./query_string1.jsp" method ="get"><!-- クエリストリングの作成 -->
            total
            <input type ="test" name ="total"><br><br>
            count
            <input type ="test" name ="count"><br><br>
            type
            <input type ="test" name ="type"><br><br>

            <input type="submit" value="更新"><br><!--　クエリを保持したままページを更新 -->
            
        </form>
    </body>
</html>

<%
//request.setCharacterEncoding("UTF-8");
String str1 = request.getParameter("total");

//nullチェック(これをしないと、エラーが起きる)
if (str1 != null){
    int value1 = Integer.parseInt(str1);
    out.print("合計金額は" + value1 + "です<br>");
    
    //値段に対応したポイントを作成
    double point;//初期値を設定
    //3000円以上で4%
    if(value1 >= 3000){
        point = value1 * 0.04;
        out.print(point+"のポイントを入手しました<br>");
    }
    //5000円以上で5%
    else if(value1 >=5000){
        point = value1 * 0.05;
        out.print(point+"のポイントを入手しました<br>");
    }
    
    String str2= request.getParameter("count");
    if(str2 != null){
        int value2 = Integer.parseInt(str2);
        //一つ当たりの値段を出す
        //※このソースコードの場合、if文の中にこれを書かないと、value1を定義していないと怒られる
        int pmw = value1/value2;
        out.print("一つ当たりの値段は"+pmw+"<br>");
    }
}

String str3 = request.getParameter("type");
if(str3 != null){
    int value3 = Integer.parseInt(str3);
    out.print("商品種別：");
    //商品種別によって、表示を変える  1:雑貨　2:生鮮食品　3:その他
    if(value3 == 1){
        out.print("雑貨");
    }
    else if(value3 == 2){
        out.print("生鮮食品");
    }
    else if(value3 == 3){
        out.print("その他");
    }
}
%>