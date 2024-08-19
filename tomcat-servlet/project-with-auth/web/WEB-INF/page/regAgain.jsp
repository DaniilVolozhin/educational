<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>sign</title>
</head>
<body>
<p>Добро пожаловать на сайт рассчета налогов с заработной платы</p>

<form action="/sign" method="GET">
    ${requestScope.get("message")}
    <hr>
    Укажите: вход-signin or регистрация-signup <input type="text" name="reg"/>
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="pass"/>
    <input type="submit" value="Sign in">
</form>
</body>
</html>