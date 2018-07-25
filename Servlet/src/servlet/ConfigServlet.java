package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "configServlet",urlPatterns = "/configServlet",
        initParams = {
                @WebInitParam(name = "charset", value = "utf-8"),
                @WebInitParam(name = "userName", value = "yzq")
        })
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config = getServletConfig();//获取ServletConfig对象
        String name = config.getServletName();//获取servlet名称

        /*获取初始化参数*/
        String charset = config.getInitParameter("charset");
        String userName = config.getInitParameter("userName");

        System.out.println("ServletName:" + name);
        System.out.println("charset:" + charset);
        System.out.println("userName:" + userName);

    }

}
