package cse5a1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        int eid = Integer.parseInt(request.getParameter("eid"));

        EmployeeDAO dao = new EmployeeDAO();
        int result = dao.deleteEmployee(eid);

        if (result > 0) {
            out.println("Employee Deleted Successfully");
        } else {
            out.println("Employee Not Found");
        }
    }
}