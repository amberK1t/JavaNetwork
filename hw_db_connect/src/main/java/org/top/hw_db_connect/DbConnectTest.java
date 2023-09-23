package org.top.hw_db_connect;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "dbTestServlet", value = "/db-test-servlet")
public class DbConnectTest extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String dbName = "academy_db_java213";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            response.getWriter().println("Driver error:" + e.getMessage());
            return;
        }

        String url = "jdbc:mysql://" + host + "/" + dbName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            response.getWriter().println("Connection error: "+ e.getMessage());
            return;
        }

        try {
            String sql = "SELECT * FROM student_t";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer id = result.getInt(1);
                String name = result.getString(2);
                String fromCity = result.getString(3);
                response.getWriter().println(id + " - " + name + " - " + fromCity + "<br>");
            }
        } catch (Exception e) {
            response.getWriter().println("Execute query error: " + e.getMessage());
            return;
        }
        response.getWriter().println("Successfully connected");
    }

}
