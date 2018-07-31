package servlet;

import com.google.gson.Gson;
import data.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        System.out.println("LoginServlet doGet");

        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        response.setContentType("application/json;charset=utf-8");
        if (account.equals("yzq") && pwd.equals("123")) {
            /*登录成功*/

            Cookie accountCookie = new Cookie("account", account);
            Cookie pwdCookie = new Cookie("pwd", pwd);
            response.addCookie(accountCookie);
            response.addCookie(pwdCookie);
            LoginBean loginBean = new LoginBean("1", "登录成功");
            String result = new Gson().toJson(loginBean);
            response.getWriter().write(result);

            //System.out.println("账号密码正确，跳转到首页");
            // request.getRequestDispatcher("/index.jsp").forward(request,response);


        } else {
            /*登录失败*/

            LoginBean loginBean = new LoginBean("-1", "登录失败");
            String result = new Gson().toJson(loginBean);
            response.getWriter().write(result);
        }

    }
}
