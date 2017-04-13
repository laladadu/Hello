<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function getConfirmation() {
		var retVal = confirm("Are you sure You want to delete ?");
		if (retVal == true) {

			return true;
		} else {

			return false;
		}
	}
</script>
</head>
<body>

	<form:form method="POST" action="saveProductDetails.do"
		modelAttribute="Product">
		<table width="100%" border="0">
			<tr>
				<td><label>Product Name:</label></td>
				<td><form:input path="pro_name" value="${pro_name}" /> <form:errors
						path="pro_name" /></td>
			</tr>
			<tr>
				<td><label>Product Id:</label></td>
				<td><form:input path="pro_id" value="${pro_id}" /> <form:errors
						path="pro_id" /></td>
			</tr>
			<tr>
				<td><label>Price:</label></td>
				<td><form:input path="pro_price" value="${pro_price}" /> <form:errors
						path="pro_price" /></td>
			</tr>
			<tr>
			<tr>
				<td><label>Product Category:</label></td>
				<td><form:input path="pro_category" value="${pro_category}" />
					<form:errors path="pro_category" /> <form:hidden path="p_id"
						value="${p_id}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<div>

		<table width="100%" border="1">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Category</th>
					<th>Product Price</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty records}">
					<tr>
						<td colspan="6">No records found</td>
					</tr>
				</c:if>
				<c:if test="${not empty records}">

					<c:forEach items="${records}" var="record">
						<tr>
							<td>${record.pro_id}</td>
							<td>${record.pro_name}</td>
							<td>${record.pro_category}</td>
							<td>${record.pro_price}</td>
							<td><a href="Edit.do?arg=${record.p_id}">Click for Edit</a></td>
							<td><a href="Delete.do?arg=${record.p_id}"
								onclick="getConfirmation();">Click for Delete</a>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

	</div>

</body>
</html>