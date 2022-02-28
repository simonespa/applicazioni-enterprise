<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<ul>
		<li>Name: ${spitter.firstName}</li>
		<li>Surname: ${spitter.lastName}</li>
	</ul>
	Registrati al sistema. Clicca <a href="register">quì</a>.
</body>
</html>