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
    <title>Single employee info</title>
</head>
<body>

<h1>Welcome, ${emp.firstName} ${emp.lastName}</h1>

<p><b>${emp.birthDate}</b> is getting closer</p>

<p><b>Hire date: ${emp.hireDate}</b></p>

<p>You id number is ${emp.empNo}</p>

</body>
</html>
