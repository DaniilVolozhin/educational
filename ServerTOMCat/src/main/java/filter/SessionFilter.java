package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter("/session")
public class SessionFilter implements Filter {
    public SessionFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println(this.getClass().getSimpleName() + " is start at : " + new Date().toString());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(this.getClass().getSimpleName() + " is start at : " + new Date().toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + " destroy");
    }
}
