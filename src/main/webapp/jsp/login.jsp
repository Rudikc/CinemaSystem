<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>
<html>
<head>
    <title></title>
</head>
<body>
<div class="form">
    <h1>Вхід у систему</h1><br>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="text" required placeholder="email" name="email"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Увійти">
    </form>
    <c:if test="${not empty loginMessage}">
            <fmt:message key="${loginMessage}"/>
    </c:if>
</div>
</body>
</html>