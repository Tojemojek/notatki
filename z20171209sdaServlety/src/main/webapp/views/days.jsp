<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--to wymusza włączenie expression language --%>
<%--czasami to jest potrzebne - czasami nie - zależy od konfiguracji --%>
<%--<%@ page isELIgnored="false" %>--%>

<html>

<body>
<h2>To jest przykład jak się robi MVC w JSP</h2>
<br>


<form id="daysInput" method="GET" action="">
    <input type="number" name="days" value="<c:out value="${howManyDaysWereGiven}"></c:out>">
    <%--<input type="number" name="days" value="${param.days}">--%>

    <input type="submit" value="Wrzuć dane!">
</form>

<%--http://127.0.0.1:8081/?days=8--%>

<c:choose>
    <c:when test="${howManyDaysWereGiven == null}">
        Lista jest pusta
    </c:when>

    <c:otherwise>
        <p> W zapytaniu poproszono o podanie <c:out value="${howManyDaysWereGiven}"></c:out> dni </p>
        <br>
        <table border="1">
            <tr>
                <td>No of days</td>
                <td>Date after</td>
            </tr>
            <c:forEach items="${mojAtrybutListyDTO}" var="day">
                <tr>
                    <td><c:out value="${day.daysAfter}"/></td>
                    <td><c:out value="${day.dateAfter}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>


</body>
</html>
