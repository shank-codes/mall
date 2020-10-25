<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg}

<%@ taglib prefix="dlithe" uri="http://www.springframework.org/tags/form" %>
<dlithe:errors path="vehicle.*"/>

<form action="newstock" method="post">
<table>
<tr><td><input type="text" name="pname" placeholder="Enter the product name" required></td></tr>
<tr><td><input type="number" name="quantity" placeholder="Enter the quantity" required></td></tr>
<tr><td><input type="number" name="ppp" placeholder="Enter price per product" required></td></tr>
<tr>
<td><input type="submit" value="Add to Stock"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<br>
<a href="back">Back To Home</a> <br>
<a href="logout">Logout</a>
</body>
</html>