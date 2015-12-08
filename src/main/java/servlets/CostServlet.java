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
      calculation = calculations.get(0);
      cost.setId(costService.getByCalculation(calculation).get(0).getId());
    } else {
      calculation.setUser(user);
      calculation.setCarModification(carModification);
      calculation = calculationService.merge(calculation);
    }

    cost.setCalculation(calculation);
    cost.setPrice(Integer.valueOf(request.getParameter("price")));
    cost.setSellingPrice(Integer.valueOf(request.getParameter("sellingPrice")));
    cost.setMilesOn(Integer.valueOf(request.getParameter("milesOn")));
    cost.setBenzine(Integer.valueOf(request.getParameter("benzine")));
    cost.setRepairs(Integer.valueOf(request.getParameter("repairs")));
    cost.setService(Integer.valueOf(request.getParameter("service")));
    cost.setCredit(Integer.valueOf(request.getParameter("credit")));
    cost.setKasko(Integer.valueOf(request.getParameter("kasko")));
    cost.setOsago(Integer.valueOf(request.getParameter("osago")));
    cost.setTax(Integer.valueOf(request.getParameter("tax")));
    cost.setPenalty(Integer.valueOf(request.getParameter("penalty")));
    cost.setParking(Integer.valueOf(request.getParameter("parking")));
    cost.setOtherExpenses(Integer.valueOf(request.getParameter("otherExpenses")));
    costService.merge(cost);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}