<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logowanie</title>
</head>
<body>

<jsp:include page="../menu.jsp"/>

<body>

<form action="/customers/login" method="post">
    <table>
        <tr>
            <td>
                Login
            </td>
            <td>
                <input type="text" name="customerLogin"/>
            </td>
        </tr>
        <td>
            Password
        </td>
        <td>
            <input type="password" name="customerPassword"/>
        </td>

        <td>

        </td>
        <td>
            <input type="submit" value="Zaloguj się"/>
        </td>
    </table>
</form>
</body>


</body>
</html>