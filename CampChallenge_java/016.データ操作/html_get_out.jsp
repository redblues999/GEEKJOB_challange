<%
// 受け取るパラメータの文字コード
request.setCharacterEncoding("UTF-8");
// テキストボックスの情報を表示(以下三つ、初期値null)
//ページの更新ができるのはここだけ
out.print(request.getParameter("txtName")+"<br>");
// ラジオボタンの情報を表示(この場合は、はい/いいえ)
out.print(request.getParameter("rdoSample")+"<br>");
// テキストエリアの情報を表示
//テキストエリアは、改行をしても、横表示になる
out.print(request.getParameter("mulText"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>コントロールサンプル</title>
    </head>
    <body>
        <form action="./html_get_out.jsp" method ="post">
            <!-- テキストボックス、ラジオボタン、複数行テキストボックスの入力フィールドを作成 -->
            <h5>テキストボックス
            <input type ="test" name ="txtName"><br><br>
            ラジオボタン<!-- rdoSampleは、どちらか一方のみクリックすることができる -->
            <input type ="radio" name="rdoSample" value="はい">はい
            <input type="radio" name="rdoSample" value="いいえ">いいえ<br><br>
            テキストエリア(複数行テキストボックス)
            <textarea name ="mulText"></textarea></h5>
        </form>
    </body>
</html>
