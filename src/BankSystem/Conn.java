package BankSystem;
import java.sql.*;
public class Conn {
	Connection con;
	Statement st;
	public Conn()
	{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","12345");
				st=con.createStatement();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
}
		

