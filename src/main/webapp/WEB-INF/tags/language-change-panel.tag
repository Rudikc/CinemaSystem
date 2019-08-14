<%@ tag description="Language change panel tag" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>
<div>
    <table>
        <tr>
            <td>
                <h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=ru_RU"><fmt:message
                        key="language.russian"/> </a></h4>
            </td>
            <td>
                <h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=uk_UA"><fmt:message
                        key="language.ukrainian"/> </a></h4>
            </td>
            <td>
                <h4><a href="${pageContext.request.contextPath}/changeLanguage?locale=en_US"><fmt:message
                        key="language.english"/> </a></h4>
            </td>
        </tr>
    </table>
</div>
