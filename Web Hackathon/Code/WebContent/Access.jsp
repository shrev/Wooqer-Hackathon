<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pdfbox.AES" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Key</title>
</head>
<body>
<br><br>
<br><br>
<br><br>
<div style="background-color:grey;text-align:center">
<form method="post">
<h1 style="font-size:36px">Enter Key</h1>
<br>
<input type="text" placeholder="key" name="key" style="font-size:26px"/> <br>
<button type="submit" style="color:#00134d;font-size:26px">DONE</button> <br><br>
</form>
<%  String val="";
    if(request.getParameter("key") !=null)
	{
	   AES aes =new AES();
	   val = aes.encrypt(request.getParameter("key")).substring(0,12);
	}
	%>
<h2>
	<%= "The Access Key is : "+val %></h2>
</div>
</body>
</html>
