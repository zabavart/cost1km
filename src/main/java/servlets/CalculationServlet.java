package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.CalculationService;
import crud.CostService;
import entity.Calculation;
import utils.DB;
import utils.Util;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculations/*")
public class CalculationServlet extends HttpServlet {
  EntityManager em = DB.getEntityManager();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");
    String json;
    ObjectMapper objectMapper = new ObjectMapper();
    CalculationService calculationService = new CalculationService(em);

    if (request.getPathInfo() == null) {
      json = objectMapper.writeValueAsString(calculationService.get());
    } else {
      CostService costService = new CostService(em);
      Integer calculationId = Util.parseInt(request.getPathInfo().substring(1));
      Calculation calculation = calculationService.get(calculationId);
      json = objectMapper.writeValueAsString(costService.getByCalculation(calculation));
    }

    PrintWriter out = response.getWriter();
    out.println(json);
    out.close();
  }
}