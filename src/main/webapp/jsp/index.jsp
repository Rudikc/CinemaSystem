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
        }

        #main-container{
            text-align: center;
        }
        #language-panel{
            display: flex;
            justify-content: center;
        }
    </style>

    <title><fmt:message key="title.index"/></title></head>
<body>
<c:set var="guest" value="GUEST"/>
<div id="main-container">
    <h1><fmt:message key="index.greetings"/></h1>
    <h2><a href="${pageContext.request.contextPath}/seances">See titles</a></h2>
    <c:if test="${sessionScope.user.role == guest}">
        <h2><a href="${pageContext.request.contextPath}/login">Sign in</a></h2>
    </c:if>
    <div id="language-panel">
        <myTag:language-change-panel page="${pageContext.request.pathInfo}"/>
    </div>
</div>

</body>
</html>
