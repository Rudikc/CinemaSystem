<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <c:forEach var="row" items="${all_seats}">
        <tr>
            <c:forEach var="seat" items="${row}">
                <td>Seat
                    <c:choose>
                        <c:when test="${busy_seats.contains(seat)}">true</c:when>
                        <c:otherwise>false</c:otherwise>
                    </c:choose>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>