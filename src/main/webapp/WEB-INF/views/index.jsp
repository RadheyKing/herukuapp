<%-- 
    Document   : index
    Created on : Jun 15, 2018, 11:43:19 AM
    Author     : NiranjanKrSubedi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! ${user}</h1>
        <c:forEach var="d" items="${department}">
        <ul>
            <li>
                ${d.name}
            </li>
        </ul>
        </c:forEach>
    </body>
</html>
