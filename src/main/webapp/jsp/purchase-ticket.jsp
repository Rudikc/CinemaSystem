<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <fmt:message key="ticket.purchase.confirm"/>
    <table>
        <tr>
            <td>
                <h2><fmt:message key="seats.row"/></h2>
            </td>
            <td>
                ${seat.row}
            </td>
        </tr>
        <tr>
            <td>
                <h2><fmt:message key="seats.place"/></h2>
            </td>
            <td>
                ${seat.place}
            </td>
        </tr>
        <tr>
            <td>
                <h2><fmt:message key="film.name"/></h2>
            </td>
            <td>
                ${seance.film.name}
            </td>
        </tr>
        <tr>
            <td>
                <h2><fmt:message key="seance.time"/></h2>
            </td>
            <td>
                ${seance.start}
            </td>
        </tr>
        <tr>
            <td>
                <h2><fmt:message key="ticket.purchase.price"/></h2>
            </td>
            <td>
                ${ticket_price}
            </td>
        </tr>
    </table>
</div>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/seats">
        <input type="hidden" name="seance-id" value="${seance.id}">
        <button><fmt:message key="button.back"/></button>
    </form>
    <form method="POST" action="${pageContext.request.contextPath}/purchase-confirm">
        <input type="hidden" name="seance-id" value="${seance.id}">
        <input type="hidden" name="seat-id" value="${seat.id}">
        <input type="hidden" name="ticket-price" value="${ticket_price}">
        <button><fmt:message key="button.confirm"/></button>
    </form>
</div>
</body>
</html>
