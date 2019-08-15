<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>
    <title></title>
    <style>
        #seat-button {


        }
    </style>
</head>
<body>
<table>
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/${seance.film.posterPic}" width="100"
                 height="148"></td>
        <td>${seance.film.name}</td>
        <td>${seance.start}</td>
    </tr>
</table>
<table>
    <c:set var="guest_role" value="GUEST"/>
    <c:forEach var="row" items="${all_seats}">
        <tr>
            <td><fmt:message key="seats.row"/>${row[1].row}</td>
            <c:forEach var="seat" items="${row}">
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.user.role == guest_role}">
                            <c:choose>
                                <c:when test="${busy_seats.contains(seat)}">
                                    <button disabled>${seat.place}</button>
                                </c:when>
                                <c:otherwise>
                                        <button>${seat.place}</button>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${busy_seats.contains(seat)}">
                                    <button disabled>${seat.place}</button>
                                </c:when>
                                <c:otherwise>
                                    <form id="seat-button" method="POST"
                                          action="${pageContext.request.contextPath}/purchase-ticket">
                                        <input type="hidden" name="seat-id" value="${seat.id}">
                                        <input type="hidden" name="seance-id" value="${seance.id}">
                                        <button>${seat.place}</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>