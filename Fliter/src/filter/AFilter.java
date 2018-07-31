package filter;

import javax.servlet.*;
import java.io.IOException;

public class AFilter implements Filter {
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
