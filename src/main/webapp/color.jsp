<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 3/28/18
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="My favorite color is ${color}" />
    </jsp:include>
    <style>
        body {
            background-color: ${color};
        }
    </style>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <h1>This is the color: ${color}</h1>
</body>
</html>
