<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>image management utility </title>

<style>
table{
  border: 1px solid black;
}
</style>

</head>
<body>

<div align="center">
<table border="1">
<tr align="center" ><b>Image Management Utility</b></tr>
<hr>
<tr>
<p>Please select the image to upload(size 1mb)</p><br>

<form action="ImageServlet" method="post" enctype='multipart/form-data'>
<input type="file" name="file">
<input type="submit" value ="upload">
</form>
<form action="LoginSuccess.jsp" method ="post">
<input type="submit"  value ="cancle">
</form>
<p><b>Uploaded Images</b></p>
</tr>
<tr>
<td><b>S.NO</b></td>
<td><b>Name</b></td>
<td><b>Size</b></td>
<td><b>Preview</b></td>
<td><b>Action</b></td>
</tr>
<tr colspan=5>
<td>  </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
</tr>

</table>
</div>
</body>
</html>