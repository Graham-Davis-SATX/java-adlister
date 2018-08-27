<%--
  Created by IntelliJ IDEA.
  User: gravis
  Date: 8/21/18
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

List of employees

<c:forEach var="emp" items="${peopleHired}">
    <div class="employees">
        <%--We use the real names of properties --%>
        <h2>${emp.empNo}</h2>
        <p>${emp.firstName}</p>
        <p>${emp.lastName}</p>
    </div>
</c:forEach>

</body>
</html>
