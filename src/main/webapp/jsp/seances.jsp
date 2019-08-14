<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<html>
<body>
<myTag:user-panel/>
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
                <td>${seance.start}</td>
                <td>${seance.film.name}</td>
                <c:set var="user_role" value="USER"/>
                <c:if test="${sessionScope.user.role == user_role}">
                    <td><a href="${pageContext.request.contextPath}/seats?seance_id=${seance.id}"><fmt:message
                            key="seances.purchase.tickets"/></a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
