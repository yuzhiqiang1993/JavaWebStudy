package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String account=request.getParameter("account");
        String pwd=request.getParameter("pwd");


        if (account.equals(getServletContext().getAttribute("account"))&&pwd.equals(getServletContext().getAttribute("pwd"))){
            /*登录成功*/

            request.getSession().setAttribute("account",account);

            request.getRequestDispatcher("/loginSuccess.jsp").forward(request,response);
        }




    }
}
