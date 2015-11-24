package servlets;

import crud.CostService;
import crud.UserService;
import entity.Cost;
import entity.User;

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

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();
    costService = new CostService(em);
    userService = new UserService(em);

    User user = new User();
    user.setName("test");
    userService.add(user);
//    Cost cost = new Cost();
//    cost.setBenzine(1);
//    cost.setCarPrice(2);
//    cost.setMilesOn(3);
//    cost.setOtherExpenses(4);
//    cost.setSellingPrice(5);
//    costService.add(cost);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}