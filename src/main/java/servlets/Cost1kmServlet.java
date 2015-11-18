package servlets;

import crud.CarModelService;
import crud.CarMarkService;
import entity.CarMark;
import entity.CarModel;
import model.Cost1kmModel;


import org.json.simple.JSONObject;
import utils.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s")
public class Cost1kmServlet extends HttpServlet {
  private CarMarkService carMarkService;
  private CarModelService carModelService;



  public Cost1kmServlet() {
    EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();
    carMarkService = new CarMarkService(em);
    carModelService = new CarModelService(em);
  }

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

    int cost = model.getPrice() + model.getBenzine() + model.getOtherExpenses() - model.getSellingPrice();
    Cost1km cost1km = new Cost1km(cost, model.getMilesOn());

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("cost1km", cost1km.calc());

    PrintWriter out = response.getWriter();
    out.println(jsonObject);
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

    request.setAttribute("carMarkList", getCarMark());
    request.setAttribute("carModelList", getCarModel());

    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }

  private HashMap<String, String> getCarMark()  {
    List<CarMark> carMarkList = carMarkService.getAll();

    HashMap<String, String> map = new HashMap<String, String>();
    for (CarMark carMark : carMarkList) {
      map.put(String.valueOf(carMark.getIdCarMark()), carMark.getName());
    }

    return map;
  }

  private HashMap<String, String> getCarModel()  {
    List<CarModel> carModelList = carModelService.getAll();
    HashMap<String, String> map = new HashMap<String, String>();
    for (CarModel carModel : carModelList) {
      map.put(String.valueOf(carModel.getIdCarModel()), carModel.getName());
    }
    return map;
  }

  private HashMap<String, String> getCarModel(int idCarMark)  {
    HashMap<String, String> map = new HashMap<String, String>();
//    List<CarModel> carModelList = carModelService.get(idCarMark);
//    while (resultSet.next()) {
//      map.put(resultSet.getString("id_car_model"), resultSet.getString("name"));
//    }
//    dbConnection.getStatement().close();
    return map;
  }
}