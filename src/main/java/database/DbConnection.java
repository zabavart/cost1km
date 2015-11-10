package database;

import java.sql.Connection;
import java.sql.Statement;

public class DbConnection {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://62.109.31.150:5432/cost1km";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "q";
    private DB db;

    public DbConnection() {
        db = new DB(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
    }

    public Statement getStatement() {
        return db.getStatement();
    }
}
