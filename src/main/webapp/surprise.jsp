<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 3/28/18
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<param name="title" value="Surprise!">
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your ${title}" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <h1>Welcome to the party, ${name}!!</h1>
</body>
</html>
