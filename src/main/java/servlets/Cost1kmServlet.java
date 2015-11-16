package servlets;

import database.DbConnection;
import database.Query;
import model.Cost1kmModel;
import utils.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s")
public class Cost1kmServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");

    Cost1kmModel model = new Cost1kmModel();
    model.setCarMark(Util.parseInt(request.getParameter("carMark")));
    model.setCarModel(Util.parseInt(request.getParameter("carModel")));
    model.setCarSerie(Util.parseInt(request.getParameter("carSerie")));
    model.setCarModification(Util.parseInt(request.getParameter("carModification")));
    model.setCost(Util.parseInt(request.getParameter("cost")));
    model.setPrice(Util.parseInt(request.getParameter("price")));
    model.setMilesOn(Util.parseInt(request.getParameter("milesOn")));
    model.setBenzine(Util.parseInt(request.getParameter("benzine")));
    model.setOtherExpenses(Util.parseInt(request.getParameter("otherExpenses")));
    model.setSellingPrice(Util.parseInt(request.getParameter("sellingPrice")));

    System.out.println("!!!!!! " + model.getBenzine());
    int cost = model.getPrice() + model.getBenzine() + model.getOtherExpenses() - model.getSellingPrice();
    System.out.println("!!3434!!!!");
    System.out.println(cost);
    System.out.println(model.getMilesOn());
    Cost1km cost1km = new Cost1km(cost, model.getMilesOn());

    PrintWriter out = response.getWriter();
    out.println(cost1km.calc()) ;
    out.close();
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
      request.setAttribute("carMarkList", getCarMark());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      request.setAttribute("carModelList", getCarModel());
    } catch (SQLException e) {
      e.printStackTrace();
    }


    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }

  private HashMap<String, String> getCarMark() throws SQLException {
    DbConnection dbConnection = new DbConnection();
    ResultSet result1 = dbConnection.getStatement().executeQuery(Query.car_mark);
    HashMap<String, String> map = new HashMap<String, String>();
    while (result1.next()) {
      map.put(result1.getString("id_car_mark"), result1.getString("name"));
    }
    dbConnection.getStatement().close();
    return map;
  }

  private HashMap<String, String> getCarModel() throws SQLException {
    DbConnection dbConnection = new DbConnection();
    Statement statement = dbConnection.getStatement();
    ResultSet result1 = statement.executeQuery(Query.car_model);
    HashMap<String, String> map = new HashMap<String, String>();
    while (result1.next()) {
      map.put(result1.getString("id_car_model"), result1.getString("name"));
    }
    dbConnection.getStatement().close();
    return map;
  }
}