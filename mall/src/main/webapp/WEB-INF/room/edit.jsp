<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing Stock</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>

${msg }
<%@ taglib prefix="mall" uri="http://www.springframework.org/tags/form" %>
<mall:errors path="product.*"/>
<form action="change" method="post">
<table>
<tr><td><input type="number" name="pid" value="${one.getPid() }" required></td></tr>
<tr><td><input type="text" name="pname" value="${one.getPname() }" required></td></tr>
<tr><td><input type="number" name="quantity" value="${one.getQuantity() }" required></td></tr>
<tr><td><input type="number" name="ppp" value="${one.getPpp() }" required></td></tr>
<tr>
<td><input type="submit" value="Update to Stock"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<a href="back">Back To Home</a>  <br>
<a href="logout">Logout</a>

</body>
</html>