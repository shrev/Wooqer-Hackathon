<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Download</title>
</head>
<body bgcolor="#f0f0f0">
<h1 align="center">File Download</h1>
<p align="center">File Access Password : <%= (String) request.getSession().getAttribute("key") %></p>
<form method="post" action="Download">
<center><button type="submit">DOWNLOAD</button></center>
</form>
</body>
</html>

