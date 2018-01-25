<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Wyedytuj sobie autko</title>
    <style>

        th {
            background-color: orange;
        }

        td {
            background-color: lightblue;
        }
    </style>
</head>
<body>

<jsp:include page="menu.jsp"/>

<a href="/cars/new"/>Dodaj nowy samochód</a>

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
            <td><form:errors path="brand" id="brand"></form:errors></td>
        </tr>
        <tr>
            <td>Model</td>
            <td><form:input path="model" id="model"></form:input></td>
            <td><form:errors path="model" id="model"></form:errors></td>
        </tr>
        <tr>
            <td>Data produkcji</td>
            <td><input type="text" name="productionDate" value="<c:out value="${editedCar.productionDate}"/>"/></td>
                <%--<td><form:input path="productionDate" id="productionDate"></form:input></td>--%>
            <td><form:errors path="productionDate" id="productionDate"></form:errors></td>
        </tr>
        <tr>
            <td>Vin</td>
            <td><form:input path="vin" id="vin"></form:input></td>
            <td><form:errors path="vin" id="vin"></form:errors></td>
        </tr>
        <tr>
            <td>Chcesz zapisać?</td>
            <td><input type="submit" value="Zapisz"/></td>
        </tr>
    </table>

</form:form>

</body>
</html>