<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loaded Excel Table</title>
</head>
<body>
<a href="systemContracts">Go to database operations</a>
<h2>Loaded data from excel:</h2>
<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<th>request</th>
		<th>order_number</th>
		<th>from_date</th>
		<th>to_date</th>
		<th>amount</th>
		<th>amount_type</th>
		<th>amount_period</th>
		<th>authorization_percent</th>
		<th>active</th>
	</tr>
	<c:forEach var="p" items="${listArkusz1}">
		<tr>
			<td>${p.request}</td>
			<td>${p.order_number}</td>
			<td>${p.from_date}</td>
			<td>${p.to_date}</td>
			<td>${p.amount}</td>
			<td>${p.amount_type}</td>
			<td>${p.amount_period}</td>
			<td>${p.authorization_percent}</td>
			<td>${p.active}</td>
		</tr>
</c:forEach>
</table>

</body>
</html>