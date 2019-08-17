<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmg" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>

<html>
<head>
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
            border-bottom: 2px solid #0192ff;
        }

        #login-text {
            color: #0192ff;
            padding-bottom: 30px;
            font-size: 40px;
        }

        .login-form {
            text-align: center;
        }
        .container-login{
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
            border: 1px solid #0192ff;
            color: #0192ff;
            padding: 8px 20px;
            text-decoration: none;
            margin: 0;
            cursor: pointer;
            font-size: 20px;
        }
        #login-message{
            color: grey;
            margin-bottom: 4px;
        }

        #registration-message{
            margin: 100px 100px;
            color: #0192ff;
        }

    </style>
    <title>

    </title>
</head>
<body>
<div class="container-login">
    <div class="login-form">
        <span id="login-text">
            <fmt:message key="login.login"/>
        </span>

        <form method="post" action="${pageContext.request.contextPath}/login">
            <div>
                <input type="text" required placeholder="e-mail" name="email"><br>
            </div>

            <div>
                <input type="password" required placeholder="password" name="password"><br><br>
            </div>
            <div>
                <c:if test="${not empty loginMessage}">
                <span id="login-message">
                    <fmt:message key="${loginMessage}"/>
                </span>
                </c:if><br>
            </div>
            <div>
                <input class="button" type="submit" value="<fmg:message key="login.sign.in"/>">
            </div>

            <div id="registration-message">
                <a href="${pageContext.request.contextPath}/register"><fmt:message key="login.registration"/></a>
            </div>
        </form>

    </div>
</div>
</body>
</html>