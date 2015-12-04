package servlets;

import crud.AuthorService;
import crud.CalculationService;
import entity.Author;
import entity.Calculation;
import utils.DB;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculations")
public class CalculationServlet extends HttpServlet {
  EntityManager em = DB.getEntityManager();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    AuthorService authorService = new AuthorService(em);
//    Author author = authorService.get(45);
//
//    CalculationService calculationService = new CalculationService(em);
//    Calculation calculation = new Calculation();
//    calculation.setAuthor(author);
//    calculation.setCarId(5233);
//    calculationService.merge(calculation);
//
//    calculation = new Calculation();
//    calculation.setAuthor(author);
//    calculation.setCarId(5860);
//    calculationService.merge(calculation);

    CalculationService calculationService = new CalculationService(em);
    List<Calculation> calculationList = calculationService.get();
  }
}