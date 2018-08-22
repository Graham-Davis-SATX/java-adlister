<%--
  Created by IntelliJ IDEA.
  User: fer
  Date: 8/21/18
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create a new Employee</title>
</head>
<body>

<form action="/employees/create" method="post">
    <label for="">First Name</label>
    <input type="text" name="fn">
    <label for="">Last Name</label>
    <input type="text" name="ln">
    <label for="">Gender</label>
    <input type="text" name="gender">
    <label for="">Hire Date</label>
    <input type="date" name="hd">
    <label for="">Birth Date</label>
    <input type="date" name="bd">
    <button>Submit</button>
</form>

</body>
</html>
