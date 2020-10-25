<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">
<h1 style="color:blue">Welcome to Mall</h1>

<a href="list" style="text-decoration:none; border-style:solid;padding:5px;margin:5px;">Check Stock</a>
<br><br>

<a href="add" style="text-decoration:none; border-style:solid;padding:5px;margin:5px;">Add New product</a> 
<br><br>

<a href="bill1" style="text-decoration:none;border-style:solid;padding:5px;margin:5px;">Bill</a> 
<br><br>

<a href="logout" style="text-decoration:none;border-style:solid;padding:5px;margin:5px;">logout</a> 
</div>

</body>
</html>