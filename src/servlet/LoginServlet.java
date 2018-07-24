package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);//所有的post请求交由doGet处理

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("doGet");

        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");

        System.out.println("account" + account + ",pwd" + pwd);

        if (account.equals("yzq") && pwd.equals("123")) {
            request.getRequestDispatcher("/login/success.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/login/fail.jsp").forward(request,response);
        }
    }


}
