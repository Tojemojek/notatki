<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<body>
<h2>Formatka Logowania</h2>
<p>Nie jesteś jeszcze zalogowany</p>
<br>

<form id="logowanie" method="post" action="">
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


</body>
</html>
