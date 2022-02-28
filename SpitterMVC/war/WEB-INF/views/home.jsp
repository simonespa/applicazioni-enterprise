<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/hfortml; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Home</h2>
	<ol>
		<c:forEach items="${spittleList}" var="spittle">
			<li>${spittle.message}</li>
		</c:forEach>
	</ol>
	<p>
		Se vuoi registrarti, <a href="spitters?new">clicca quì</a>.
	</p>
</body>
</html>