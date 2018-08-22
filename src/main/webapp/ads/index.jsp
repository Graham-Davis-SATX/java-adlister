<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fer
  Date: 8/22/18
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of ads</title>
</head>
<body>

<c:forEach var="ad"  items="${ads}">
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
    <span>${ad.userId}</span>
</c:forEach>

</body>
</html>
