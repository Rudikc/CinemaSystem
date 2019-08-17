<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>

    <style>
        #poster-pic {
            width: 100px;
            height: 148px;
        }
    </style>

</head>
<body>
<table>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                    ${order.id}
            </td>
            <td>
                    <fmt:formatDate type="both" value="${order.orderTime}"/>
            </td>
            <td>
                <c:forEach var="ticket" items="${order.tickets}">
                    <span><fmt:message key="seats.row"/> ${ticket.seat.row}</span>
                    <span><fmt:message key="seats.place"/> ${ticket.seat.place}</span>
                </c:forEach>
            </td>
            <td>
                <img id="poster-pic"
                     src="${pageContext.request.contextPath}/images/${order.tickets[0].seance.film.posterPic}"/>
            </td>
            <td>
                <span><fmt:message key="ticket.purchase.price"/> ${order.price}</span>
            </td>
            <td>

                <form method="POST" action="${pageContext.request.contextPath}/remove-order">
                    <input type="hidden" name="order-id" value="${order.id}">
                    <button><fmt:message key="order.remove"/></button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
