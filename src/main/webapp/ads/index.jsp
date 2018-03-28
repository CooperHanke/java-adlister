<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 3/28/18
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page=".././partials/head.jsp" />
    <title>Ads</title>
</head>
<body>
    <jsp:include page=".././partials/navbar.jsp" />
    <div class="container">
        <h1>Ads Page</h1>
        <c:forEach var="ad" items="${ads}">
            <h1>${ad.title}</h1>
            <p>${ad.description}</p>
        </c:forEach>
    </div>
</body>
</html>
