package org.top.music_catalog.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.top.music_catalog.entity.Song;
import org.top.music_catalog.rdb.DbClient;
import org.top.music_catalog.rdb.DbFactory;

import java.io.IOException;
import java.security.InvalidParameterException;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {
    private DbClient dbClient;
    @Override
    public void init() {
        try {
            dbClient = DbFactory.prepareClient();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            String title = request.getParameter("title");
            String singer = request.getParameter("singer");
            String authorship = request.getParameter("authorship");
            Integer year = Integer.valueOf(request.getParameter("year"));
            Integer duration = Integer.valueOf(request.getParameter("duration"));
            if (title == null || singer == null || authorship == null || year == null || duration == null) {
                throw new InvalidParameterException("One or more request params is null");
            }
            Song newSong = new Song(title, singer, authorship, year, duration);
            dbClient.insertSong(newSong);
            response.getWriter().println("successfully");
        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }

    }
}
