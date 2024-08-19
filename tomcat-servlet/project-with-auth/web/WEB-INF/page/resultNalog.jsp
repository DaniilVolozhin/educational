<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>nalog</title>
</head>
<body>
<p>Рассчет</p>
Сумма уплаченных налогов составит
<hr>
${requestScope.get("resultSum")}

<form action="/nalog" method="GET">
    Рассчитать повторно:
    <input type="submit" value="Sign in">
</form>

</body>
</html>