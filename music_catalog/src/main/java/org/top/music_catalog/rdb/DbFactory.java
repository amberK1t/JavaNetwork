package org.top.music_catalog.rdb;

public class DbFactory {
    public static DbManager prepareDbManager() throws Exception {
        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String dbName = "music_catalog";
        return new DbManager(host, user, password, dbName);
    }

    public static DbClient prepareClient() throws Exception {
        return new DbClient(prepareDbManager());
    }
}
