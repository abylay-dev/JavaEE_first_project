import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        String fullname = name + " " + lastname;

        System.out.println(fullname);

        /*PrintWriter out = response.getWriter();
        out.println("<h1>" + name + " " + lastname + "</h1>");
        out.println("<a href=\"/\">Home</a>");
        out.flush();*/

//        request.setAttribute("fio", fullname);
//        request.getRequestDispatcher("/details.jsp").forward(request, response);

//        response.sendRedirect("/details.jsp?fullname=" + fullname);
        response.sendRedirect("https://metanit.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
