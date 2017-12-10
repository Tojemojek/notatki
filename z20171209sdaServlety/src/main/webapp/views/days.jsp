<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--to wymusza włączenie expression language --%>
<%--czasami to jest potrzebne - czasami nie - zależy od konfiguracji --%>
<%--<%@ page isELIgnored="false" %>--%>

<html>

<body>
<h2>To jest przykład jak się robi MVC w JSP</h2>
<br>

<%--http://127.0.0.1:8081/?days=8--%>

<p> W zapytaniu poproszono o podanie <c:out value="${howManyDaysWereGiven}"></c:out> dni </p>

<br>

<c:forEach items="${mojAtrybutListyDTO}" var="day">

    Date after: <c:out value="${day.daysAfter}"/> days: <c:out value="${day.dateAfter}"/> <br>

</c:forEach>

</body>
</html>
