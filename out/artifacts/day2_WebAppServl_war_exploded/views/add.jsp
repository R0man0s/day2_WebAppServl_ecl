<%--
  Created by IntelliJ IDEA.
  User: RKotelevits
  Date: 10.11.2021
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
</head>

<body>
<div>
    <h1>Simple purchases app!</h1>
</div>

<div>
    <%
        if (request.getAttribute("productName") != null) {
            out.println("<p>Product '" + request.getAttribute("productName") + "' added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add product</h2>
        </div>

        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Price:
                <input type="number" name="price"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
