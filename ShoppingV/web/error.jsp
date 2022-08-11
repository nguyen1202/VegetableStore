<%-- 
    Document   : error
    Created on : Feb 16, 2022, 8:11:30 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>ERROR: <%= session.getAttribute("ERROR_MESSAGE") %></h1>
    </body>
</html>
