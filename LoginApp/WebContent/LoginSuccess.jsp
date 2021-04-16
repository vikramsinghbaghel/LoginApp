<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>image management utility</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<h1 align="center">
		<b>Image Management Utility</b>
	</h1>
	<hr>
	<p align="center">Please select the image to upload(size 1mb)</p>
	<div align="center">
		<form action="ImageServlet" method="post"
			enctype='multipart/form-data'>
			File name: <input type="text" name="name"><br> <br>
			<input type="file" name="file"> <br> <input
				type="submit" value="upload">
		</form>

		<form action="LoginSuccess.jsp" method="post">
			<input type="submit" value="cancle">
		</form>
		<br>
		<h3>
			<b>Uploaded Images</b>
		</h3>
	</div>




	<div align="center" class="container">

		<sql:setDataSource driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/userdb" user="root" password="root"
			var="datasource" />
		<sql:query dataSource="${datasource}" var="resultset"> select * from userimages;</sql:query>


		<table class="table" border="1">
			<tr>
				<td><b>Serial_No</b></td>

				<td><b>Name</b></td>
				<td><b>Preview</b></td>
			</tr>

			<c:forEach items="${resultset.rows}" var="row">
				<tr>
					<td><c:out value="${row.imageId}"></c:out></td>
					<td><c:out value="${row.name}"></c:out></td>
					<td><img src="${pageContext.servletContext.contextPath }/ImageRetrieveServlet?imageId=${row.imageId}"
						width="100" height="100" /></td>

				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>