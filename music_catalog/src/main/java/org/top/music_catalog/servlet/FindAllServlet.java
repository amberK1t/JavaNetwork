package org.top.music_catalog.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.top.music_catalog.entity.Song;
import org.top.music_catalog.rdb.DbClient;
import org.top.music_catalog.rdb.DbFactory;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "FindAll", value = "/find-all")
public class FindAllServlet extends HttpServlet {

    private DbClient dbClient;

    @Override
    public void init() {
        try {
            dbClient = DbFactory.prepareClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            Collection<Song> songs = dbClient.selectAllMusic();
            for (Song song: songs) {
                response.getWriter().println(song + "<br>");
            }

        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }

    }
}
