<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<body>
<%--<img src="${pageContext.request.contextPath}/images/lion_king.png"/>--%>
<%--<img src="<c:url value="https://m.media-amazon.com/images/M/MV5BMjIwMjE1Nzc4NV5BMl5BanBnXkFtZTgwNDg4OTA1NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg"/>"--%>
<%--alt="Hello"/>--%>
<h2><a href="${pageContext.request.contextPath}/logout">logout</a></h2>
<div>
    <table>
        <tr>
            <td>Img</td><td>Seance id</td><td>Session start</td><td>Session end</td><td></td><td>Film name</td>
        </tr>
        <c:forEach var="seance" items="${seances}">
        <tr>
            <td>Тут картинка</td><td>${seance.id}</td><td>${seance.start}</td><td>${seance.end}</td><td>${seance.film.name}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
