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
            <td><fmt:message key="seats.row"/>${row[1].row}</td>
            <c:forEach var="seat" items="${row}">
                <td>
                    <c:choose>
                        <c:when test="${busy_seats.contains(seat)}">${seat.place}</c:when>
                        <c:otherwise><a href=""> ${seat.place}</a></c:otherwise>
                    </c:choose>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>