<% 
int a = 3;
switch(a){
    
    //値が1なら「one」を表示
    case 1:
    out.print("one");
    break;
    
    //値が2なら「two」を表示
    case 2:
    out.print("two");
    break;
    
    //それ以外なら「想定外」を表示
    default://default:caseで指定された以外の時すべて(if文のelseと同様)
    out.print("想定外");
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Switch Page</title>
    </head>
    <body>
    </body>
</html>
