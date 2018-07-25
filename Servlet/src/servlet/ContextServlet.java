package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextServlet",initParams = {@WebInitParam(name = "user",value = "yzq")})
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletContext context=getServletContext();//获取ServletContext
        String path = context.getContextPath();//获取项目路径
        context.setAttribute("","");
        context.getAttribute("");
        context.setInitParameter("","");
        context.getInitParameter("");

        System.out.println(path);
    }
}
