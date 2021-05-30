package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbctest
{ 
	public static void main(String[] args) throws SQLException  
	{
		Connection myconn = null;
		Statement mystat = null;
		ResultSet myresu = null;
		
		String dbUrl = "jdbc:mysql:/localhost:3306/";
		String user = "root";
		String pass = "root";
		
		try
		{
			//Get a connection to database
			myconn = DriverManager.getConnection(dbUrl, user, pass);
			
			//Creat statement 
			mystat = myconn.createStatement();
			
			//Execute sql query 
			myresu = mystat.executeQuery("Select * from city");
			
			//Process the result set
			while (myresu.next())
			{
				System.out.println(myresu.getString("ID")+"," + myresu.getString("Name") );	
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
