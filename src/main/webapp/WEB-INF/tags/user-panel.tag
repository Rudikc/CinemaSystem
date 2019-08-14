<%@ tag description="Language change panel tag" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<c:set var="user" value="USER"/>
<c:set var="admin" value="ADMIN"/>
<c:set var="guest" value="GUEST"/>

<c:if test="${sessionScope.user.role == user || sessionScope.user.role == admin}">
<div>
    <table>
        <tr>
            <td>
                <h2><a href="${pageContext.request.contextPath}/logout"><fmt:message key="user.action.logout"/></a></h2>
            </td>
            <td>
                <h2><a href="${pageContext.request.contextPath}/user-profile"><fmt:message key="user.action.profile"/></a></h2>
            </td>
        </tr>
    </table>
</div>
</c:if>
<c:if test="${sessionScope.user.role == guest}">
    <div>
        <h2>
            <a href="${pageContext.request.contextPath}/login"><fmt:message key="user.action.login"/> </a>
        </h2>
    </div>
</c:if>
