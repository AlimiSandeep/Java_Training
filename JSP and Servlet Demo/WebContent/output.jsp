<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displaying Name</title>
</head>
<body>

	<p>

		<%
			String fullname = request.getAttribute("Name").toString();

			out.println(fullname);
		%>
	</p>
</body>
</html>