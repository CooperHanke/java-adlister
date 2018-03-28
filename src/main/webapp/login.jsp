<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 3/27/18
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="WEB-INF/partials/head.jsp" %>
    <jsp:include page="WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Login Page" />
    </jsp:include>
</head>
<body>
    <%@ include file="WEB-INF/partials/navbar.jsp" %>
    <div class = "container">
    <div class="wrapper">
        <form action="#" method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
            <hr class="colorgraph"><br>

            <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>

            <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Login</button>
        </form>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {
                if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
                    response.sendRedirect("profile.jsp");
                } else {
                    response.getWriter().println("<h1>cannot login to admin<h1>");
                }
            }
        %>
    </div>
</div>
</body>
</html>
