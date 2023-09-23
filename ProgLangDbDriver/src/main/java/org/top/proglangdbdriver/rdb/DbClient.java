package org.top.proglangdbdriver.rdb;

import org.top.proglangdbdriver.entity.Language;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class DbClient {
    private final DbManager dbManager;

    public DbClient(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public Collection<Language> selectAllLanguages() throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "SELECT * FROM language_t";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            LinkedList<Language> languages = new LinkedList<>();

            while (result.next()) {
                Language language = readLanguageFromRow(result);
                languages.add(language);
            }
            return languages;
        }
    }

    private Language readLanguageFromRow(ResultSet result) throws SQLException {
        Integer id = result.getInt(1);
        String name = result.getString(2);
        String version = result.getString(3);
        Integer year = result.getInt(4);
        String author = result.getString(5);
        return new Language(id, name, version, year, author);
    }

    public Language selectLanguageById(Integer id) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "SELECT * FROM language_t WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return readLanguageFromRow(result);
            }
            return null;
        }
    }

    public void insertLanguage(Language language) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "INSERT INTO language_t (name_f, version_f, year_f, author_f) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, language.getName());
            preparedStatement.setString(2, language.getVersion());
            preparedStatement.setInt(3, language.getYear());
            preparedStatement.setString(4, language.getAuthor());
            executeUpdateQuery(preparedStatement);
        }
    }

    private void executeUpdateQuery(PreparedStatement preparedStatement) throws SQLException {
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected == 0) {
            throw new SQLException("0 rows affected");
        }
    }

    private void executeUpdateQuery(String sql, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected == 0) {
            throw new SQLException("0 rows affected");
        }
    }

    public void deleteLanguage(Integer id) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = "DELETE FROM language_t WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executeUpdateQuery(preparedStatement);
        }
    }

    public void updateLanguage(Language language) throws SQLException {
        try (Connection connection = dbManager.getDbConnection()) {
            String sql = String.format("UPDATE language_t SET name_f = '%s', version_f = '%s', year_f = '%d', author_f = '%s' WHERE id = %s;"
            , language.getName(), language.getVersion(), language.getYear(), language.getAuthor(), language.getId());
            executeUpdateQuery(sql, connection);
        }
    }



}
