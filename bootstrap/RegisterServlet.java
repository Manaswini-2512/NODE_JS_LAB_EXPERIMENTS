package com.ebook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebook",
                    "root",
                    "2512");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO users(name,email,password) VALUES(?,?,?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            response.sendRedirect("index.html");

            con.close();

        } catch (Exception e) {
            //e.printStackTrace();
        	response.getWriter().println(e);
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    }
}