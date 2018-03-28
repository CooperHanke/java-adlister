<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 3/28/18
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="ColorPicker" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
<div class="container">
    <form action="#" method="POST">
        <div class="form-group">
            <label for="color">What is your favorite color?</label>
            <input id="color" name="color" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="submit">
    </form>
</div>
</body>
</html>
