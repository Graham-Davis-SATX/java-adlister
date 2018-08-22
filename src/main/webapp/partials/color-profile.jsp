<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 8/21/18
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test='${sessionScope.background != null && sessionScope.fontColor != null}'>
    <style>
        * {
            background: ${sessionScope.background} !important;
            color: ${sessionScope.fontColor} !important;
        }
    </style>
</c:if>
