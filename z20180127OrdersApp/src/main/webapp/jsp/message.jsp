<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Wiadomości dla użytkowników</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<c:if test="${not empty userMessage}">
    <div>${userMessage}</div>
</c:if>
</body>
</html>