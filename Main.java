package fullstack;
	//
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Main {

	        public static void main(String[] args) {
	                // TODO Auto-generated method stub
	          try {
	      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/me","root","1234");

	      Statement statement = connection.createStatement();
	      ResultSet rs = statement.executeQuery("select * from emp");
	      while(rs.next()) {
	          System.out.println(rs.getInt("age"));
	          System.out.println(rs.getInt("empid"));
	      }
	      connection.close();
	          }

	          catch(SQLException e) {
	                  e.printStackTrace();
	          }


	        }

	}

	
