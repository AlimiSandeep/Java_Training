<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<c:set var="flag" value="${flag}" />
	<c:choose>

		<c:when test="${flag==true}">
           Event created successfully
         </c:when>
		<c:otherwise>
           Event already exists<br>
           Available slots are::<br>
			<c:forEach var="slots" items="${list}">
				<c:out value="${slots}" />
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>




</body>
</html>