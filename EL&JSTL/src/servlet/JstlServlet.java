package servlet;

import data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JstlServlet",urlPatterns = "/jstl")
public class JstlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            users.add(new User("yzq", i));
        }


        request.setAttribute("users", users);
        request.getRequestDispatcher("/jstl.jsp").forward(request, response);

    }
}
