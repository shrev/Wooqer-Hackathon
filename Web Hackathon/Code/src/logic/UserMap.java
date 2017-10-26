package logic;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;



public class UserMap {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/fbi";
   
	static final String USER = "root";
	static final String PASS = "shrev95";

	
 public Connection connect()
 {

			Connection conn = null;
			Statement stmt = null;
			try{
				//Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				//Open a connection
				System.out.println("Connecting to database...");
				conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				return conn;
				}catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				}catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}finally{
					//finally block used to close resources
					try{
						if(stmt!=null)
							stmt.close();
						}catch(SQLException se2){
						}
				}
	      return conn;
		}
 
 
   public ResultSet getUsers()
   {
	   Connection conn = connect();
	   try {
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery("select * from user details");
		return rs;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	     
	   return null;
   }
  
}
