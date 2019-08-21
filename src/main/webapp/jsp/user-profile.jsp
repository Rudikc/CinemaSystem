<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>

    <title>
        <fmt:message key="user-profile.title"/>
    </title>
    <style>
        #poster-pic {
            width: 100px;
            height: 148px;
        }

        .tickets{
            margin-top: 20px;
        }
        .tickets tr:first-child {
            font-weight: bold;
            text-transform: uppercase;
            white-space: nowrap;
            text-align: left;
            background-color: #35ccff;
            color: #fff;
            font-size: 12px;
        }
        .tickets tr {
            color: black;
            font-size: 13px;
        }
        .tickets tr:first-child td{
            border-right: none;
            border-left: 1px solid white;
        }
        .tickets-info{
            display: flex;
            justify-content: center;
            width: 100%;
            margin: 0 auto;
            max-width: 80%;
        }
        table {
            border-collapse: collapse;
            border-spacing: 0;
        }
        td{
            padding: 20px 20px;
            border: 1px solid #35ccff;
            vertical-align: middle;
            line-height: 1.154;
        }
        #film-name{
            width: 170px;
            display: inline-block;
            vertical-align: middle;
            font-size: 16px;
            font-weight: bold;
            line-height: 1.154;
        }

        #ticket-movie{
        }

    </style>

</head>
<body>
<jsp:include page="header.jsp"/>
<section class="tickets">
    <div class="tickets-info">
        <table>
            <tr>
                <td><fmt:message key="order.id"/> </td>
                <td><fmt:message key="order.date"/> </td>
                <td><fmt:message key="seats.uppercase.place"/> </td>
                <td><fmt:message key="poster.picture"/> </td>
                <td><fmt:message key="film.name"/></td>
                <td><fmt:message key="ticket.purchase.price"/> </td>
                <td></td>
            </tr>
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
                    <td id="ticket-movie">
                        <img id="poster-pic"
                             src="${pageContext.request.contextPath}/images/${order.tickets[0].seance.film.posterPic}"/>
                    </td>
                    <td>
                        <span id="film-name">${order.tickets[0].seance.film.name}</span>

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
    </div>
</section>

</body>
</html>
