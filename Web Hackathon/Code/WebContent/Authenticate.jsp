<%@ page  language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Access</title>
    <link rel="stylesheet" href="css/normalize.css">
</head>
<body>
<body>
<%@ page import="java.util.UUID" %>
<%@ page import="logic.AES" %>
<%@ page import="logic.Pdfbox" %>
  <%
    String id= (String) request.getParameter("id");
  %>
  

	 <div class="login">
	 <h1 style="color:white" >Please Enter Access Key</h1>
	<br> <h2 style="color:white">ID :<%= id%> </h2>
    <form method="post">
        <input type="password" name="pass" placeholder="Access Key" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Download</button>
        <input type="text" style="display:none" name="id" value=<%= id %> />



<%@ page import = "javax.servlet.RequestDispatcher" %>

<% String file_key="";  
 if(request.getParameter("pass")!=null)
	{
        String password = request.getParameter("pass");
        AES aes=new AES();
        String key = aes.encrypt(id).substring(0,12); 
        if(password.equals(key))
        {
        	file_key = new String(Pdfbox.encrypt());
        	System.out.println(file_key); 
        	request.getSession().setAttribute("key", file_key);
        	RequestDispatcher rd = request.getRequestDispatcher("FileDownload.jsp");
            rd.forward(request, response);
        }
	}%>
    
     
    </form>
</div>
</body>
</html>