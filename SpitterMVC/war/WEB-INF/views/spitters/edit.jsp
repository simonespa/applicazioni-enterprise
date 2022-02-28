<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h2>Create a free Spitter account</h2>
	<sf:form method="POST" modelAttribute="spitter">
		<fieldset>
			<table>
				<tr>
					<th><label for="user_first_name">Firstname:</label></th>
					<td>
						<sf:input path="firstName" size="15" id="user_first_name" />
						<sf:errors path="firstName" cssClass="error" delimiter=", " />
					</td>
				</tr>
				<tr>
					<th><label for="user_last_name">Lastname:</label></th>
					<td>
						<sf:input path="lastName" size="15" id="user_last_name" />
						<sf:errors path="lastName" cssClass="error" delimiter=", " />
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input name="commit" type="submit" /></td>
				</tr>
			</table>
		</fieldset>
	</sf:form>

</body>
</html>