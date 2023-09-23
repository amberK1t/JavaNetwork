package org.top.proglangdbdriver.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.top.proglangdbdriver.entity.Language;
import org.top.proglangdbdriver.rdb.DbClient;
import org.top.proglangdbdriver.rdb.DbFactory;

import java.io.IOException;
import java.security.InvalidParameterException;

@WebServlet(name = "Insert", value = "/insert")
public class InsertServlet extends HttpServlet {
    private DbClient dbClient;
    @Override
    public void init() {
        try {
            dbClient = DbFactory.prepareDbClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            String name = request.getParameter("name");
            String version = request.getParameter("version");
            Integer year = Integer.valueOf(request.getParameter("year"));
            String author = request.getParameter("author");
            if (name == null || version == null || year == null || author == null) {
                throw new InvalidParameterException("One or more params is null");
            }
            Language language = new Language(name, version, year, author);
            dbClient.insertLanguage(language);
            response.getWriter().println("Successfully");

        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }

}
