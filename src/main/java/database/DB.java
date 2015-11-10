package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private String dbDriver;
    private String dbConnection;
    private String dbUser;
    private String dbPassword;
    private Connection connection;
    private Statement statement;

    public DB(String dbDriver, String dbConnection, String dbUser, String dbPassword) {
        this.dbDriver = dbDriver;
        this.dbConnection = dbConnection;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public Statement getStatement() {
        if (statement == null) {
            try {
                Class.forName(dbDriver);
                connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }
}
