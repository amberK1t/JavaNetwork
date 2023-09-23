package org.top.proglangdbdriver.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.top.proglangdbdriver.entity.Language;
import org.top.proglangdbdriver.rdb.DbClient;
import org.top.proglangdbdriver.rdb.DbFactory;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "FindAll", value = "/find-all")
public class FindAllServlet extends HttpServlet {
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            Collection<Language> languages = dbClient.selectAllLanguages();
            for (Language language: languages) {
                response.getWriter().println(language + "<br>");
            }
            response.getWriter().println("Successfully");
        } catch (Exception e) {
            response.getWriter().println("error: " +e.getMessage());
        }
    }
}
