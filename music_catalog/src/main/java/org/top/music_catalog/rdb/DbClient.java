package org.top.music_catalog.rdb;

import org.top.music_catalog.entity.Song;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class DbClient {
    private final DbManager dbManager;

    public DbClient(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    // Получение всех объектов из базы
    public Collection<Song> selectAllMusic() throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "SELECT * FROM song";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            LinkedList<Song> songs = new LinkedList<>();

            while (result.next()) {
                Song song = readSongFromRow(result);
                songs.add(song);
            }
            return songs;
        }
    }

    private Song readSongFromRow(ResultSet result) throws SQLException {
        Integer id = result.getInt(1);
        String title = result.getString(2);
        String singer = result.getString(3);
        String authorship = result.getString(4);
        Integer year = result.getInt(5);
        Integer duration = result.getInt(6);
        return new Song(id, title, singer, authorship, year, duration);
    }

    public void insertSong(Song song) throws SQLException {
        try(Connection connection = dbManager.getDbConnection()) {
            String sql = "INSERT INTO song (title_f, singer_f, authorship_f, year_f, duration_f) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, song.getTitle());
            preparedStatement.setString(2, song.getSinger());
            preparedStatement.setString(3, song.getAuthorship());
            preparedStatement.setInt(4, song.getYear());
            preparedStatement.setInt(5, song.getDuration());
            preparedStatement.executeUpdate();
        }
    }
}
