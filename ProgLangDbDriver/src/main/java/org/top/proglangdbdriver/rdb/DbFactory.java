package org.top.proglangdbdriver.rdb;

public class DbFactory {
    public static DbManager prepareDbManager() throws Exception {
        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String dbName = "programming_languages";
        return new DbManager(host, user, password, dbName);
    }

    public static DbClient prepareDbClient() throws Exception {
        return new DbClient(prepareDbManager());
    }
}
