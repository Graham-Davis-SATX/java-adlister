<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 8/21/18
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color Profile Form</title>
</head>
<body>

    <h1>Color Profile Form</h1>
    <form action="/color-profile" method="POST">
        <div>
            <label for="background">Preferred Background Color</label>
            <input id="background" type="color" name="background" value="">
        </div>
        <div>
            <label for="font-color">Preferred Font Color</label>
            <input id="font-color" type="color" name="font-color" value="">
        </div>
        <button>Submit</button>
    </form>

    <form action="/color-profile" method="POST">
        <input type="hidden" name="forget">
        <button>Forget Color Preferences</button>
    </form>

</body>
</html>
