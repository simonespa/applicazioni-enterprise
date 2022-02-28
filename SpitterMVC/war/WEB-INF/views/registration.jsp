<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.error {
	color: red;
}
</style>
<title>Registration Page</title>
</head>
<body>
	<sf:form method="POST" commandName="spitter">
		<fieldset>
			<label for="firstName">First Name:</label>
			<sf:input id="firstName" path="firstName" />
			<sf:errors path="firstName" cssClass="error" delimiter=", " /><br />
			<label for="lastName">Last Name:</label>
			<sf:input id="lastName" path="lastName"/>
			<sf:errors path="lastName" cssClass="error" delimiter=", " /><br />
			<input type="submit" value="Register">
		</fieldset>
	</sf:form>
</body>
</html>