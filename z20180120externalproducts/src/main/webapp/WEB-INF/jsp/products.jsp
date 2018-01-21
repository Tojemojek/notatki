<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Strona z produktami</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Id produktu</th>
        <th>Nazwa produktu</th>
        <th>Typ productu</th>
        <th>Ilość</th>
    </tr>

    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.productType}"/></td>
            <td><c:out value="${product.quantity}"/></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>