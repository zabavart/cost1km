package servlets;

import crud.*;
import entity.Cost;
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

@WebServlet("/calc")
public class Cost1kmServlet extends HttpServlet {
  private CarMarkService carMarkService;
  private CarModelService carModelService;
  private CarSerieService carSerieService;
  private CarModificationService carModificationService;
  private CostService costService;

  public Cost1kmServlet() {
    EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();
    carMarkService = new CarMarkService(em);
    carModelService = new CarModelService(em);
    carSerieService = new CarSerieService(em);
    carModificationService = new CarModificationService(em);
    costService = new CostService(em);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");

    Cost1kmModel model = new Cost1kmModel();
    model.setCarMarkId(Util.parseInt(request.getParameter("carMarkId")));
    model.setCarModelId(Util.parseInt(request.getParameter("carModelId")));
    model.setCarSerieId(Util.parseInt(request.getParameter("carSerieId")));
    model.setCarModificationId(Util.parseInt(request.getParameter("carModificationId")));
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

    if (model.getCarModelId() != 0) {
      jsonObject.put("carSerieList", carSerieService.getAllByCarModelId(model.getCarModelId()));
    }

    if (model.getCarSerieId() != 0) {
      jsonObject.put("carModificationList", carModificationService.getAllByCarSerieId(model.getCarSerieId()));
    }

    PrintWriter out = response.getWriter();
    out.println(jsonObject);
    out.close();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    Cost cost = costService.get(40);
    request.setAttribute("price", cost.getPrice());
    request.setAttribute("sellingPrice", cost.getSellingPrice());
    request.setAttribute("milesOn", cost.getMilesOn());
    request.setAttribute("benzine", cost.getBenzine());
    request.setAttribute("repairs", cost.getRepairs());
    request.setAttribute("service", cost.getService());
    request.setAttribute("credit", cost.getCredit());
    request.setAttribute("kasko", cost.getKasko());
    request.setAttribute("osago", cost.getOsago());
    request.setAttribute("tax", cost.getTax());
    request.setAttribute("penalty", cost.getPenalty());
    request.setAttribute("parking", cost.getParking());
    request.setAttribute("otherExpenses", cost.getOtherExpenses());

    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }
}