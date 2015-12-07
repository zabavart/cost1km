package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import crud.*;
import entity.Cost;
import model.Cost1kmModel;

import utils.DB;
import utils.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
  private EntityManager em = DB.getEntityManager();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");
    CarMarkService carMarkService = new CarMarkService(em);
    CarModelService carModelService = new CarModelService(em);
    CarSerieService carSerieService = new CarSerieService(em);
    CarModificationService carModificationService = new CarModificationService(em);

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

    ObjectMapper objectMapper = new ObjectMapper();
    Map<String,Object> userData = new HashMap<String,Object>();

    userData.put("cost1km", cost1km.calc());
    userData.put("carMarkList", carMarkService.get());

    if (model.getCarMarkId() != 0) {
      userData.put("carModelList", carModelService.getByCarMarkId(model.getCarMarkId()));
    }

    if (model.getCarModelId() != 0) {
      userData.put("carSerieList", carSerieService.getAllByCarModelId(model.getCarModelId()));
    }

    if (model.getCarSerieId() != 0) {
      userData.put("carModificationList", carModificationService.getAllByCarSerieId(model.getCarSerieId()));
    }

    String json = new ObjectMapper().writeValueAsString(userData);
    System.out.println("!!!!! " + json);
    PrintWriter out = response.getWriter();
    out.println(json);
    out.close();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    CostService costService = new CostService(em);
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