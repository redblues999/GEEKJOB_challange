<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
        <form action="login_serv" method="post">
            UserID
            <p><input type ="test" name="userID"></p>
            
            Password
            <p><input type="password" name="password"></p>
            
            <p><input type="submit" value="ログイン"></p>
        </form>
        
    </body>
</html>