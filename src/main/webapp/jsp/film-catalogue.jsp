<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<head>

</head>

<body>
<input type="file">

<c:forEach var="film" items="${films}">
    <h1>${film.name}</h1>
</c:forEach>
<c:forEach var="page" items="${pages}">
    <a href="${pageContext.request.contextPath}/film-catalogue?page=${page}">${page}</a>
</c:forEach>
</body>