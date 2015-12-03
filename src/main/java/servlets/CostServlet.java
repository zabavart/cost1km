package servlets;

import crud.*;
import entity.*;
import model.Cost1kmModel;
import utils.DB;
import utils.Util;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CostServlet extends HttpServlet {
  EntityManager em = DB.getEntityManager();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserService userService = new UserService(em);
    UserCarService userCarService = new UserCarService(em);
    PeriodService periodService = new PeriodService(em);
    CostService costService = new CostService(em);

    User user = new User();
    user.setId(17);//todo подтягивать с клиента
    user.setName("test");//todo подтягивать с клиента
    userService.merge(user);

    UserCar userCar = new UserCar();
    userCar.setId(36); //todo подтягивать с клиента
    userCar.setUserId(17); //todo подтягивать с клиента
    userCar.setCarId(Integer.valueOf(request.getParameter("carSerieId")));
    userCarService.merge(userCar);

    ArrayList<Period> periods = new ArrayList<Period>(); //todo подтягивать с клиента
    periods.add(new Period());
    for (Period period : periods) {
      period.setId(34); //todo подтягивать с клиента
      period.setTypePeriodId(33); //todo подтягивать с клиента
      period.setUserCarId(Integer.valueOf(request.getParameter("carSerieId")));
      periodService.merge(period);

      Cost cost = new Cost();
      cost.setId(40);
      //todo подтягивать с клиента
      cost.setPeriodId(34);
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
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserCarService userCarService = new UserCarService(em);
    userCarService.get();
//    Cost cost = new Cost();
  }
}