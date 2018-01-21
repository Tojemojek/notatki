<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Strona z produktami</title>
</head>
<body>


<form action="/products-web/list">
    <table border="1">
        <tr>
            <th>Nazwa atrybutu</th>
            <th>Wartość atrybutu</th>
        </tr>

        <tr>
            <td>Nazwa</td>
            <td><input name="productName" type="text" value=""/></td>
        </tr>
        <tr>
            <td>Typ produktu</td>
            <td>
                <select name="productType">
                    <option value=""
                            <c:if test="${'' eq selectedProductType}"> selected </c:if>>Wszystko
                    </option>
                    <c:forEach items="${productTypes}" var="categories">
                        <option value="${categories.key}"
                                <c:if test="${categories.key eq selectedProductType}"> selected </c:if>>
                                ${categories.value}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Wyszukaj produkty"/>
            </td>
        </tr>

    </table>

</form>

<table border="1">
    <tr>
        <th>Id produktu</th>
        <th>Nazwa produktu</th>
        <th>Typ productu</th>
        <th>Ilość</th>
        <th>Edytuj</th>
        <th>Usuń produkt</th>
    </tr>

    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.productType}"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><a href="<c:url value='/products-web/edit/${product.id}'/>">Edytuj</a></td>
            <td><a href="<c:url value='/products-web/delete/${product.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/products-web/new"/>Dodaj nowy product</a>

</body>
</html>