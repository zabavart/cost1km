package servlets;

import crud.CostService;
import entity.Cost;

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

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();
    costService = new CostService(em);
    Cost cost = new Cost();
    cost.setBenzine(1);
    cost.setCarPrice(2);
    cost.setMilesOn(3);
    cost.setOtherExpenses(4);
    cost.setSellingPrice(5);
    costService.add(cost);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}