<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<head>

</head>

<body>
<form method="POST" action="${pageContext.request.contextPath}/add-film">
    <input type="file" name="poster-pic">
    <input type="text" name="film-name">
    <input type="text" name="director">
    <input type="date" name="premiere-date">
    <input type="time" name="duration" >
    <input type="submit">
</form>


<c:forEach var="film" items="${films}">
    <h1>${film.name}</h1>
</c:forEach>
<c:forEach var="page" items="${pages}">
    <a href="${pageContext.request.contextPath}/film-catalogue?page=${page}">${page}</a>
</c:forEach>
</body>