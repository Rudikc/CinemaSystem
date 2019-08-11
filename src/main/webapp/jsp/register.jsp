<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>
<html>
<head>
    <title><fmt:message key="login.registration"/></title>
</head>
<body>
<div class="form">
    <h2>Register</h2><br>
    <form method="post" action="${pageContext.request.contextPath}/register">
        <input type="text" required placeholder="email" name="email"><br>
        <input type="password" required placeholder="password" name="password"><br>
        <input type="text" required placeholder="first name" name="first_name"><br>
        <input type="text" required placeholder="last name" name="last_name"><br>
        <input type="text" required placeholder="phone number" name="phone"><br>
        <input class="button" type="submit" value="Enter">
    </form>
    <c:if test="${not empty registrationMessage}">
        <fmt:message key="${registrationMessage}"/>
    </c:if><br>
</div>
</body>
</html>