package servlets;

import database.DbConnection;
import database.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/s")
public class Cost1kmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int price = Integer.parseInt(request.getParameter("price"));
        int milesOn = Integer.parseInt(request.getParameter("milesOn"));
        int benzine = Integer.parseInt(request.getParameter("benzine"));
        int otherExpenses = Integer.parseInt(request.getParameter("otherExpenses"));
        int sellingPrice = Integer.parseInt(request.getParameter("sellingPrice"));

        int cost = price + benzine + otherExpenses - sellingPrice;
        Cost1km cost1km = new Cost1km(cost, milesOn);

        request.setAttribute("price", price);
        request.setAttribute("milesOn", milesOn);
        request.setAttribute("benzine", benzine);
        request.setAttribute("otherExpenses", otherExpenses);
        request.setAttribute("sellingPrice", sellingPrice);
        request.setAttribute("cost1km", "Стоимость 1 км = " + cost1km.calc() + " руб.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("price", 500000);
        request.setAttribute("milesOn", 220000);
        request.setAttribute("benzine", 400000);
        request.setAttribute("otherExpenses", 200000);
        request.setAttribute("sellingPrice", 300000);

        try {
            request.setAttribute("list", getCarMark());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private ArrayList<String> getCarMark() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Statement statement = dbConnection.getStatement();
        ResultSet result1 = statement.executeQuery(Query.car_mark);
        ArrayList<String> list = new ArrayList<String>();
        while (result1.next()) {
            list.add(result1.getString("name"));
        }
        statement.close();
        return list;
    }
}