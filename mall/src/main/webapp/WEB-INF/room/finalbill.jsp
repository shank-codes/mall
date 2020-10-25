<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fun"%>

<table border="4" cellspacing="4" cellpadding="4">
<tr><th>ID</th><th>Product name</th><th>Quantity</th>
<th>Price per product</th><th>Total</th></tr>

<fun:forEach var="hai" items="${one}">
<tr>
<td>${hai.getPid() }</td><td>${hai.getPname() }</td><td>${hai.getQuantity() }</td>
<td>${hai.getPpp() }</td><td>${hai.getTotal() }</td>

</tr>
</fun:forEach>
</table>
<br>
<p id="demo"></p>
<script type="text/javascript">
var sum=0.0;
<fun:forEach var="hai" items="${one}">
sum+=${hai.getTotal() };
</fun:forEach>
document.getElementById("demo").innerHTML="Total :"+sum;
</script>
<br><br>
<a href="newbill">new bill</a> <br><br> 
<a href="back">Back To Home</a> <br><br>
<a href="logout">Logout</a>
</body>
</html>