<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<body>
<h2>Formatka Logowania</h2>

<p>
    <c:choose>
        <c:when test="${error eq 'INCORRECT_CREDENTIALS'}">
            <span style="color: red">Niepoprawny user / hasło</span>
        </c:when>
        <c:otherwise>Witaj, zaloguj się!</c:otherwise>
    </c:choose>
</p>

<br>

<form id="logowanie" method="post">
    <table>
        <tr>
            <td>User</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="userPassword"></td>
        </tr>
    </table>
    <input type="submit" value="Loguj!">
</form>

<%--&nbsp - spacja--%>
<%--&lt; &gt; nawiasy do escape html tag--%>

</body>
</html>
