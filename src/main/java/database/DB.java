package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
  private Connection connection;
  private Statement statement;

  public DB(String dbDriver, String dbConnection, String dbUser, String dbPassword) {
    try {
      Class.forName(dbDriver);
      connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Statement getStatement() {
    if (statement == null) {
      try {
        statement = connection.createStatement();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return statement;
  }

  public Connection getConnection() {
    return connection;
  }
}
