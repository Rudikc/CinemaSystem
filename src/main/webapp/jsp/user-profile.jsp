<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<head>

</head>
<body>

<table>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                    ${order}
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
