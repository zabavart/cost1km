package servlets;

import crud.CostService;
import crud.PeriodService;
import crud.UserCarService;
import crud.UserService;
import entity.Cost;
import entity.Period;
import entity.User;
import entity.UserCar;
import utils.DB;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {
  EntityManager em = DB.getEntityManager();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserCarService userCarService = new UserCarService(em);
//    System.out.println(userCarService.get());
  }
}