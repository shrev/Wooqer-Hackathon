package Trial;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		File file = new File("wooqer_idea.pdf");
	    int length   = 0;
	    ServletOutputStream outStream = response.getOutputStream();
	    ServletContext context  = getServletConfig().getServletContext();
	    String mimetype = context.getMimeType(file.getCanonicalPath());

	    // sets response content type
	    if (mimetype == null) {
	        mimetype = "application/pdf";
	    }
	    response.setContentType(mimetype);
	    response.setContentLength((int)file.length());
	    String fileName = (new File(file.getCanonicalPath())).getName();

	    // sets HTTP header
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

	    byte[] byteBuffer = new byte[10];
	    DataInputStream in = new DataInputStream(new FileInputStream(file));

	    // reads the file's bytes and writes them to the response stream
	    while ((in != null) && ((length = in.read(byteBuffer)) != -1))
	    {
	        outStream.write(byteBuffer,0,length);
	    }

	    
	    
	    
	    
	    
	    
	}
      
		//response.sendRedirect("/FilePassword");
		
	    
	

}
