<%-- 
    Document   : error
    Created on : 30 Apr 2023, 1:00:58 pm
    Author     : LocalMachine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= session.getAttribute("error") %></h1>
        <%
            System.out.println(session.getAttribute("error"));
        %>
    </body>
</html>
