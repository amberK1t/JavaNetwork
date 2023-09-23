package org.top.music_catalog.rdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    private final String dbHost;
    private final String dbUser;
    private final String dbPassword;
    private final String dbName;
    private static boolean isDriverRegistered = false;

    public DbManager(String dbHost, String dbUser, String dbPassword, String dbName) throws Exception {
        this.dbHost = dbHost;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbName = dbName;

        registerDbDriver();
    }

    private void registerDbDriver() throws Exception {
        if (!isDriverRegistered) {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            isDriverRegistered = true;
        }
    }

    public Connection getDbConnection() throws SQLException {
        String url = "jdbc:mysql://" + dbHost + "/" + dbName;
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
}
