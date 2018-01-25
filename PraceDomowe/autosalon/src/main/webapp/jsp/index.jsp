<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Strona z samochodami</title>
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

<form action="/cars/list">
    <table border="1">
        <tr>
            <th>Nazwa atrybutu</th>
            <th>Wartość atrybutu</th>
        </tr>

        <tr>
            <td>Marka</td>
            <td><input name="brand" type="text" value=""/></td>
        </tr>
        <tr>
            <td>Model</td>
            <td><input name="model" type="text" value=""/></td>
        </tr>

        <tr>
            <td>Wiek od</td>
            <td><input name="agefrom" type="number" value=""/></td>
        </tr>

        <tr>
            <td>Wiek do</td>
            <td><input name="ageto" type="number" value=""/></td>
        </tr>

        <tr>
            <td>Vin</td>
            <td><input name="vin" type="text" value=""/></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Wyszukaj"/>
            </td>
        </tr>

    </table>
</form>


<a href="/cars/new"/>Dodaj nowy samochód</a>
<br>
<br>
<br>

<table border="1">
    <tr align="center">
        <th hidden>Id auta</th>
        <th>Marka</th>
        <th>Model</th>
        <th>Data produkcji</th>
        <th>Wiek <br> (w latach)</th>
        <th>Vin</th>
        <th>Edytuj dane auta</th>
        <th>Usuń auto</th>
    </tr>

    <c:forEach items="${allCars}" var="carDto">
        <tr align="center">
            <td hidden><c:out value="${carDto.id}"/></td>
            <td><c:out value="${carDto.brand}"/></td>
            <td><c:out value="${carDto.model}"/></td>
            <td><c:out value="${carDto.productionDate}"/></td>
            <td><c:out value="${carDto.productionDate.until(nowDate).years}"/></td>
            <td><c:out value="${carDto.vin}"/></td>

            <td><a href="<c:url value='/cars/edit/${carDto.id}'/>">Edytuj</a></td>
            <td><a href="<c:url value='/cars/delete/${carDto.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>