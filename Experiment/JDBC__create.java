package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC__create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/24wh1a05a4","root","sri@1234");
			Statement st = cn.createStatement();
			st.executeUpdate("INSERT INTO emp VALUES(3,'Ragu')");
			cn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

	}

}
