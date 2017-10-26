package Trial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class user
{
	private String uname;
	private String email;
	
	public user(String uname,String email)
	{
		this.uname=uname;
		this.email =email;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
/**
 * Servlet implementation class MailTo
 */
@WebServlet("/MailTo")
public class MailTo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailTo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap users=new HashMap(3);
		users.put("Jack S","shre95@gmail.com");
		users.put("Arya Stark","shre95@gmail.com");
		users.put("Will Smith","shreya.dkv@gmail.com");
		int size = request.getContentLength();
		String[] list = request.getParameterValues("users");
		System.out.println(list.length);
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String to=null;
		
		for(int i=0;i<list.length;i++)
		{
		
	    if(users.containsKey(list[i]))
	    {	
		String from="FBIAgency@gov.in";
		String host = "localhost";
		to = (String) users.get(list[i]);
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		//properties.setProperty("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shre95@gmail.com","1stfloor");
            }
        });
		
	    
	    MimeMessage message = new MimeMessage(session);
	    
	    try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,
	                new InternetAddress(to));
		    message.setSubject("File Access URL");
		    
		    message.setText("<html><body>Please use the following URL to retrieve the key :<br><br>"+"<a href=\"http://localhost:8080/Access.jsp\">localhost:8080/Access</a>"+"<br><br> This is confidential<body></html>","UTF-8","html");
		    //System.out.println("<a href='localhost:8080/Access'>localhost:8080/Access</a>");
		    //System.out.println("<html><a href='localhost:8080/Access'>localhost:8080/Access</a></html>");
		    Transport.send(message);
	    
		    
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    else continue;
		}
		
		String title = "Shared";
        String res = "Shared Succesfully";
        String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
        "transitional//en\">\n";
        out.println(docType +
        "<html>\n" +
        "<head><title>" + title + "</title></head>\n" +
        "<body bgcolor=\"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n" +
        "<p align=\"center\">" + res + "</p>\n" +
        "</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



