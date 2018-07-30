package servlet;

import com.google.gson.Gson;
import data.LoginResponse;

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

        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");

        LoginResponse loginResponse = new LoginResponse();

        if (account.equals("yzq") && pwd.equals("123456")) {
            /*返回登录成功*/
            loginResponse.setFig("0");
            loginResponse.setMsg("登录成功");
        } else {
            loginResponse.setFig("-1");
            loginResponse.setMsg("登录失败");
        }


        /*将实体类转成json*/
        String result = new Gson().toJson(loginResponse);
        System.out.println("返回的结果：" + result);


        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(result);

    }
}
