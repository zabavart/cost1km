package servlets;

import crud.*;
import entity.*;
import model.Cost1kmModel;
import utils.Util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class SaveServlet extends HttpServlet {
  CostService costService;
  UserService userService;
  PeriodService periodService;
  TypePeriodService typePeriodServic;
  UserCarService userCarService;

  public SaveServlet() {
    EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();

    typePeriodServic = new TypePeriodService(em);
    periodService = new PeriodService(em);



  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("!!! " + typePeriodServic.get(33));

    Period period = new Period();
    period.setTypePeriodId(33);
    period.setUserCarId(Integer.valueOf(request.getParameter("carSerieId")));
    periodService.add(period);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}