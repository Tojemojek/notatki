<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <head>
        <title>Strona do edycji produktów</title>
    </head>
</head>
<body>

<table border="1">
    <tr>
        <th>Id produktu</th>
        <th>Nazwa produktu</th>
        <th>Typ productu</th>
        <th>Ilość</th>
    </tr>

    <tr>
        <td><c:out value="${singleProduct.id}"/></td>
        <td><c:out value="${singleProduct.name}"/></td>
        <td><c:out value="${singleProduct.productType}"/></td>
        <td><c:out value="${singleProduct.quantity}"/></td>

    </tr>

</table>
</body>
</html>