

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
</head>
<body>

	<h3>Displaying info by EL expression</h3>
	<p>
		<i>My name is ${student.name }</i><br> <i>My age is
			${student.age } and</i><br> <i>I live in ${student.location }</i>
	</p>
	<hr>

	<h3>Displaying info by JSTL</h3>
	<c:out value="Hello, ${student.name }"></c:out>
	<hr>

	<h3>ForEach loop in JSTL</h3>
	<p>
		<b>Hobbies are:</b>
	</p>
	<c:forEach items="${hobbies}" var="hobby">
		<p>${hobby}</p>
	</c:forEach>
	<hr>

	<h3>URL tag in JSTL</h3>
	<a href="<c:url value="https://www.google.com"></c:url>">Click here
		to go to GOOGLE</a>
	<hr>


	<h3>List Iteration</h3>
	<table border=1>
		<tr>
			<th>NAME</th>
			<th>AGE</th>
			<th>LOCATION</th>
			<th>VOTE STATUS</th>
		</tr>

		<c:forEach items="${list}" var="student">
			<tr>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.location}</td>
				<c:choose>
					<c:when test="${student.age>=18}">
						<td>Eligible</td>
					</c:when>
					<c:otherwise>
						<td>Not Eligible</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	<hr>


	<h3>JSTL functions</h3>
	<c:set var="string" value="Hello Every One,Good evening"></c:set>
	<p>
		Original string =
		<c:out value="${string }"></c:out>
	</p>
	<p>
		toLowerCase() =
		<c:out value="${fn:toLowerCase(string) }"></c:out>
	</p>
	<p>
		toUpperCase() =
		<c:out value="${fn:toUpperCase(string) }"></c:out>
	</p>
	<p>length()=<c:out value="${fn:length(string) }"></c:out></p>
	<p>"<c:out value="${string }"> </c:out>" contains() 'Hello' ? <c:out value="${fn:contains(string,'Hello') }"></c:out></p>
	<p>indexOF() 'Good' in "<c:out value="${string }"> </c:out>" = <c:out value="${fn:indexOf(string,'Good')}"></c:out></p>
	<hr>

<h3>Split() and Join() usage</h3>
 <c:set var = "string1" value = "This is first String."/>
 <p>Original string = <c:out value="${string1}"></c:out></p>
      <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
      <p>Splitted string :<br>
      <c:forEach items="${string2}" var="words">
      <c:out value="${words}"></c:out>
  		<br>
      </c:forEach>
      </p>
      <c:set var = "string3" value = "${fn:join(string2, '-')}" />
      <p>Final String : ${string3}</p>
</body>
</html>