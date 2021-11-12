<%--
  Created by IntelliJ IDEA.
  User: RKotelevits
  Date: 10.11.2021
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>

<body>
<div>
    <h1>Simple purchases app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Products</h2>
        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("productNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no products yet!</p>");

        %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
