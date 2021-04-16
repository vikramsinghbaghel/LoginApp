<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<div align="center">
<h1><b>Login</b></h1>

<form action="LoginServlet" method="post">

<table class="table">
<tr><td> User Name: </td><td><input type="text" name="username"></td></tr>
<tr><td> Password: </td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value="Login"></td></tr>
</table>

</form>

</div>

</body>
</html>