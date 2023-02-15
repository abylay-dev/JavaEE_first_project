package controller;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Laptop;

import java.io.IOException;

@WebServlet(name = "ProductDetailServlet", value = "/details")
public class ProductDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Laptop laptop = DBManager.getLaptop(id);

        if (laptop == null) {
            request.getRequestDispatcher("/market/error.jsp").forward(request, response);
        }

        request.setAttribute("laptop", laptop);
        request.getRequestDispatcher("/market/details.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
