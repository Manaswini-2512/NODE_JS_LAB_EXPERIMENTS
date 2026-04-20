package crud;
import java.sql.*;
public class Read {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/24wh1a05a4","root","sri@1234");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select * from emp");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" - "+rs.getString(2));
			}
			cn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
