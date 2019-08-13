package ua.rudikc.cinema.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StaticResourcesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        String resourcePath = "/resources/";
        String pagePath = "/jsp/";
        String forwardPath = "/finalProject";
        if (path.startsWith(resourcePath) || path.startsWith(pagePath)
                || path.endsWith(forwardPath)) {
            filterChain.doFilter(request, response);
        } else {
            req.getRequestDispatcher(forwardPath + path).forward(request, response); // Goes to controller.
        }
    }
}
