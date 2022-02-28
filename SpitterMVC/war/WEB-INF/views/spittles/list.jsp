<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>
	<h2>Spittles for ${spitter.firstName} ${spitter.lastName}</h2>
	<ol>
		<c:forEach var="spittle" items="${spittles}">
			<li>${spittle.message}</li>
		</c:forEach>
	</ol>
</body>
</html>