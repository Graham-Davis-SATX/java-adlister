<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 8/19/18
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    // Setting request attribute (this would normally be done in a servlet)
    request.setAttribute("userRole", "admin");

    String message;
    switch (request.getAttribute("userRole").toString()) {
        case "admin":
            message = "administrator";
            break;
        case "s_admin":
            message = "super administrator";
            break;
        case "user_1":
            message = "active user";
            break;
        default:
            message = "unknown status";
    }


    request.setAttribute("userRoleMessage", message);

%>

<html>
<head>
    <title>JSPs: Expression Language</title>
</head>
<body>

    <h1>Your name is: ${param.name}</h1>

    <h3>User status: ${userRoleMessage}</h3>




</body>
</html>
