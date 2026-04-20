package cse5a1;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/5a1",
            "root",
            "2512"
        );
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee e = new Employee();

                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setSalary(rs.getInt("salary"));
                e.setAge(rs.getInt("age"));

                list.add(e);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int deleteEmployee(int eid) {
        int status = 0;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            status = st.executeUpdate("DELETE FROM employee WHERE eid=" + eid);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public int updateEmployee(Employee e) {
        int status = 0;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            String sql = "UPDATE employee SET ename='" + e.getEname() +
                         "', salary=" + e.getSalary() +
                         ", age=" + e.getAge() +
                         " WHERE eid=" + e.getEid();

            status = st.executeUpdate(sql);

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    public int insert(Employee e) {
        int status = 0;

        try {
            Connection con = getConnection();

            String sql = "INSERT INTO employee (eid, ename, salary, age) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, e.getEid());
            ps.setString(2, e.getEname());
            ps.setInt(3, e.getSalary());
            ps.setInt(4, e.getAge());

            status = ps.executeUpdate();

            System.out.println("Rows inserted: " + status);

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}