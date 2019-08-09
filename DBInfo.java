import java.sql.*;
public class DBInfo {
	 static Connection con;
	  static
	  {
	    try
		{
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	  }
	  public static Connection getConn()
	  {
	   try
	   {
	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","rat");
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	   }
	   return con;
	  }
	  public static void close()
	  {
		   try
		   {
		    con.close();
		   }
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
	  }

}
