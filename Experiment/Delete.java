package crud;

import java.sql.*;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/24wh1a05a4","root","sri@1234");
			Statement st = cn.createStatement();
			st.executeUpdate("DELETE from emp where empid=2");
			cn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
