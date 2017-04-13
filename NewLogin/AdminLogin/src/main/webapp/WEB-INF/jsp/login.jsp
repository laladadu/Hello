<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg"%>

<html>
<head>
<title>Login</title>

</head>
<body>
	language:
	<a href="?language=en">English</a>|
	<a href="?language=hi_IN">हिंदी</a>


	<form:form method="POST" modelAttribute="login" action="adminSignIn.do">

		<table width="100%" border="0">
			<tr>
				<td><label><msg:message code="admin.emailid" /></label></td>
				<td><form:input path="email_id" id="email_id" /></td>
			</tr>
			<tr>
				<td><label><msg:message code="admin.password" /></label></td>
				<td><form:password path="password" id="password" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	Current Locale : ${pageContext.response.locale}
</body>
</html>