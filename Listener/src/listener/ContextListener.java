package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener(value = "servletContextListener")
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        /*添加属性时调用*/
        System.out.println("新增的属性："+scae.getName()+":"+scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        /*属性移除时调用*/
        System.out.println("移除的属性："+scae.getName()+":"+scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        /*属性替换时调用（修改值）*/
        System.out.println("替换的属性："+scae.getName()+":"+scae.getValue());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*servletContext创建时调用*/
        System.out.println("项目启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /*servletContext销毁时调用*/
        System.out.println("项目停止了");
    }
}
