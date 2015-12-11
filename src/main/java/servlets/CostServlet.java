package servlets;

import crud.*;
import entity.*;
import model.Cost1kmModel;
import utils.DB;
import utils.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/costs")
public class CostServlet extends HttpServlet {
  EntityManager em = DB.getEntityManager();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserService userService = new UserService(em);
    CalculationService calculationService = new CalculationService(em);
    PeriodService periodService = new PeriodService(em);
    TypePeriodService typePeriodService = new TypePeriodService(em);
    CostService costService = new CostService(em);
    CarModificationService carModificationService = new CarModificationService(em);

    User user = userService.get(45); //todo подтягивать с клиента
    CarModification carModification = carModificationService.get(Integer.valueOf(request.getParameter("carModificationId")));

    List<Calculation> calculations = calculationService.getByUserAndCarModification(carModification, user);
    Cost cost = new Cost();

    Calculation calculation = new Calculation();
    if (calculations.size() > 0) {
      //old car
      calculation = calculations.get(0);
      cost.setId(costService.getByCalculation(calculation).get(0).getId());
    } else {
      //new car
      calculation.setUser(user);
      calculation.setCarModification(carModification);
      calculation = calculationService.merge(calculation);
    }

    cost.setCalculation(calculation);
    cost.setPrice(Util.parseInt(request.getParameter("price")));
    cost.setSellingPrice(Util.parseInt(request.getParameter("sellingPrice")));
    cost.setMilesOn(Util.parseInt(request.getParameter("milesOn")));
    cost.setBenzine(Util.parseInt(request.getParameter("benzine")));
    cost.setRepairs(Util.parseInt(request.getParameter("repairs")));
    cost.setService(Util.parseInt(request.getParameter("service")));
    cost.setCredit(Util.parseInt(request.getParameter("credit")));
    cost.setKasko(Util.parseInt(request.getParameter("kasko")));
    cost.setOsago(Util.parseInt(request.getParameter("osago")));
    cost.setTax(Util.parseInt(request.getParameter("tax")));
    cost.setPenalty(Util.parseInt(request.getParameter("penalty")));
    cost.setParking(Util.parseInt(request.getParameter("parking")));
    cost.setOtherExpenses(Util.parseInt(request.getParameter("otherExpenses")));
    costService.merge(cost);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}