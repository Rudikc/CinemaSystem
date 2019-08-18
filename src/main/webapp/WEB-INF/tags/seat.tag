<%@ tag description="Tag for seat view" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="seanceId" required="true" %>
<%@ attribute name="seatTypeId" required="true" %>
<%@ attribute name="seatPlace" required="true" %>
<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<c:if test="${seatTypeId == 1}">
    <form id="seat-button" method="POST"
          action="${pageContext.request.contextPath}/purchase-ticket">
        <input type="hidden" name="seat-id" value="${seatTypeId}">
        <input type="hidden" name="seance-id" value="${seanceId}">
        <button>${seatPlace}</button>
    </form>
</c:if>

<c:if test="${seatTypeId == 2}">
    <form id="vip-seat" method="POST"
          action="${pageContext.request.contextPath}/purchase-ticket">
        <input type="hidden" name="seat-id" value="${seatPlace}">
        <input type="hidden" name="seance-id" value="${seanceId}">
        <button>${seatPlace}</button>
    </form>
</c:if>