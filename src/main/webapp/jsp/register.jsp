<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>
    <title><fmt:message key="login.registration"/></title>
    <style>

        body{
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
            position: relative;
        }


        input[type = text],input[type = password]{
            width: 300px;
            padding: 12px 20px;
            margin: 4px 0;
            box-sizing: border-box;
            border: none;
            border-bottom: 2px solid #0171ff;
        }

        #registration-text {
            color: #0171ff;
            padding-bottom: 30px;
            font-size: 40px;
        }

        .register-form {
            text-align: center;
        }
        .container-register{
            margin: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%)
        }


        a:visited{
            color: #1D67A4;
        }
        input[type=button], input[type=submit], input[type=reset] {
            background-color: white;
            border: 1px solid #0171ff;
            color: #0171ff;
            padding: 8px 20px;
            text-decoration: none;
            margin: 0;
            cursor: pointer;
            font-size: 20px;
        }
        #registration-message{
            color: grey;
            margin-bottom: 4px;
        }


    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container-register">
    <div class="register-form">
        <span id="registration-text">
            <fmt:message key="login.registration"/>
        </span>
        <form method="post" action="${pageContext.request.contextPath}/register">
            <input type="text" required placeholder="email" name="email"><br>
            <input type="password" required placeholder="password" name="password"><br>
            <input type="text" required placeholder="first name" name="first_name"><br>
            <input type="text" required placeholder="last name" name="last_name"><br>
            <input type="text" required placeholder="phone number" name="phone"><br>
            <input class="button" type="submit" value="<fmt:message key="registration.register"/> ">
        </form>
        <span id="registration-message">

             <c:if test="${not empty registrationMessage}">
                 <fmt:message key="${registrationMessage}"/>
             </c:if><br>

        </span>
    </div>

</div>
</body>
</html>