<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 8/22/18
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Albums</title>
</head>
<body>

    <h1>Albums!</h1>
    <c:forEach items="${albums}" var="album">
        <div>
            <h3>${album.name}</h3>
            <p>By ${album.artist}</p>
            <p>Released in ${album.releaseDate}</p>
            <p>${album.sales}  million copies sold</p>
            <p>In the ${album.genre} genre</p>
        </div>
    </c:forEach>

</body>
</html>
