package servlet;

import data.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        /*获取账号和密码*/
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");

        List<UserBean> userList = (List<UserBean>) getServletContext().getAttribute("userList");
        UserBean user = null;
        /*遍历集合中的user*/
        for (UserBean userBean : userList) {
            if (userBean.getAccount().equals(account)) {
                user = userBean;
            }
        }

        /*没找到说明该账号未注册*/
        if (user == null) {
            response.getWriter().write("该账号未注册");
        } else {

            if (pwd.equals(user.getPwd())) {
                /*密码正确，登录成功，将数据存入session*/
                request.getSession().setAttribute("user", user);
                /*跳转到loginSuccess.jsp*/
                getServletContext().getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
            }else {
                response.getWriter().write("账号或密码错误");
            }


        }

    }
}
