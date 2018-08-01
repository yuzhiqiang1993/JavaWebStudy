package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener(value = "RequestListener")
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("新增了request属性"+srae.getName()+":"+srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("移除了request属性"+srae.getName()+":"+srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("修改了request属性"+srae.getName()+":"+srae.getValue());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request销毁了");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        System.out.println("创建了一个request");
    }
}
