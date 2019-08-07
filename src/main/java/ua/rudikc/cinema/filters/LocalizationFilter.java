package ua.rudikc.cinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ua.rudikc.cinema.utils.Constants.*;



/*@WebFilter(
        urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "bundle",value = "text"),@WebInitParam(name = "locale",value = "en")})
*/

public class LocalizationFilter implements Filter {

    private String defaultBundle;
    private String locale;

    @Override
    public void init(FilterConfig filterConfig) {
        defaultBundle = filterConfig.getInitParameter(BUNDLE);
        locale = filterConfig.getInitParameter(LOCALE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String localeSession = (String) httpRequest.getSession().getAttribute(LOCALE);

        if (localeSession == null) {
            httpRequest.getSession().setAttribute(LOCALE, locale);
        }

        httpRequest.getSession().setAttribute(BUNDLE, defaultBundle);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
