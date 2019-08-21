<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<head>

    <title>
        <fmt:message key="film.catalogue.title"/>
    </title>
    <style>
        .add-form {
            margin: 10px 10px;
            position: relative;
            left: 45%;
        }

        .add-form input {
            margin: 5px 5px;
        }

        .pages {
            position: absolute;
            left: 50%;
        }

        #poster-pic {
            width: 100px;
            height: 148px;
        }

        .tickets {
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

        .tickets-info {
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

        td {
            padding: 20px 20px;
            border: 1px solid #35ccff;
            vertical-align: middle;
            line-height: 1.154;
        }
    </style>
</head>

<body>
<jsp:include page="header.jsp"/>
<div class="add-form">
    <form method="POST" action="${pageContext.request.contextPath}/add-film">
        <label>
            <fmt:message key="film.name"/>
            <input type="text" name="film-name">
        </label><br>
        <label>
            <fmt:message key="film.director"/>
            <input type="text" name="director">
        </label><br>
        <label>
            <fmt:message key="film.premiere.date"/>
            <input type="date" name="premiere-date">
        </label><br>
        <label>
            <fmt:message key="film.duration"/>
            <input type="time" name="duration">
        </label><br>
        <input type="file" name="poster-pic"><br>
        <input type="submit">
    </form>
</div>


<section class="tickets">
    <div class="tickets-info">
        <table>
            <tr>
                <td><fmt:message key="film.id"/></td>
                <td><fmt:message key="poster.picture"/></td>
                <td><fmt:message key="film.name"/></td>
                <td><fmt:message key="film.director"/></td>
                <td><fmt:message key="film.duration"/></td>
                <td><fmt:message key="film.premiere.date"/></td>
                <td></td>

            </tr>
            <c:forEach var="film" items="${films}">
                <tr>
                    <td>${film.id}</td>
                    <td><img id="poster-pic" src="${pageContext.request.contextPath}/images/${film.posterPic}"></td>
                    <td>${film.name}</td>
                    <td>${film.director}</td>
                    <td>${film.duration}</td>
                    <td>${film.premiereDate}</td>
                    <td>
                        <form method="POST" action="${pageContext.request.contextPath}/remove-film">
                            <input type="hidden" name="film-id" value="${film.id}">
                            <button><fmt:message key="button.remove"/></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
            </tr>
        </table>
    </div>
</section>
<div class="pages">
    <c:forEach var="page" items="${pages}">
        <a href="${pageContext.request.contextPath}/film-catalogue?page=${page}">${page}</a>
    </c:forEach>
</div>
</body>