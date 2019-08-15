<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

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
    </c:if><br>
    <a href="${pageContext.request.contextPath}/register"><fmt:message key="login.registration"/></a>
</div>
</body>
</html>