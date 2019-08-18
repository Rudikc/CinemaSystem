<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<style>
    body {
        font-family: "Helvetica Neue", Helvetica, sans-serif;
        position: relative;
        margin: 0;
    }
    a{
        text-decoration: none;
    }

    .user-button{
        background-color: #35ccff;
        border: 1px solid white;
        border-radius: 4px;
        color: white;
        height: 40px;
        width: 100px;
        text-decoration: none;
        margin: 0;
        cursor: pointer;
        font-size: 20px;
    }
    #logo-image {
        position: absolute;
        left: 10px;
        top: 10px;
        width: 50px;
        height: 50px;
    }

    .user-text {
        position: absolute;
        top: 15px;
        right: 15px;
        font-size: 30px;
        text-align: right;
        margin-right: 10px;

    }

    #user-header {
        position: relative;
        width: 100%;
        height: 70px;
        background-color: #35ccff;

    }
</style>


<c:set var="guest" value="GUEST"/>
<c:set var="user" value="USER"/>
<c:set var="admin" value="ADMIN"/>
<div id="user-header">
    <header>

        <a href="${pageContext.request.contextPath}/">
            <img id="logo-image" src="${pageContext.request.contextPath}/images/main-logo.png"/>
        </a>

        <c:choose>
            <c:when test="${sessionScope.user.role == user}">
                <div class="user-text">
                    <a href="${pageContext.request.contextPath}/user-profile">
                        <button class="user-button"><span><fmt:message key="profile"/></span></button>
                    </a>
                    <a href="${pageContext.request.contextPath}/logout">
                        <button class="user-button"><span><fmt:message key="user.action.logout"/></span></button>
                    </a>

                </div>
            </c:when>
            <c:when test="${sessionScope.user.role == admin}">

            </c:when>
            <c:when test="${sessionScope.user.role == guest}">
                <div class="user-text">
                    <a href="${pageContext.request.contextPath}/login">
                        <button class="user-button"><span><fmt:message key="login.login"/></span></button>
                    </a>
                </div>
            </c:when>


        </c:choose>


    </header>
</div>