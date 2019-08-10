<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<body>
<%--<img src="${pageContext.request.contextPath}/images/lion_king.png"/>--%>
<%--<img src="<c:url value="https://m.media-amazon.com/images/M/MV5BMjIwMjE1Nzc4NV5BMl5BanBnXkFtZTgwNDg4OTA1NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg"/>"--%>
     alt="Hello"/>
<div>
    <c:forEach var="seance" items="${seances}">
        <div>
            <h2>
                    ${seance.start}
            </h2>
            <h2>
                    ${seance.film.id}
            </h2>
            <h2>
                    ${seance.film.duration}
            </h2>
            <h2>
                    ${seance.film.name}
            </h2>
        </div>
    </c:forEach>
</div>
</body>
</html>
