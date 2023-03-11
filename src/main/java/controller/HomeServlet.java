package controller;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Laptop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //list of products
        List<Laptop> laptops = null;
        try {
            laptops = DBManager.getLaptops();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        HttpSession session = request.getSession();



        if (session.getAttribute("welcome") != null) {
            session.removeAttribute("welcome");
        } else {
            session.setAttribute("welcome", "hello Session from Servlet");
        }

        Cookie[] cookies = request.getCookies();
        /*for (Cookie c : cookies) {
            if (c.getName() == "card") {
                try {
                    DBManager.getLaptop(Integer.parseInt(c.getValue()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }*/

        request.setAttribute("nouts", laptops);
        request.getRequestDispatcher("/market/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
