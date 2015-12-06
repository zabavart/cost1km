package servlets;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import crud.CalculationService;
import crud.CarMarkService;
import crud.CarModelService;
import crud.CarModificationService;
import crud.CarSerieService;
import entity.Calculation;
import model.Cost1kmModel;
import utils.DB;
import utils.Util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    response.setContentType("application/json");

    CalculationService calculationService = new CalculationService(em);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(calculationService.get());

    PrintWriter out = response.getWriter();
    out.println(json);
    out.close();
  }
}