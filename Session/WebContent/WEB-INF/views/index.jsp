<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form action="login" method="post" commandName="login">
		<sf:input path="a"/>
		<sf:errors path="a" />
		<sf:input path="b"/>
		<sf:errors path="b" />
		<input type="submit" value="Log In" />
	</sf:form>
	
	<sf:form action="signup" method="post" commandName="signup">
		<sf:input path="c"/>
		<sf:errors path="c" />
		<sf:input path="d"/>
		<sf:errors path="d" />
		<input type="submit" value="Sign Up" />
	</sf:form>
</body>
</html>