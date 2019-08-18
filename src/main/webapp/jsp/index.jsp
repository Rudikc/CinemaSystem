<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>
    <style>

        body {
            height: 100%;
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            position: relative;
        }

        #main-container {
            text-align: center;
        }

        #language-panel {
            display: flex;
            justify-content: center;
        }
    </style>

    <title><fmt:message key="title.index"/></title></head>
<body>
<jsp:include page="header.jsp"/>

<c:set var="guest" value="GUEST"/>
<div id="main-container">
    <h1><fmt:message key="index.greetings"/></h1>
    <div class="date-pick-container">
        <form method="GET" action="${pageContext.request.contextPath}/seances">
            <h2><fmt:message key="choose.date"/></h2>
            <label>
                <input type="date" name="given-date" value="${todayDate}" min="${todayDate}" max="${todayAfterSevenDays}">
            </label>
            <input type="submit">
        </form>
    </div>

    <c:if test="${sessionScope.user.role == guest}">
        <h2><a href="${pageContext.request.contextPath}/login"><fmt:message key="login.sign.in"/> </a></h2>
    </c:if>
    <div id="language-panel">
        <myTag:language-change-panel page="${pageContext.request.pathInfo}"/>
    </div>
</div>

</body>
</html>
