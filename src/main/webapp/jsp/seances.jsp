<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<html>
<head>
    <title>
        <fmt:message key="seances.title"/>
    </title>
    <style>
        #poster-pic {
            width: 100px;
            height: 148px;
        }

        .main-container {
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

        .tickets tr:first-child td {
            border-right: none;
            border-left: 1px solid white;
        }

        .small-button {
            background-color: white;
            border: 1px solid #35ccff;
            border-radius: 4px;
            color: #35ccff;
            height: 40px;
            width: 120px;
            text-decoration: none;
            margin: 0;
            cursor: pointer;
            font-size: 15px;
        }

        .tickets {
            position: relative;
            left: 27%;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        td {
            padding: 20px 20px;
            border: 1px solid #35ccff;
            vertical-align: middle;
            line-height: 1.154;
        }

        #film-name {
            width: 170px;
            display: inline-block;
            vertical-align: middle;
            font-size: 16px;
            font-weight: bold;
            line-height: 1.154;
        }

        #add-seance {
            position: relative;
            left: 30%;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="main-container">
    <c:set var="admin" value="ADMIN"/>
    <c:if test="${sessionScope.user.role == admin}">
        <div id="add-seance">
            <form method="POST" action="${pageContext.request.contextPath}/add-seance">
                <label for="datetime"></label><input id="datetime" type="datetime-local" name="start"/>
                <label>
                    <input list="films" name="film-id">
                </label>
                <datalist id="films">
                    <c:forEach var="film" items="${allFilms}">
                    <option value="${film.id}">${film.name}
                        </c:forEach>
                </datalist>
                <input type="text" name="ticket-price">
                <input type="submit"/>
            </form>
        </div>
    </c:if>
    <div class="tickets">
        <h1><fmt:message key="seances.for"/> ${date}</h1>
        <table>
            <tr>
                <td><fmt:message key="poster.picture"/></td>
                <td><fmt:message key="seance.start"/></td>
                <td><fmt:message key="film.name"/></td>
                <td></td>
            </tr>
            <c:forEach var="seance" items="${seances}">
                <tr>
                    <td><img id="poster-pic" src="${pageContext.request.contextPath}/images/${seance.film.posterPic}">
                    </td>
                    <td><fmt:formatDate type="time" timeStyle="short" value="${seance.start}"/></td>
                    <td><span id="film-name">${seance.film.name}</span></td>
                    <td>
                        <form method="GET" action="${pageContext.request.contextPath}/seats">
                            <input type="hidden" name="seance-id" value="${seance.id}">
                            <button class="small-button"><fmt:message key="seances.see.free.tickets"/></button>
                        </form>
                        <c:if test="${sessionScope.user.role == admin}">
                            <form method="POST" action="${pageContext.request.contextPath}/remove-seance">
                                <input type="hidden" name="seance-id" value="${seance.id}">
                                <button class="small-button"><fmt:message key="button.remove"/></button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>