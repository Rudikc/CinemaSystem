<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<html>
<body>
<jsp:include page="header.jsp"/>

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
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>