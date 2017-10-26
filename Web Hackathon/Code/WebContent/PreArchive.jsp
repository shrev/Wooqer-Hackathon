<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.UUID" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Archives</title>
</head>
<body>
<form method="post" action="Authenticate.jsp" id="my_form">
<br><br>
<h1><u>Files Available for Download : </u></h1>
<div style:"margin-right:30px">
<table cellpadding="20px"> 
<tr>
<td> <img src="file.png" height="30" width="20"></td>
<td style="font-size:20px">Data101</td>
<td style="font-size:20px"><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Download</a></td>
</tr>
</table>
</div>
<input type = "text" name="id" style="display:none" value=<%= UUID.randomUUID().toString() %> />
</form>
</body>
</html>