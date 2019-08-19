<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<html>
<body>
<jsp:include page="header.jsp"/>
<c:set var="admin" value="ADMIN"/>
<c:if test="${sessionScope.user.role == admin}">
    <div>
        <form method="POST" action="${pageContext.request.contextPath}/add-seance">
            <label for="datetime"></label><input id="datetime" type="datetime-local" name="start"/>
            <label>
                <input list="films" name="film-id">
            </label>
            <datalist id="films">
                <c:forEach var="film" items="${allFilms}">
                    <option value="${film.id}">${film.name}
                </c:forEach>
            </datalist>
            <input type="text" name="ticket-price">
            <input type="submit"/>
        </form>
    </div>
</c:if>
<div>
    <table>
        <tr>
            <td>Img</td>
            <td>Seance id</td>
            <td>Session start</td>
            <td>Film name</td>
            <td></td>
        </tr>
        <c:forEach var="seance" items="${seances}">
            <tr>
                <td><img src="${pageContext.request.contextPath}/images/${seance.film.posterPic}" width="100"
                         height="148"></td>
                <td>${seance.id}</td>
                <td><fmt:formatDate type="time" timeStyle="short" value="${seance.start}"/></td>
                <td>${seance.film.name}</td>
                <td>
                    <form method="GET" action="${pageContext.request.contextPath}/seats">
                        <input type="hidden" name="seance-id" value="${seance.id}">
                        <button><fmt:message key="seances.see.free.tickets"/></button>
                    </form>
                    <c:if test="${sessionScope.user.role == admin}">
                        <form method="POST" action="${pageContext.request.contextPath}/remove-seance" >
                            <input type="hidden" name = "seance-id" value="${seance.id}">
                            <button><fmt:message key="button.remove"/> </button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>