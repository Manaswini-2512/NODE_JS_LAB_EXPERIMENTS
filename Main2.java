package fullstack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2{

        public static void main(String[] args) {
                // TODO Auto-generated method stub
          try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/me","root","1234");

      Statement statement = connection.createStatement();
      int rs = statement.executeUpdate("delete from emp where empname='ram' ");

    
          System.out.println(rs);
      
      connection.close();
          }

          catch(SQLException e) {
                  e.printStackTrace();
          }


        }

}