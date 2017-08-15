<%-- 
    Document   : welcome
    Created on : 4/01/2017, 3:08:41 PM
    Author     : nissanka
--%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<%--<c:url value="/resources/text.txt" var="url"/>--%>
	<%--<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />--%>
	<br>
	Message: ${message}
        
        <br>
        <br>
        <c:forEach var="post" items="${posts}" >
            <h3>${post.title}</h3>
            <div>
                <p>${post.createdOn}</p>
                <p>${post.content}</p>
            </div>
        </c:forEach>
        
        
        <br>
        <br>
        TEST 2!
</body>

</html>
