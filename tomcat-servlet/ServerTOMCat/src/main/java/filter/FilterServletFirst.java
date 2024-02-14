package filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class FilterServletFirst implements Filter {
    public FilterServletFirst() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("FilterServletFirst is start at : " + new Date().toString());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterServletFirst is start at : " + new Date().toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("FilterServletFirst destroy");
    }
}
