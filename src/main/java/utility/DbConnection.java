package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	
	public static Connection getConn() {
		Connection con=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","ritik");  			
			}catch(Exception e){
				System.out.println(e);
			}  
		return con;
	}
}