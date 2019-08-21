<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>

    <title><fmt:message key="seats.page.title"/> </title>
    <style>

        .poster-picture{
            width: 100px;
            height: 148px;
            border: 1px solid black;
        }
        #whole-container {
            text-align: center;
            position: absolute;
            top: 37%;
            left: 50%;
            transform: translate(-50%, -50%)
        }

        #film-info-container{
            display: flex;
            justify-content: center;
        }
        #film-info-table {
            text-align: center;
        }

        form {
            margin: 0;
        }

        .seat-button {
            width: 30px;
            height: 30px;
            background-color: #35ccff;
            /*border: 1px solid #0192ff;*/
            border: 0;
            border-radius: 4px;
            color: white;
            /*padding: 4px 8px;*/
            text-decoration: none;
            margin: 1px;
            cursor: pointer;
            font-size: 16px;

        }

        #busy-seat {
            background-color: grey;
        }

        #free-seat {

        }

        .vip-seat {
            background-color: #0192ff;
        }

    </style>
</head>

<body>
<jsp:include page="header.jsp"/>

<div id="whole-container">

    <div id="film-info-container">
        <table id="film-info-table">
            <tr>
                <td><img class="poster-picture" src="${pageContext.request.contextPath}/images/${seance.film.posterPic}" ></td>
            </tr>
            <tr>
                <td>${seance.film.name}</td>
            </tr>
            <tr>
                <td><fmt:formatDate type="both" timeStyle="short" value="${seance.start}"/></td>
            </tr>
        </table>
    </div>
    <table>
        <c:set var="guest_role" value="GUEST"/>
        <c:forEach var="row" items="${all_seats}">
            <tr>
                    <%--<td><fmt:message key="seats.row"/>${row[1].row}</td>--%>
                <c:forEach var="seat" items="${row}">
                    <td>
                        <c:choose>
                            <c:when test="${sessionScope.user.role == guest_role}">
                                <c:choose>
                                    <c:when test="${busy_seats.contains(seat)}">
                                        <button class="seat-button" id="busy-seat" disabled></button>
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${seat.seatTypeId == 1}">
                                            <button class="seat-button" id="free-seat">${seat.place}</button>
                                        </c:if>
                                        <c:if test="${seat.seatTypeId == 2}">
                                            <button class="seat-button vip-seat">${seat.place}</button>
                                        </c:if>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${busy_seats.contains(seat)}">
                                        <button class="seat-button" id="busy-seat" disabled></button>
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${seat.seatTypeId == 1}">
                                            <form method="POST"
                                                  action="${pageContext.request.contextPath}/purchase-ticket">
                                                <input type="hidden" name="seat-id" value="${seat.id}">
                                                <input type="hidden" name="seance-id" value="${seance.id}">
                                                <button class="seat-button">${seat.place}</button>
                                            </form>
                                        </c:if>

                                        <c:if test="${seat.seatTypeId == 2}">
                                            <form method="POST"
                                                  action="${pageContext.request.contextPath}/purchase-ticket">
                                                <input type="hidden" name="seat-id" value="${seat.id}">
                                                <input type="hidden" name="seance-id" value="${seance.id}">
                                                <button class="seat-button vip-seat">${seat.place}</button>
                                            </form>
                                        </c:if>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>