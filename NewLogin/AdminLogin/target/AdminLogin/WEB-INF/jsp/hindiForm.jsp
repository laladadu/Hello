<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hindi Registration Form</title>
</head>
<body>
	<form:form method="POST" action="saveHindiDeatils.do" modelAttribute="hindiRegistration">
FIRST NAME<form:input path="firstName"/>
LAST NAME<form:input path="lastName"/>
		<input type="submit" value="save">
	</form:form>
</body>
</html>