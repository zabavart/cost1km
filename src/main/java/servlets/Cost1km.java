package servlets;

import database.DbConnection;
import database.Query;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Statement;

public class Cost1km {
    long cost;
    long milesOn;

    public Cost1km(long cost, long milesOn)  {
        this.cost = cost;
        this.milesOn = milesOn;
//        try {
//            createDbUserTable();
//        } catch (SQLException e) {
//            System.out.println("@@@@@@@@@@");
//            e.printStackTrace();
//        }
    }

    public float calc() {
        float cost1km  = cost / (float)milesOn;
        cost1km = new BigDecimal(cost1km).setScale(2, RoundingMode.UP).floatValue();
        return cost1km;
    }

    private void createDbUserTable() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Statement statement = dbConnection.getStatement();
        statement.execute(Query.createTableSQL);
        statement.close();
    }


}
