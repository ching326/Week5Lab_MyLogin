<%-- 
    Document   : home
    Created on : 9-Oct-2022, 11:06:11 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h2>Welcome, ${user.username}</h2>
        <a href="login?logout">Log out</a>
    </body>
</html>
