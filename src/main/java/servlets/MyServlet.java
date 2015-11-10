package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/s")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int price = Integer.parseInt(request.getParameter("price"));
        int milesOn = Integer.parseInt(request.getParameter("milesOn"));
        int benzine = Integer.parseInt(request.getParameter("benzine"));
        int otherExpenses = Integer.parseInt(request.getParameter("otherExpenses"));
        int sellingPrice = Integer.parseInt(request.getParameter("sellingPrice"));

        int cost = price + benzine + otherExpenses - sellingPrice;
        Cost1km cost1km = new Cost1km(cost, milesOn);

        request.setAttribute("price", price);
        request.setAttribute("milesOn", milesOn);
        request.setAttribute("benzine", benzine);
        request.setAttribute("otherExpenses", otherExpenses);
        request.setAttribute("sellingPrice", sellingPrice);
        request.setAttribute("cost1km", cost1km.calc());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("price", 500000);
        request.setAttribute("milesOn", 220000);
        request.setAttribute("benzine", 400000);
        request.setAttribute("otherExpenses", 200000);
        request.setAttribute("sellingPrice", 300000);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}