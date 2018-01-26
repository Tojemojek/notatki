<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Strona do edycji produktów</title>
    </head>
</head>
<body>

<c:choose>
    <c:when test="${edit}">
        <h2>Edytuj produkt</h2>
    </c:when>
    <c:otherwise>
        <h2>Dodaj nowy produkt</h2>
    </c:otherwise>
</c:choose>


<c:if test="${not empty errorMessage}">
    <div><c:out value="${errorMessage}"/></div>
</c:if>
<br>

<form:form method="POST" modelAttribute="singleProduct" action="/products-web/save">
    <table border="1">
        <tr>
            <th>Nazwa atrybutu</th>
            <th>Wartość atrybutu</th>
        </tr>

        <tr>

            <td>Nazwa</td>
            <td><form:input path="name" id="name"></form:input></td>
            <td><form:errors path="name" id="name"></form:errors></td>
        </tr>
        <tr>
            <td>Typ produktu</td>
            <td>
                <form:select path="productType" id="productType" items="${productTypes}">
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Ilość w bazie</td>
            <td><form:input path="quantity" id="quantity"></form:input></td>
            <c:if test=""
            <td><form:errors path="quantity" id="quantity"></form:errors></td>
        </tr>
        <tr>
            <td></td>

            <td>
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update product"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Add product"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <form:hidden path="id" id="id"></form:hidden>
    </table>

</form:form>


<a href="/products-web/new"/>Dodaj nowy product</a>

</body>
</html>