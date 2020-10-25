<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product stock</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fun"%>

<table border="4" cellspacing="4" cellpadding="4">
<tr><th>ID</th><th>Product name</th><th>Quantity</th>
<th>Price per product</th><th>Total</th><th>Actions</th></tr>

<fun:forEach var="hai" items="${all}">
<tr>
<td>${hai.getPid() }</td><td>${hai.getPname() }</td><td>${hai.getQuantity() }</td>
<td>${hai.getPpp() }</td><td>${hai.getTotal() }</td>


<td><ol type="A">
<li><a href="editable?id=${hai.getPid() }">Edit</a></li>
<li><a href="deletable?id=${hai.getPid() }">Delete</a></li>
</ol></td>
</tr>
</fun:forEach>
</table>
<a href="back">Back To Home</a> <br>
<a href="logout">Logout</a>
</body>
</html>