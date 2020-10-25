<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">

${msg }
<h1>Mall Login</h1>
<form action="log" method="post">
<table>
<tr><td><input type="text" name="user" placeholder="Username"></td></tr>
<tr><td><input type="password" name="pass" placeholder="Password"></td></tr>
<tr><td><input type="submit" value="Login"></td>
<td><input type="reset" value="Clear"></td></tr>
</table>
</form>
</div>

</body>
</html>