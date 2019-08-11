<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<body>
<h1><fmt:message key="index.greetings"/> </h1>
<h2><a href="${pageContext.request.contextPath}/login">Sign in</a></h2>
<h2><a href="${pageContext.request.contextPath}/seances">See titles</a></h2>
<h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=ru_RU">Русский</a></h4>
<h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=uk_UA">Українська</a></h4>
<h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=en_US">English</a></h4>
</body>
</html>
