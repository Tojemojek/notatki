<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Wyedytuj sobie autko</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

<jsp:include page="menu.jsp"/>

<br><br>

<form:form method="POST" modelAttribute="editedCar" action="/cars/save/">
    <table border="1">
        <tr hidden>
            <td>Id auta</td>
            <td><form:input path="id" id="id"></form:input></td>
        </tr>
        <tr>
            <td>Marka</td>
            <td><form:input path="brand" id="brand"></form:input></td>
            <c:if test="${thereAreErrors}">
                <td><form:errors path="brand" id="brand"></form:errors></td>
            </c:if>
        </tr>
        <tr>
            <td>Model</td>
            <td><form:input path="model" id="model"></form:input></td>
            <c:if test="${thereAreErrors}">
                <td><form:errors path="model" id="model"></form:errors></td>
            </c:if>
        </tr>
        <tr>
            <td>Data produkcji</td>
            <td><form:input path="productionDate" id="productionDate"></form:input></td>
            <c:if test="${thereAreErrors}">
                <td><form:errors path="productionDate" id="productionDate"></form:errors></td
            </c:if>
        </tr>
        <tr>
            <td>Vin</td>
            <td><form:input path="vin" id="vin"></form:input></td>
            <c:if test="${thereAreErrors}">
                <td><form:errors path="vin" id="vin"></form:errors></td>
            </c:if>
        </tr>
        <tr>
            <td>Chcesz zapisać?</td>
            <td><input type="submit" value="Zapisz"/></td>
        </tr>
    </table>

</form:form>

</body>
</html>