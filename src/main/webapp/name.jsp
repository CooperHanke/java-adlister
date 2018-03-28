<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 3/28/18
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%--%>
    <%--if (request.getMethod().equalsIgnoreCase("post")) {--%>
        <%--String name = request.getParameter("name");--%>
        <%--response.sendRedirect("/surprise?name=" + name);--%>
    <%--}--%>
<%--%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="partials/head.jsp" %>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="name" method="POST">
            <div class="form-group">
                <label for="name">Enter your name:</label>
                <input id="name" name="name" class="form-control" type="text">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Submit">

        </form>
    </div>
</body>
</html>
