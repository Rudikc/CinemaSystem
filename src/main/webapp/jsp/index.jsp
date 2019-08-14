<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<body>
<h1><fmt:message key="index.greetings"/> </h1>
<myTag:language-change-panel/>
<h2><a href="${pageContext.request.contextPath}/login">Sign in</a></h2>
<h2><a href="${pageContext.request.contextPath}/seances">See titles</a></h2>
<h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=ru_RU"><fmt:message key="language.russian"/> </a></h4>
<h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=uk_UA"><fmt:message key="language.ukrainian"/> </a></h4>
<h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=en_US"><fmt:message key="language.english"/> </a></h4>
</body>
</html>
