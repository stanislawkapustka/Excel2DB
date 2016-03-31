<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Import Excell File</title>
</head>
<body>

	<s:form method="post" commandName="excelFile" action="importexcel.html"
		enctype="multipart/form-data">
		Select excel file: <input type="file" name="file">
		<br>
		<input type="submit" value="Import">
	</s:form>


</body>
</html>