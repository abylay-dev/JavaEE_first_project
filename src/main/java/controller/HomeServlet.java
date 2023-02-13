package controller;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Laptop;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //list of products
        List<Laptop> laptops = DBManager.getLaptops();

        request.setAttribute("nouts", laptops);
        request.getRequestDispatcher("/market/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
