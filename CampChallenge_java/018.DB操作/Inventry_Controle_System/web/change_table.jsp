<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body>
        <form action="list" method="post">
            <p><input type="submit" value="商品一覧"></p>
        </form>
        
        <form action="./register.jsp" method="post">
            <p><input type="submit" value="商品登録"></p>
        </form>
        
        <form action="logout" method="post">
            <p><input type="submit" value="ログアウト"></p>
        </form>
        
    </body>
</html>