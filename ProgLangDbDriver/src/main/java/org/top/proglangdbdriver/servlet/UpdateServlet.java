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

@WebServlet(name = "Update", value = "/update")
public class UpdateServlet extends HttpServlet {
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
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String version = request.getParameter("version");
            String yearStr = request.getParameter("year");
            String author = request.getParameter("author");
            if (idStr == null || name == null || version == null || yearStr == null || author == null) {
                throw new InvalidParameterException("One or more params is null");
            }
            Integer id = Integer.valueOf(idStr);
            Integer year = Integer.valueOf(yearStr);
            Language language = new Language(id, name, version, year, author);
            dbClient.updateLanguage(language);
            response.getWriter().println("Successfully");

        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }

}
