package cse5a1;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/getEmployeeServlet")
public class GetEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.getAllEmployees();

        if (list.isEmpty()) {
            out.println("No employees found");
            return;
        }

        out.println("Database selected: 5a1");
        out.println("EID | ENAME | SALARY | AGE");

        for (Employee e : list) {
            out.println(e.getEid() + " | " +
                        e.getEname() + " | " +
                        e.getSalary() + " | " +
                        e.getAge());
        }
    }
}