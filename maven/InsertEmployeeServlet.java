package cse5a1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/insertEmployeeServlet")
public class InsertEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        System.out.println("eid = " + request.getParameter("eid"));
        System.out.println("ename = " + request.getParameter("ename"));
        System.out.println("salary = " + request.getParameter("salary"));
        System.out.println("age = " + request.getParameter("age"));

        int eid = Integer.parseInt(request.getParameter("eid"));
        String name = request.getParameter("ename");
        int salary = Integer.parseInt(request.getParameter("salary"));
        int age = Integer.parseInt(request.getParameter("age"));

        Employee e = new Employee();
        e.setEid(eid);
        e.setEname(name);
        e.setSalary(salary);
        e.setAge(age);

        EmployeeDAO dao = new EmployeeDAO();
        int result = dao.insert(e);

        if (result > 0) {
            out.println("Employee Inserted Successfully");
        } else {
            out.println("Insert Failed");
        }
    }
}