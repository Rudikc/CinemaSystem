<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>


<div>
    <form>
        <label for="datetime"></label><input id="datetime" type="datetime-local"/>
        <label>
            <input list="films">
        </label>
        <datalist id="films">
            <c:forEach var="film" items="allFilms">
                <option>${film.name}</option>
            </c:forEach>
        </datalist>
        <input type="submit"/>
    </form>
</div>