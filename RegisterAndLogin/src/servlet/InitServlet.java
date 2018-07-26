package servlet;

import data.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InitServlet",loadOnStartup = 0,value = "/initList")
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();


        System.out.println("InitServlet init");

        /*创建一个集合  保存注册的用户信息*/

        List<UserBean> userBeanList=new ArrayList<>();

        getServletContext().setAttribute("userList",userBeanList);

    }
}
