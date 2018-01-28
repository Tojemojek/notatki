<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Moja dynamiczna stronka</title>
</head>
<body>

<jsp:include page="../menu.jsp"/>


<h2>Register User</h2>


<c:if test="${not empty errorMessage}">
    <div><c:out value="${errorMessage}"/></div>
</c:if>
<br>

<form:form method="POST" modelAttribute="customerModel" action="/customers/register">
    <table border="1">
        <tr>
            <th>Nazwa atrybutu</th>
            <th>Wartość atrybutu</th>
        </tr>
        <tr>
            <td>Imię</td>
            <td><form:input path="firstName" id="firstName"></form:input></td>
            <td><form:errors path="firstName" id="firstName"></form:errors></td>
        </tr>
        <tr>
            <td>Nazwisko</td>
            <td><form:input path="surname" id="surname"></form:input></td>
            <td><form:errors path="surname" id="surname"></form:errors></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email" id="email"></form:input></td>
            <td><form:errors path="email" id="email"></form:errors></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><form:input path="login" id="login"></form:input></td>
            <td><form:errors path="login" id="login"></form:errors></td>
        </tr>
        <tr>
            <td>Hasło</td>
            <td><form:password path="password" id="password"></form:password></td>
            <td><form:errors path="password" id="password"></form:errors></td>
        </tr>

        <tr>
            <td>
                <c:choose>
                    <c:when test="${edit}">
                        Edytuj użytkownika
                    </c:when>
                    <c:otherwise>
                        Dodaj nowego użytkownika
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <input type="submit" value="Zarejestruj użytkownika"/>
            <td>
        </tr>


        <form:hidden path="id" id="id"></form:hidden>

    </table>

</form:form>


</body>
</html>