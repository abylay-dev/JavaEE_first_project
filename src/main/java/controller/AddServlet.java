package controller;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Country;
import model.Laptop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Country> countries = DBManager.getCountries();
            request.setAttribute("countries", countries);
            request.getRequestDispatcher("/market/add.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        response.sendRedirect("/market/add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        int price = Integer.parseInt(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        String country_code = request.getParameter("country_code");

        try {
            DBManager.addProduct(new Laptop(null, model, price, count), country_code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/");
    }
}
