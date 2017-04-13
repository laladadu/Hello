<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<form:form method="POST" action="saveStudentDeatils.do"
		modelAttribute="Registration">
		<table width="100%" border="0">

			<tr>
				<td><label>First Name:</label></td>
				<td><form:input path="firstName" /> <form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td><label>Last Name:</label></td>
				<td><form:input path="lastName" /> <form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td><label>Email Id :</label></td>
				<td><form:input path="emailId" /> <form:errors path="emailId" />
				</td>
			</tr>
			<tr>
			<tr>
				<td><label>Password :</label></td>
				<td><form:password path="password" /> <form:errors path="password" /></td>
			</tr>
			<tr>
				<td><label>Contact :</label></td>
				<td><form:input path="contact" /> <form:errors path="contact" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>