<%@ tag description="Language change panel tag" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="page" required="true" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value="${locale}"/>
<head>
    <style type="text/css">
        #language-panel {
        }
        .language-icon {
            width: 24px;
            height: 24px;
        }
    </style>
</head>
<div>
    <table id="language-panel">
        <tr>
            <td>
                <h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=ru_RU">
                    <img class="language-icon"
                         src="${pageContext.request.contextPath}/images/languageIcons/russia.png"
                         alt="ru"> </a>
                </h4>
            </td>
            <td>
                <h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=uk_UA">
                    <img class="language-icon"
                         src="${pageContext.request.contextPath}/images/languageIcons/ukraine.png"
                         alt="ua"></a>
                    </h4>
            </td>
            <td>
                <h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=en_US">
                    <img class="language-icon"
                         src="${pageContext.request.contextPath}/images/languageIcons/united-kingdom.png"
                         alt="uk"></a>
                </h4>
            </td>
        </tr>
    </table>
</div>
