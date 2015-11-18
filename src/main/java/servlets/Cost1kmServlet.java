package servlets;

import crud.CarModelService;
import crud.CarMarkService;
import model.Cost1kmModel;

import org.json.simple.JSONObject;

import utils.Util;

import java.io.IOException;
import java.io.PrintWriter;

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
    model.setCarMarkId(Util.parseInt(request.getParameter("carMarkId")));
    model.setCarModelId(Util.parseInt(request.getParameter("carModelId")));
    model.setCarSerieId(Util.parseInt(request.getParameter("carSerieId")));
    model.setCarModificationId(Util.parseInt(request.getParameter("carModificationId")));
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
    jsonObject.put("carMarkList", carMarkService.getAll());

    if (model.getCarMarkId() != 0) {
      jsonObject.put("carModelList", carModelService.getAllByCarMarkId(model.getCarMarkId()));
    }

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

    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }
}