<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>System Contract</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h3>Add a Contract</h3>

	<c:url var="addAction" value="/systemContract/add"></c:url>

	<form:form action="${addAction}" commandName="systemContract">
		<table>
			<c:if test="${!empty systemContract.order_number}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="request">
						<spring:message text="request" />
					</form:label></td>
				<td><form:input path="request" /></td>
			</tr>
			<tr>
				<td><form:label path="order_number">
						<spring:message text="order_number" />
					</form:label></td>
				<td><form:input path="order_number" /></td>
			</tr>
			<tr>
				<td><form:label path="from_date">
						<spring:message text="from_date" />
					</form:label></td>
				<td><form:input path="from_date" /></td>
			</tr>
			<tr>
				<td><form:label path="to_date">
						<spring:message text="to_date" />
					</form:label></td>
				<td><form:input path="to_date" /></td>
			</tr>
			<tr>
				<td><form:label path="amount">
						<spring:message text="amount" />
					</form:label></td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td><form:label path="amount_type">
						<spring:message text="amount_type" />
					</form:label></td>
				<td><form:input path="amount_type" /></td>
			</tr>
			<tr>
				<td><form:label path="amount_period">
						<spring:message text="amount_period" />
					</form:label></td>
				<td><form:input path="amount_period" /></td>
			</tr>
			<tr>
				<td><form:label path="authorization_percent">
						<spring:message text="authorization_percent" />
					</form:label></td>
				<td><form:input path="authorization_percent" /></td>
			</tr>
			<tr>
				<td><form:label path="active">
						<spring:message text="active" />
					</form:label></td>
				<td><form:input path="active" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if
						test="${!empty systemContract.order_number}">
						<input type="submit"
							value="<spring:message text="Edit Contract"/>" />
					</c:if> <c:if test="${empty systemContract.order_number}">
						<input type="submit" value="<spring:message text="Add Contract"/>" />
					</c:if></td>
			</tr>
			
		</table>
	</form:form>
	<br>
	<h3>System Contracts List</h3>
	<c:if test="${!empty listSystemContracts}">
		<table class="tg">
			<tr>
				<th width="80">id</th>
				<th width="80">request</th>
				<th width="80">order nr</th>
				<th width="80">from date</th>
				<th width="80">to date</th>
				<th width="80">amount</th>
				<th width="80">amount type</th>
				<th width="80">amount period</th>
				<th width="60">auth pecent</th>
				<th width="60">active</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listSystemContracts}" var="systemContract">
				<tr>
					<td>${systemContract.id}</td>
					<td>${systemContract.request}</td>
					<td>${systemContract.order_number}</td>
					<td>${systemContract.from_date}</td>
					<td>${systemContract.to_date}</td>
					<td>${systemContract.amount}</td>
					<td>${systemContract.amount_type}</td>
					<td>${systemContract.amount_period}</td>
					<td>${systemContract.authorization_percent}</td>
					<td>${systemContract.active}</td>
					<td><a href="<c:url value='/edit/${systemContract.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${systemContract.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>