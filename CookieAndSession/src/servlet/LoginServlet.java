package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");

        String isRemember = request.getParameter("remember");

        System.out.println("account=" + account);
        System.out.println("pwd=" + pwd);
        System.out.println("isRemember=" + isRemember);
        if (isRemember != null) {
            Cookie cookie = new Cookie("account", account);//保存账号数据
            cookie.setMaxAge(60 * 60 * 24);//cookie存在在本地的有效时长（单位为秒） 默认为-1  表示页面关闭cookie就失效
            response.addCookie(cookie);//添加到response
            Cookie pwdCookie = new Cookie("pwd", pwd);
            pwdCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(pwdCookie);
        }

    }
}
