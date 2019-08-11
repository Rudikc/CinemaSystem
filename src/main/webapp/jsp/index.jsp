<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<body>
<h1><a href="${pageContext.request.contextPath}/login">Sign in</a></h1>
<h1><a href="${pageContext.request.contextPath}/seances">See titles</a></h1>
</body>
</html>
