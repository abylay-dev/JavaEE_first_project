package controller;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Laptop;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductDetailServlet", value = "/details")
public class ProductDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Laptop laptop = null;
        try {
            laptop = DBManager.getLaptop(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (laptop == null) {
            request.getRequestDispatcher("/market/error.jsp").forward(request, response);
        }

        request.setAttribute("laptop", laptop);
        request.getRequestDispatcher("/market/details.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String model = request.getParameter("model");
        int price = Integer.parseInt(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        String country_code = request.getParameter("country_code");

        try {
            DBManager.updateProduct(new Laptop(null, model, price, count), country_code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/");
    }
}
