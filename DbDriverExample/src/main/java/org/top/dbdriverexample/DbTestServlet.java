package org.top.dbdriverexample;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "dbTestServlet", value = "/db-test-servlet")
public class DbTestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // ЗАДАЧА: подключиться к СУБД к базе academy_java213_db и получить информацию о всех записях бд
        // 1. параметры, необходимые для подключения к БД
        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String dbName = "academy_db_java213";
        // 2. регистрация драйвера
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            response.getWriter().println("Driver error: " + ex.getMessage());
            return;
        }
        // 3. сформировать строку подключения к БД
        String url = "jdbc:mysql://" + host + "/" + dbName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            response.getWriter().println("Connection error: " + ex.getMessage());
            return;
        }
        // 4. получить все записи
        try {
            String sql = "SELECT * FROM student_t WHERE from_city_f = 'Москва';";   // строка sql запроса
            Statement statement = connection.createStatement();                     // выражение для работы с БД
            ResultSet result = statement.executeQuery(sql);                         // выполнение запроса с табличным результатом
            // 5. прочитать результат
            while (result.next()) {
                // извлекаем данные очередной строки таблицы результата
                Integer id = result.getInt(1);
                String name = result.getString(2);
                String fromCity = result.getString(3);
//                Integer id = result.getInt(1);
//                String name = result.getString(2);
//                String fromCity = result.getString(3);
                response.getWriter().println(id + " - " + name + " - " + fromCity + "<br>");
            }
        } catch (Exception ex) {
            response.getWriter().println("Execute query error: " + ex.getMessage());
            return;
        }
        response.getWriter().println("Successfully connected");
    }
}
