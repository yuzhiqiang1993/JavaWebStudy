package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();//获取session,没有则创建

        String sessionId = session.getId();//获取sessionId,该id默认会在首次访问服务器时回写给客户端的response中

        long createTime = session.getCreationTime();//获取session创建的时间

        long lastTime = session.getLastAccessedTime();//最后一次修改session的时间
        session.setMaxInactiveInterval(1*60*60);



        System.out.println("sessionId="+sessionId);
        System.out.println("createTime="+createTime);
        System.out.println("lastTime="+lastTime);
    }
}
