package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "ABFilter",urlPatterns = "*.jsp",
        dispatcherTypes = {DispatcherType.ASYNC,DispatcherType.ERROR})
public class ABFilter implements Filter {
    private String filterName;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(filterName + "  doFilter()");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        filterName= config.getFilterName();
        System.out.println("过滤器名称：" + filterName +" init");
    }

}
